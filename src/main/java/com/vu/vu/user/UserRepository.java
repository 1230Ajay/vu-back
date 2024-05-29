package com.vu.vu.user;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    List<User> findAllByOnline(Status status);
    Optional<User>  findByEmail(String email);
}
