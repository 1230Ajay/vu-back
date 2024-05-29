package com.vu.vu.Institue;


import com.vu.vu.dtos.dto_conversion.request.InstituteRequest;
import com.vu.vu.dtos.request_dto.InstituteRequestDto;
import com.vu.vu.image.Image;
import com.vu.vu.image.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/institute")
public class InstituteController {
   private final InstituteService instituteService;

  private  final ImageService imageService;

  private final InstituteRequest instituteRequest;

    public InstituteController(InstituteService instituteService, ImageService imageService, InstituteRequest instituteRequest) {
        this.instituteService = instituteService;
        this.imageService = imageService;
        this.instituteRequest = instituteRequest;
    }

    private Institute toInstitute(InstituteRequestDto instituteRequestDto){
        return instituteRequest.toInstitute(instituteRequestDto);
    }

    @PostMapping(value = "/add")
    public Institute institute(@ModelAttribute InstituteRequestDto institute, @RequestParam("logo") MultipartFile logo, @RequestParam("banner") MultipartFile banner) throws IOException {
        Image logoImg = imageService.createImageFromMultipartFile(logo);
        Image bannerImg = imageService.createImageFromMultipartFile(banner);
        Institute institutegot = toInstitute(institute) ;
        return instituteService.addInstitute(institutegot,logoImg,bannerImg);
    }

    public List<Institute> getAllInstitutes(){
        return instituteService.getAllInstitute();
    }
}
