package com.vu.vu.video;

import com.vu.vu.image.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class VideoServiceContent {
    public VideoContent createVideo(String name, String contentType, byte[] data) {
        VideoContent video = new VideoContent();
        video.setName(name);
        video.setContentType(contentType);
        video.setData(data);
        return video;
    }

    public VideoContent createVideoFromMultipartFile(MultipartFile file) throws IOException, IOException {
        String name = file.getOriginalFilename();
        String contentType = file.getContentType();
        byte[] data = file.getBytes();
        return createVideo(name, contentType, data);
    }
}
