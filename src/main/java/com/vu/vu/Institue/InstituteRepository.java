package com.vu.vu.Institue;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface InstituteRepository extends MongoRepository<Institute, UUID> {

}
