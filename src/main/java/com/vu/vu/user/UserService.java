package com.vu.vu.user;


import com.vu.vu.address.Address;
import com.vu.vu.chatroom.ChatRoom;
import com.vu.vu.chatroom.ChatRoomRepository;
import com.vu.vu.dtos.dto_conversion.request.UserRequest;
import com.vu.vu.dtos.dto_conversion.response.AddressResponse;
import com.vu.vu.dtos.dto_conversion.response.CourseResponse;
import com.vu.vu.dtos.dto_conversion.response.UserResponse;
import com.vu.vu.dtos.request_dto.UserRequestDto;
import com.vu.vu.dtos.response_dto.AddResponseDto;
import com.vu.vu.course.Course;
import com.vu.vu.dtos.response_dto.CourseResponseDto;
import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;
    private final UserResponse userResponse;
    private final CourseResponse courseResponse;
    private final AddressResponse addressResponse;
    private final ChatRoomRepository chatRoomRepository;

    private final ImageRepository imageRepository;
    private final UserRequest userRequest;


    public UserResponeDto toUserDto(User user){
        return userResponse.toUserDto(user);
    }

    private CourseResponseDto toCourseResponseDto(Course course){
        return courseResponse.toCourseResponseDto(course);
    }

    private User toUser(UserRequestDto userRequestDto){
        return userRequest.toUser(userRequestDto);
    }

    public List<UserResponeDto> GetAllUser(){
        return userRepository.findAll().stream().map(this::toUserDto).collect(Collectors.toList());
    }

    public String deleteUser(UUID uid){
        userRepository.deleteById(uid);
        return "User deleted successfully";
    }

    public UserResponeDto getUserById(UUID uid){
        User user = userRepository.findById(uid).orElseThrow();
//        String imageUrl = user.getAvatar() != null ? getImageUrl(user.getAvatar()) : null;
        UserResponeDto dto = userResponse.toUserDto(user);
//        dto.setImage(imageUrl);
        return dto;
    }

    private String getImageUrl(Image image) {
        String baseUrl = "http://localhost:8080/"; // Replace with your file server base URL
        String imagePath = "images/" + image.getUid(); // Example path construction
        return baseUrl + imagePath;
    }



    private AddResponseDto toAddResponseDto(Address address){
        return addressResponse.toAddResponseDto(address);
   }

    public List<AddResponseDto> getUsersAddresses(UUID uid){
        User user = userRepository.findById(uid).orElseThrow(null);
           return user.getAddresses().stream().map(this::toAddResponseDto).collect(Collectors.toList());
    }

    public List<CourseResponseDto> getOwnedCourseOfUserCourse(UUID uid){
       User user = userRepository.findById(uid).orElseThrow();
        return user.getCourse().stream().map(this::toCourseResponseDto).collect(Collectors.toList());
    }

    public List<CourseResponseDto> getCourseUserEnrolledCourse(UUID uid){
        User user = userRepository.findById(uid).orElseThrow();
        return user.getCourses().stream().map(this::toCourseResponseDto).collect(Collectors.toList());
    }


    public UserResponeDto joinChat(UUID uid){
        User user = userRepository.findById(uid).orElse(null);
        if(user!=null){
            System.out.println(uid);
            user.setOnline(Status.ONLINE);
            return toUserDto(userRepository.save(user));
        }else {
            return null;
        }
    }


    public User disconnectUser(UUID uid){
        User user = userRepository.findById(uid).orElse(null);
        if(user!=null){
            user.setOnline(Status.OFFLINE);
           return userRepository.save(user);
        }else {
            return null;
        }

    }

    public List<ChatRoom> getChatRoomsByUserId(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<ChatRoom> chatRooms =user.getChatRooms();
        return chatRooms;
    }



}
