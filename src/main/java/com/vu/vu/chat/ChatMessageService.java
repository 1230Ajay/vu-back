package com.vu.vu.chat;

import com.vu.vu.chatroom.ChatRoomRepository;
import com.vu.vu.chatroom.ChatRoomService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, ChatRoomService chatRoomService) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatRoomService = chatRoomService;
    }

//    public ChatMessage save(ChatMessage chatMessage){
//        var chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(),chatMessage.getRecipientId(),true).orElseThrow();
//
//        chatMessage.setChatId(chatId.getUid().toString());
//        chatMessage.setTimestamp(LocalDateTime.now());
//        chatMessageRepository.save(chatMessage);
//        return chatMessage;
//    }
//
//    public List<ChatMessage> findChatMessage(String senderId,String recipientId){
//        var chatId = chatRoomService.getChatRoomId(senderId,recipientId,false).orElse(null);
//        System.out.println("This is Chat_ID"+chatId);
//        return chatMessageRepository.findByChatId(chatId.getUid().toString());
//    }

}
