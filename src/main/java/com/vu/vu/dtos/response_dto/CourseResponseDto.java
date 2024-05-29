package com.vu.vu.dtos.response_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDto {
    private UUID uid;

    private String author;
    private String image;
    private String name;
    private String description;

    private Integer videos;
    private Integer lessons;
    private Integer resources;

    private Float price;
    private Float rating;

}
