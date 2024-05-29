package com.vu.vu.course;


import com.vu.vu.dtos.dto_conversion.request.EnrollStudent;
import com.vu.vu.dtos.response_dto.CourseResponseDto;
import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.dtos.response_dto.VideosResponseDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageService;
import com.vu.vu.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private  final ImageService imageService;

    public CourseController(CourseService courseService, ImageService imageService) {
        this.courseService = courseService;
        this.imageService = imageService;
    }

    @GetMapping(value = "/courses")
    public List<CourseResponseDto> getAllCourse(){
        System.out.println("We are getting all course");
        return courseService.courseResponseDtoList();
    }

    @GetMapping(value = "/course/{uid}")
    public CourseResponseDto getCourseById(
           @PathVariable UUID uid){
        System.out.print("getting data -----------------------related to course");
        return courseService.getCourseById(uid);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addCourse(@ModelAttribute Course course, @RequestParam("img") MultipartFile img) {
        try {
            // Process the image file, e.g., save it to disk or a database
            Image image = imageService.createImageFromMultipartFile(img);

            System.out.println(img.toString());
            // Add the course along with the image
            courseService.addCourse(course, image);

            return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add course: " + e.getMessage());
        }
    }


    @DeleteMapping(value = "/delete/{uid}")
    public String deleteCourseById(@PathVariable UUID uid){
        return courseService.deleteCourse(uid);
    }


    @GetMapping(value = "/{uid}/author")
    public UserResponeDto getAuthorById(@PathVariable UUID uid){
        return courseService.getAuthorUser(uid);
    }

    @GetMapping(value = "/videos/{uid}")
    public List<VideosResponseDto> getAllVideosForCourse(@PathVariable UUID uid){
        return courseService.getCourseVideos(uid);
    }

    @PostMapping(value = "/enroll")
    public String enrolStudentInCOurse(@RequestBody EnrollStudent enrollStudent){
      return courseService.enrollStudentInCourse(enrollStudent);
    }

    @GetMapping(value = "/students/{uid}")
    public List<UserResponeDto> getAllUserForCourse(@PathVariable UUID uid){
        return courseService.getAllStudentForCourse(uid);
    }

    @GetMapping("/search")
    public List<CourseResponseDto> searchCourses(@RequestParam String keyword) {
        return courseService.searchCourses(keyword);
    }

}
