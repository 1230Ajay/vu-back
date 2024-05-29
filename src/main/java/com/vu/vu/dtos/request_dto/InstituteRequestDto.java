package com.vu.vu.dtos.request_dto;

import com.vu.vu.image.Image;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class InstituteRequestDto {
    private String name;
    private MultipartFile banner;
    private MultipartFile logo;
}
