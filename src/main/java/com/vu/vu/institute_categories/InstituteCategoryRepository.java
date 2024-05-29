package com.vu.vu.institute_categories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface InstituteCategoryRepository extends MongoRepository<InstituteCategory, UUID> {
}
