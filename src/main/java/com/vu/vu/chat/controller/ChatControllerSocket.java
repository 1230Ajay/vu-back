package com.vu.vu.chat.controller;

import com.vu.vu.dtos.request_dto.JoinChatRequest;
import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.user.User;
import com.vu.vu.user.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class ChatControllerSocket {

    private final UserService userService;

    public ChatControllerSocket(UserService userService) {
        this.userService = userService;
    }



    @MessageMapping("/user.joinChat")
    @SendTo("/user/topic")
    public UserResponeDto joinChat(@Payload JoinChatRequest user){
        System.out.println("------------------------You have got it :"+user.getUid());
        return userService.joinChat(user.getUid());
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconect( @Payload UUID uid){
        return userService.disconnectUser(uid);
    }

}
