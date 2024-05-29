package com.vu.vu.video;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface VideoContentRepository extends MongoRepository<VideoContent, UUID> {
}
