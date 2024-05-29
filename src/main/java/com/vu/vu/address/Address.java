package com.vu.vu.address;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.Institue.Institute;
import com.vu.vu.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    private String street;
    private String city;
    private String state;
    private Integer pincode;



    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "address")
    private Institute institute;

}
