package com.vu.vu.user;
import com.vu.vu.chatroom.ChatRoom;
import com.vu.vu.dtos.dto_conversion.response.UserResponse;
import com.vu.vu.dtos.request_dto.UserRequestDto;
import com.vu.vu.dtos.response_dto.AddResponseDto;
import com.vu.vu.dtos.response_dto.CourseResponseDto;
import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    private final ImageService imageService;
    private final UserResponse userResponse;
    public UserController(UserService userService, ImageService imageService, UserResponse userResponse) {
        this.userService = userService;
        this.imageService = imageService;
        this.userResponse = userResponse;
    }



    @DeleteMapping(value = "/delete/{uid}")
    public String deleteUser(@PathVariable  UUID uid){
        return userService.deleteUser(uid);
    }


    @GetMapping(value = "/users")
    public List<UserResponeDto> getAllUsers(){
        return   userService.GetAllUser();
    }

    @GetMapping(value = "/user/{uid}")
    public UserResponeDto getUserById(@PathVariable UUID uid){
        return userService.getUserById(uid);
    }

    @GetMapping(value = "/addresses/{uid}")
    public List<AddResponseDto> getAllAddress(@PathVariable UUID uid){
        return userService.getUsersAddresses(uid);
    }

    @GetMapping(value = "/ownedcourses/{uid}")
    public List<CourseResponseDto> getAllOwnedCourses(@PathVariable UUID uid){
        return userService.getOwnedCourseOfUserCourse(uid);
    }

    @GetMapping(value = "/enrolled/courses/{uid}")
    public List<CourseResponseDto> getUserEnrolledCourses(@PathVariable UUID uid){
        return userService.getCourseUserEnrolledCourse(uid);
    }

    @GetMapping("/connected/users/{uid}")
    public ResponseEntity<List<ChatRoom>> findConnectedUser(@PathVariable UUID uid){
        return ResponseEntity.ok(userService.getChatRoomsByUserId(uid));
    }

}
