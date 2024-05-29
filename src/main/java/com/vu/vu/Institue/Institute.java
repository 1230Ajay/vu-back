package com.vu.vu.Institue;


import com.vu.vu.address.Address;
import com.vu.vu.image.Image;
import com.vu.vu.institute_categories.InstituteCategory;
import com.vu.vu.user.User;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    private String name;

    @OneToOne
    private Image banner;

    @OneToOne
    private Image logo;

    @OneToOne
    private User manager;

    @ManyToMany
    private List<User> students = new ArrayList<>();

    @ManyToMany
    private List<User> tutors = new ArrayList<>();

    @ManyToOne
    private InstituteCategory category;

    @OneToOne
    private Address address;



}
