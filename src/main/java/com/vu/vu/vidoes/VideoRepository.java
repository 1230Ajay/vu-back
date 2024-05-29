package com.vu.vu.vidoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface VideoRepository extends MongoRepository<Video, UUID> {
}
