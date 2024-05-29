package com.vu.vu.vidoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.course.Course;
import com.vu.vu.image.Image;
import com.vu.vu.video.VideoContent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID uid;

    private String title;

    private String description;

    @JsonIgnore
    @OneToOne(mappedBy = "video")
    private VideoContent vidFile;

    @JsonIgnore
    @OneToOne
    private Image thumbnail;

    @ManyToOne
    private Course course;
}
