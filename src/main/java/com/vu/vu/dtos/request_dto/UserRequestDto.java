package com.vu.vu.dtos.request_dto;


import lombok.Data;


@Data
public class UserRequestDto {
    private String firstname;
    private String lastname;

    private String email;

    private long phone;
    private String password;
//    private MultipartFile avatar;

}
