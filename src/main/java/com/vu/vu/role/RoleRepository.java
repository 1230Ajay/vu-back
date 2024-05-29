package com.vu.vu.role;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, Integer> {
    Optional<Role> findByName(String roleStudent);
}
