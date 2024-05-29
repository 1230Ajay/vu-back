package com.vu.vu.image;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.Institue.Institute;
import com.vu.vu.course.Course;
import com.vu.vu.institute_categories.InstituteCategory;
import com.vu.vu.user.User;
import com.vu.vu.vidoes.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uid;

    private String name;
    private String contentType;

    @Lob
    @Column(length = 10485760) // Set the maximum size to 10 MB (10 * 1024 * 1024 bytes)
    private byte[] data;
//
//    @JsonIgnore
//    @OneToOne(mappedBy = "avatar")
//    private User user;

    @JsonIgnore
    @OneToOne(mappedBy = "image")
    private InstituteCategory institute_category;

    @JsonIgnore
    @OneToOne(mappedBy = "banner")
    private Institute institute_banner;

    @JsonIgnore
    @OneToOne(mappedBy = "logo")
    private Institute institute_logo;

    @JsonIgnore
    @OneToOne(mappedBy = "image")
    private Course course;

    @JsonIgnore
    @OneToOne(mappedBy = "thumbnail")
    private Video video;


}
