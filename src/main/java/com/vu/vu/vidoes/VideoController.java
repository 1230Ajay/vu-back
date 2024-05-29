package com.vu.vu.vidoes;

import com.vu.vu.dtos.response_dto.VideosResponseDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageService;
import com.vu.vu.video.VideoContent;
import com.vu.vu.video.VideoServiceContent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    private final VideoServiceContent videoServiceContent;

    private final ImageService imageService;

    public VideoController(VideoService videoService, VideoServiceContent videoServiceContent, ImageService imageService) {
        this.videoService = videoService;
        this.videoServiceContent = videoServiceContent;
        this.imageService = imageService;
    }

    @PostMapping(value = "/add")
    public Video addVideo(@ModelAttribute Video video, @RequestParam("vid") MultipartFile vid,@RequestParam("img") MultipartFile img) throws IOException {
        VideoContent vidContet = videoServiceContent.createVideoFromMultipartFile(vid);
        Image image = imageService.createImageFromMultipartFile(img);
        return videoService.CreateVideo(video,vidContet,image);
    }

    @GetMapping(value = "/video/{uid}")
    public VideosResponseDto GetVideoById(@PathVariable UUID uid){
        System.out.print("getting videos --------------------------------------------");
        return videoService.getVideoById(uid);
    }

}
