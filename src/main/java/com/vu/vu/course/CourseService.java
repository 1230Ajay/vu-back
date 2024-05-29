package com.vu.vu.course;

import com.vu.vu.dtos.dto_conversion.request.EnrollStudent;
import com.vu.vu.dtos.dto_conversion.response.CourseResponse;
import com.vu.vu.dtos.dto_conversion.response.UserResponse;
import com.vu.vu.dtos.dto_conversion.response.VideoResponse;
import com.vu.vu.dtos.response_dto.CourseResponseDto;
import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.dtos.response_dto.VideosResponseDto;
import com.vu.vu.global.GlobalService;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageRepository;
import com.vu.vu.user.User;
import com.vu.vu.user.UserRepository;
import com.vu.vu.vidoes.Video;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class CourseService {

    private final CourseResponse courseResponse;
    private final VideoResponse videoResponse;
    private final UserResponse userResponse;
    private final CourseRepository courseRepository;
    private  final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final GlobalService globalService;
    public CourseService(CourseResponse courseResponse, VideoResponse videoResponse, UserResponse userResponse, CourseRepository courseRepository, ImageRepository imageRepository, UserRepository userRepository, GlobalService globalService) {
        this.courseResponse = courseResponse;
        this.videoResponse = videoResponse;
        this.userResponse = userResponse;
        this.courseRepository = courseRepository;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
        this.globalService = globalService;
    }


    public UserResponeDto toUserDto(User user){
        return userResponse.toUserDto(user);
    }

    private VideosResponseDto videosResponseDto(Video video){
        return videoResponse.videosResponseDto(video);
    }

    private CourseResponseDto toCourseResponseDto(Course course){
        return courseResponse.toCourseResponseDto(course);
    }

    public List<CourseResponseDto> courseResponseDtoList(){
        return courseRepository.findAll().stream().map(this::toCourseResponseDto).collect(Collectors.toList());
    }

    public CourseResponseDto getCourseById(UUID uid){
        return courseResponse.toCourseResponseDto(courseRepository.findById(uid).orElseThrow());
    }


    public String addCourse(Course course, Image image) {
        // Save the image
        Image img = imageRepository.save(image);
        course.setImage(img);

        // Get the authenticated user
        User user = globalService.getAuthenticatedUser();
        if (user == null) {
            System.out.println("user not found");
            throw new RuntimeException("User not found");
        }

        // Set the author of the course
        course.setAuthor(user);

        // Save the course
        courseRepository.save(course);

        return "Course added successfully";
    }
    public String deleteCourse(UUID uid){
        courseRepository.deleteById(uid);
        return "course deleted" + uid;
    }

    public List<VideosResponseDto> getCourseVideos(UUID uid){
        Course course = courseRepository.findById(uid).orElseThrow();
        return course.getVideoList().stream().map(this::videosResponseDto).collect(Collectors.toList());
    }

    public UserResponeDto getAuthorUser(UUID uid){
      Course course=  courseRepository.findById(uid).orElseThrow();
        return userResponse.toUserDto(course.getAuthor());
    }


    public String enrollStudentInCourse(EnrollStudent enrollStudent){
        User student = userRepository.findById(enrollStudent.getStudent()).orElse(null);
        Course course = courseRepository.findById(enrollStudent.getCourse()).orElse(null);
        if (student != null && course != null) {
            // Add the course to the student's enrolled courses
            if(!course.getStudents().contains(student)){
                course.getStudents().add(student);
            }else {
                return "You are allready registerd for this course";
            }
            courseRepository.save(course); // Update the student in the database
            return "Congratulations, you have been enrolled in the course!";
        } else {
            return "Failed to enroll. Student or course not found.";
        }
    }


    public List<UserResponeDto> getAllStudentForCourse(UUID uid){
        return courseRepository.findById(uid).orElseThrow().getStudents().stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public List<CourseResponseDto> searchCourses(String keyword) {
        Sort sort = Sort.by(
                Sort.Order.asc("name").nullsLast(),
                Sort.Order.asc("description").nullsLast()
        );
        return courseRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword,sort).stream().map(this::toCourseResponseDto).collect(Collectors.toList());
    }


}
