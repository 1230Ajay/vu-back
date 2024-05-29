package com.vu.vu.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.image.Image;
import com.vu.vu.user.User;
import com.vu.vu.vidoes.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uid;

    @OneToOne
    private Image image;

    private String name;
    private String description;

    private Integer videos;
    private Integer lessons;
    private Integer resources;

    private Float price;
    private Float rating;

    private boolean recommanded;

    @ManyToMany
    private List<User> students;

    @ManyToOne
    private User author;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Video> videoList;

    public Course(String CourseUid){
        this.uid = UUID.fromString(CourseUid);
    }
}
