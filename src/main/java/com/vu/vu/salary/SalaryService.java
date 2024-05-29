package com.vu.vu.salary;


import com.vu.vu.dtos.dto_conversion.response.SalaryResponse;
import com.vu.vu.dtos.response_dto.SalaryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SalaryService {

    private  final SalaryRepository salaryRepository;
    private final SalaryResponse salaryResponse;

    public SalaryService(SalaryRepository salaryRepository, SalaryResponse salaryResponse) {
        this.salaryRepository = salaryRepository;
        this.salaryResponse = salaryResponse;
    }

    private SalaryResponseDto salaryResponseDto(Salary salary){
        return salaryResponse.salaryResponseDto(salary);
    }

    private SalaryResponseDto addSalary(Salary salary){
        return salaryResponse.salaryResponseDto(salaryRepository.save(salary));
    }

    private List<SalaryResponseDto> getAllSalaries(){
        return salaryRepository.findAll().stream().map(this::salaryResponseDto).collect(Collectors.toList());
    }

    private SalaryResponseDto getSalaryByUid(UUID uid){
        return salaryResponse.salaryResponseDto(salaryRepository.findById(uid).orElseThrow());
    }
}
