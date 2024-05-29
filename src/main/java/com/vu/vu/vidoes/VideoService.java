package com.vu.vu.vidoes;


import com.vu.vu.dtos.dto_conversion.response.VideoResponse;
import com.vu.vu.dtos.response_dto.VideosResponseDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageRepository;
import com.vu.vu.video.VideoContent;
import com.vu.vu.video.VideoContentRepository;
import com.vu.vu.video.VideoServiceContent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final VideoResponse videoResponse;
    private final VideoContentRepository videoContentRepository;

    private final ImageRepository imageRepository;

    public VideoService(VideoRepository videoRepository, VideoResponse videoResponse, VideoContentRepository videoContentRepository, ImageRepository imageRepository) {
        this.videoRepository = videoRepository;
        this.videoResponse = videoResponse;
        this.videoContentRepository = videoContentRepository;
        this.imageRepository = imageRepository;

    }

    private VideosResponseDto videosResponseDto(Video video){
        return videoResponse.videosResponseDto(video);
    }

    public String deleteVideo(UUID uid){
        videoRepository.deleteById(uid);
        return "video deleted"+uid;
    }

    public Video CreateVideo(Video video, VideoContent videoContent, Image image){
        Image img = imageRepository.save(image);
        Video vid = videoRepository.save(video);
        vid.setThumbnail(img);
        VideoContent vidFile = videoContent;
        vidFile.setVideo(video);
        videoContentRepository.save(vidFile);
        return vid;
    }

    public VideosResponseDto getVideoById(UUID uid){
        return videoResponse.videosResponseDto(videoRepository.findById(uid).orElseThrow());
    }

}
