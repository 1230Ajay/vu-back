package com.vu.vu.image;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    public Image createImage(String name, String contentType, byte[] data) {
        Image image = new Image();
        image.setName(name);
        image.setContentType(contentType);
        image.setData(data);
        return image;
    }

    public Image createImageFromMultipartFile(MultipartFile file) throws IOException, IOException {
        String name = file.getOriginalFilename();
        String contentType = file.getContentType();
        byte[] data = file.getBytes();
        return createImage(name, contentType, data);
    }

}
