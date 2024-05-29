package com.vu.vu.institute_categories;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class InstituteCategoryController {

    private final InstituteCategoryService instituteCategoryService;

    public InstituteCategoryController(InstituteCategoryService instituteCategoryService) {
        this.instituteCategoryService = instituteCategoryService;
    }

    @PostMapping(value = "/add")
    public InstituteCategory addCategory(@RequestBody InstituteCategory instituteCategory){
        return instituteCategoryService.addInstituteCategory(instituteCategory);
    }

    @DeleteMapping(value = "/delete/{uid}")
    public String deleteInstituteCategory(@PathVariable UUID uid){
        return instituteCategoryService.deleteInstituteCategory(uid);
    }

    @GetMapping("/get")
    public List<InstituteCategory> getAllCategory(){
        return instituteCategoryService.getAllInstitueCatorgories();
    }

}
