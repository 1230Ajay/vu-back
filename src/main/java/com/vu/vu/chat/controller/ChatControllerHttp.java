package com.vu.vu.chat.controller;


import com.vu.vu.chat.ChatMessage;
import com.vu.vu.chat.ChatMessageService;
import com.vu.vu.chatroom.ChatRoom;
import com.vu.vu.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/chat")
@RestController
public class ChatControllerHttp {

      private  final UserService userService;
      private  final  ChatMessageService chatMessageService;

    public ChatControllerHttp(UserService userService, ChatMessageService chatMessageService) {
        this.userService = userService;
        this.chatMessageService = chatMessageService;
    }

//        @GetMapping("/message/{senderId}/{recipientId}")
//        public ResponseEntity<List<ChatMessage>> findChatMessages(
//                @PathVariable("senderId") String senderId,
//                @PathVariable("recipientId") String recipientId) {
//            return ResponseEntity.ok(chatMessageService.findChatMessage(senderId, recipientId));
//        }

        @GetMapping(value = "/chat-room/{uid}")
        public List<ChatRoom> getChatRooms(@PathVariable UUID uid){
        System.out.println("Chat roos ------------: "+uid);
         return  userService.getChatRoomsByUserId(uid);
        }

}
