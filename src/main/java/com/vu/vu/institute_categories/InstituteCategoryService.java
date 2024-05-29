package com.vu.vu.institute_categories;

import com.vu.vu.Institue.Institute;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class InstituteCategoryService {
    private  final  InstituteCategoryRepository instituteCategoryRepository;

    public InstituteCategoryService(InstituteCategoryRepository instituteCategoryRepository) {
        this.instituteCategoryRepository = instituteCategoryRepository;
    }

    public List<InstituteCategory> getAllInstitueCatorgories(){
        return instituteCategoryRepository.findAll();
    }

    public InstituteCategory addInstituteCategory(InstituteCategory instituteCategory){
        return instituteCategoryRepository.save(instituteCategory);
    }

    public String deleteInstituteCategory(UUID uid){
        instituteCategoryRepository.deleteById(uid);
        return "Categor deleted "+uid;
    }



}
