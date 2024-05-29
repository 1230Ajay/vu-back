package com.vu.vu.chat;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, UUID> {
    List<ChatMessage> findByChatId(String chatId);
}