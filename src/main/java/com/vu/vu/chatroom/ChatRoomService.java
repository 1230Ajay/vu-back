package com.vu.vu.chatroom;

import com.vu.vu.chatroom.ChatRoom;
import com.vu.vu.chatroom.ChatRoomRepository;
import com.vu.vu.user.User;
import com.vu.vu.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

//    public Optional<ChatRoom> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) {
//        System.out.println("Got sender id : " + senderId + " and receiver id : " + recipientId);
//
////        Optional<ChatRoom> chatRoom = chatRoomRepository.findChatRoomByUsers(UUID.fromString(senderId), UUID.fromString(recipientId));
//
//        if (chatRoom.isPresent()) {
//            return chatRoom;
//        } else if (createNewRoomIfNotExists) {
//            return Optional.ofNullable(createChatID(senderId, recipientId));
//        } else {
//            return Optional.empty();
//        }
//    }

    private ChatRoom createChatID(String senderId, String recipientId) {

        ChatRoom chatRoom = new ChatRoom();

        User sender = userRepository.findById(UUID.fromString(senderId)).orElse(null);
        User recipient = userRepository.findById(UUID.fromString(recipientId)).orElse(null);

        List<User> users = Arrays.asList(sender, recipient); // Corrected line

        chatRoom.setUsers(users);

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

}
