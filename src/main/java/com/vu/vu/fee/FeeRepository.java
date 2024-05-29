package com.vu.vu.fee;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface FeeRepository  extends MongoRepository<Fee, UUID> {
}