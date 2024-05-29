package com.vu.vu.dtos.dto_conversion.response;

import com.vu.vu.dtos.response_dto.UserResponeDto;
import com.vu.vu.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserResponse {
    public UserResponeDto toUserDto(User user){
        UserResponeDto dto = new UserResponeDto();
        dto.setUid(user.getUid());
        dto.setEmail(user.getEmail());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setPhone(user.getPhone());
//        dto.setImage("http://localhost:8080/images/"+user.getAvatar().getUid());
        return dto;
    }
}
