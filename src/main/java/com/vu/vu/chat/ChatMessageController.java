package com.vu.vu.chat;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate simpMessagingTemplate;


//    @MessageMapping("/chat")
//    public void processMessage(@Payload ChatMessage chatMessage) {
//        try {
//            System.out.println(chatMessage.toString());
//            ChatMessage savedChatMessage = chatMessageService.save(chatMessage);
//            System.out.println(savedChatMessage);
//            simpMessagingTemplate.convertAndSend("/user/"+chatMessage.getRecipientId()+"/queue/message", chatMessage);
//        } catch (Exception e) {
//            // Handle exception or log it for debugging
//            System.err.println("Error processing chat message: " + e.getMessage());
//        }
//    }



}
