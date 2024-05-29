package com.vu.vu.dtos.dto_conversion.request;

import com.vu.vu.Institue.Institute;
import com.vu.vu.dtos.request_dto.InstituteRequestDto;
import org.springframework.stereotype.Service;

@Service
public class InstituteRequest {

    public Institute toInstitute(InstituteRequestDto dto){
        Institute institute = new Institute();
        institute.setName(dto.getName());
        return institute;
    }
}
