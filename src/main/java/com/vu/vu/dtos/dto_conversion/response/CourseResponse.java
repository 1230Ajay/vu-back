package com.vu.vu.dtos.dto_conversion.response;

import com.vu.vu.course.Course;
import com.vu.vu.dtos.response_dto.CourseResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CourseResponse {

    public CourseResponseDto toCourseResponseDto(Course course){
        CourseResponseDto dto = new CourseResponseDto();

        dto.setAuthor(course.getAuthor().getUid().toString());
        dto.setUid(course.getUid());
        dto.setName(course.getName());
        dto.setPrice(course.getPrice());
        dto.setLessons(course.getLessons());
        dto.setDescription(course.getDescription());
        dto.setResources(course.getResources());
        dto.setRating(course.getRating());
        dto.setImage("http://localhost:8080/images/"+course.getImage().getUid().toString());
        return dto;
    }
}
