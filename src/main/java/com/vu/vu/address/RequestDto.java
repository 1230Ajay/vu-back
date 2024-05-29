package com.vu.vu.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.user.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
public class RequestDto {
    private String street;
    private String city;
    private String state;
    private Integer pincode;
    private String user_uid;
}
