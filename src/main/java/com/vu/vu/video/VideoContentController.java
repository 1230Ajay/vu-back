package com.vu.vu.video;


import com.vu.vu.vidoes.Video;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.UID;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vid")
public class VideoContentController {


    private  final  VideoContentRepository videoContentRepository;

    public VideoContentController(VideoContentRepository videoContentRepository) {
        this.videoContentRepository = videoContentRepository;
    }

    @GetMapping(value = "/{uid}")
    public ResponseEntity<byte[]> getVideo(@PathVariable UUID uid){

        Optional<VideoContent> video = videoContentRepository.findById(uid);
        if(video.isPresent()){
            VideoContent vid = video.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(vid.getContentType()));
            return ResponseEntity.ok().headers(headers).body(vid.getData());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
