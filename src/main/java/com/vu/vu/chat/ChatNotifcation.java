package com.vu.vu.chat;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatNotifcation {
    @Id
    private  String id;
    private String senderId;
    private String recipientId;
    private String content;
}
