package com.vu.vu.chatroom;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, UUID> {
    List<ChatRoom> findByUsersUid(UUID userUUID);

//    @Query("SELECT cr FROM ChatRoom cr JOIN cr.users u WHERE u.uid = :userId1 AND u.uid = :userId2")
//    Optional<ChatRoom> findChatRoomByUsers(@Param("userId1") UUID userId1, @Param("userId2") UUID userId2);
}