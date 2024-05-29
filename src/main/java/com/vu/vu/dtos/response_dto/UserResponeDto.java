package com.vu.vu.dtos.response_dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponeDto {
    private UUID uid;
    private String firstname;
    private String lastname;
    private String email;
    private long phone;
    private String image;
}
