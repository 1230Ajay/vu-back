package com.vu.vu.fee;


import com.vu.vu.dtos.dto_conversion.response.FeeResponse;
import com.vu.vu.dtos.response_dto.FeeResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FeeService {

    private final FeeRepository feeRepository;
    private final FeeResponse feeResponse;

    public FeeService(FeeRepository feeRepository, FeeResponse feeResponse) {
        this.feeRepository = feeRepository;
        this.feeResponse = feeResponse;
    }

    private FeeResponseDto feeResponseDto(Fee fee){
        return feeResponse.feeResponseDto(fee);
    }

    public FeeResponseDto addFee(Fee fee){
        return feeResponse.feeResponseDto(feeRepository.save(fee));
    }

    public List<FeeResponseDto> getAllFeeOfUser(){
        return feeRepository.findAll().stream().map(this::feeResponseDto).collect(Collectors.toList());
    }

    public FeeResponseDto getUserById(UUID uid){
        return feeResponse.feeResponseDto(feeRepository.findById(uid).orElseThrow());
    }

}
