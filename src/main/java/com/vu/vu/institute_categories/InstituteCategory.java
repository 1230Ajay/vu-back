package com.vu.vu.institute_categories;


import com.vu.vu.Institue.Institute;
import com.vu.vu.image.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstituteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uid;

    @OneToOne
    private Image image;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Institute> institute;

    public InstituteCategory(String uidString) {
        this.uid = UUID.fromString(uidString);
    }


}
