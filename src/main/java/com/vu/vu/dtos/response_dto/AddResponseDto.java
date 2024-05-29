package com.vu.vu.dtos.response_dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddResponseDto {
    private UUID uid;
    private String street;
    private String city;
    private String state;
    private Integer pincode;
}
