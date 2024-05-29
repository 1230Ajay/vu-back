package com.vu.vu.Institue;

import com.vu.vu.image.Image;
import com.vu.vu.image.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InstituteService {

    private final InstituteRepository instituteRepository;
    private final ImageRepository imageRepository;

    public InstituteService(InstituteRepository instituteRepository, ImageRepository imageRepository) {
        this.instituteRepository = instituteRepository;
        this.imageRepository = imageRepository;
    }

    public Institute addInstitute(Institute institute , Image logo,Image banner){
        Image logoImage = imageRepository.save(logo);
        Image bannerImage = imageRepository.save(banner);
        institute.setBanner(bannerImage);
        institute.setLogo(logoImage);
        return instituteRepository.save(institute);
    }

    public List<Institute> getAllInstitute(){
        return instituteRepository.findAll();
    }

    public String deleteInstitue(UUID uid){
         instituteRepository.deleteById(uid);
         return "institue delted successfully "+uid;
    }
}
