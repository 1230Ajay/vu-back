package com.vu.vu.dtos.dto_conversion.response;

import com.vu.vu.address.Address;
import com.vu.vu.dtos.response_dto.AddResponseDto;
import org.springframework.stereotype.Service;

@Service
public class AddressResponse {
    public AddResponseDto toAddResponseDto(Address address){
        AddResponseDto addResponseDto = new AddResponseDto();
        addResponseDto.setCity(address.getCity());
        addResponseDto.setState(address.getState());
        addResponseDto.setPincode(address.getPincode());
        addResponseDto.setStreet(address.getStreet());
        addResponseDto.setUid(address.getUid());
        return addResponseDto;
    }
}
