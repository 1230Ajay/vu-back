package com.vu.vu.dtos.dto_conversion.response;


import com.vu.vu.dtos.response_dto.FeeResponseDto;
import com.vu.vu.fee.Fee;
import org.springframework.stereotype.Service;

@Service
public class FeeResponse {

    public FeeResponseDto feeResponseDto(Fee fee){
         FeeResponseDto dto = new FeeResponseDto();
         dto.setAmount(fee.getAmount());
         dto.setUid(fee.getUid());
         dto.setStudent(fee.getStudent().getUid().toString());
         dto.setDescription(fee.getDescription());
         return dto;
    }

}
