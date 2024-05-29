package com.vu.vu.dtos.dto_conversion.response;

import com.vu.vu.dtos.response_dto.VideosResponseDto;
import com.vu.vu.vidoes.Video;
import org.springframework.stereotype.Service;


@Service
public class VideoResponse {

    public VideosResponseDto videosResponseDto(Video video){
        VideosResponseDto dto = new VideosResponseDto();
        dto.setUid(video.getUid());
        dto.setTitle(video.getTitle());
        dto.setDescription(video.getDescription());
        dto.setCourse(video.getCourse().getUid().toString());
        dto.setVideo(video.getVidFile().getUid().toString());
        if(video.getThumbnail()!=null){
            dto.setThumbnail(video.getThumbnail().getUid().toString());
        }
        return dto;
    }

}
