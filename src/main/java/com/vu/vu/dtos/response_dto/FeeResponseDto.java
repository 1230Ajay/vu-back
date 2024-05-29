package com.vu.vu.dtos.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeResponseDto {
    private UUID uid;
    private double amount;
    private String description;
    private String student;
}
