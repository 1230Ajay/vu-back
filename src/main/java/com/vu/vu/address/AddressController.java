package com.vu.vu.address;

import com.vu.vu.dtos.dto_conversion.response.AddressResponse;
import com.vu.vu.dtos.response_dto.AddResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
   private final AddressResponse addressResponse;
    public AddressController(AddressService addressService, AddressResponse addressResponse) {
        this.addressService = addressService;
        this.addressResponse = addressResponse;
    }

    @PostMapping(value = "/add")
    private AddResponseDto addAdress(@RequestBody Address address){
        System.out.println(address.toString());
        return addressService.registerAddAddress(address);
    }

    private AddResponseDto toAddResponseDto(Address address){
        return addressResponse.toAddResponseDto(address);
    }


    @GetMapping(value = "adress")
    private AddResponseDto getAddressById(UUID uid){
        return toAddResponseDto(addressService.getAddressById(uid).orElseThrow());
    }


}
