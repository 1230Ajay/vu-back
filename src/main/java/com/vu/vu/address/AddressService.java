package com.vu.vu.address;

import com.vu.vu.dtos.dto_conversion.response.AddressResponse;
import com.vu.vu.dtos.response_dto.AddResponseDto;
import com.vu.vu.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;
    private  final AddressResponse addressResponse;
    public AddressService(AddressRepository addressRepository, UserService userService, AddressResponse addressResponse) {
        this.addressRepository = addressRepository;
        this.userService = userService;
        this.addressResponse = addressResponse;
    }

    public AddResponseDto registerAddAddress(Address address){
        Address add= addressRepository.save(address);
        return toAddResponseDto(add);
    }

    public String deleteAddress(UUID uid){
        addressRepository.deleteById(uid);
        return "Address Deleted by successfully";
    }

    public AddResponseDto toAddResponseDto(Address address){
        return addressResponse.toAddResponseDto(address);
    }

    public List<AddResponseDto> getAddressByUid(){
        return addressRepository.findAll().stream().map(this::toAddResponseDto).collect(Collectors.toList());
    }

    public Optional<Address> getAddressById(UUID uid){
        return addressRepository.findById(uid);
    }


}
