package com.vu.vu.video;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vu.vu.course.Course;
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
public class VideoContent {

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
    @Column(length = 1048576021) // Set the maximum size to 10 MB (10 * 1024 * 1024 bytes)
    private byte[] data;

    @JsonIgnore
    @OneToOne
    private Video video;
}
