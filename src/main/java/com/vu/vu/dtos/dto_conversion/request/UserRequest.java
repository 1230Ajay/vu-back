package com.vu.vu.dtos.dto_conversion.request;

import com.vu.vu.dtos.request_dto.UserRequestDto;
import com.vu.vu.user.User;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class UserRequest {

    public User toUser(UserRequestDto dto){
        User user =new User();
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setPassword(dto.getPassword());
        return user;
    }
}
