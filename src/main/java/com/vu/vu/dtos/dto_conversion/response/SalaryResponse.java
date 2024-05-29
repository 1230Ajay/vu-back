package com.vu.vu.dtos.dto_conversion.response;

import com.vu.vu.dtos.response_dto.SalaryResponseDto;
import com.vu.vu.salary.Salary;
import org.springframework.stereotype.Service;

import java.io.Serial;


@Service
public class SalaryResponse {
    public SalaryResponseDto salaryResponseDto(Salary salary){
        SalaryResponseDto dto = new SalaryResponseDto();
        dto.setAmount(salary.getAmount());
        dto.setUid(salary.getUid());
        dto.setDescription(salary.getDescription());
        dto.setTutor(salary.getTutor().getUid().toString());
        return  dto;
    }
}
