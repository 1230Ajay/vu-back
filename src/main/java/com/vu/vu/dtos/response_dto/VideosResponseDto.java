package com.vu.vu.dtos.response_dto;

import com.vu.vu.course.Course;
import com.vu.vu.vidoes.Video;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideosResponseDto {

    private UUID uid;

    private String title;

    private String description;

    private String video;

    private  String thumbnail;

    private String course;
}
