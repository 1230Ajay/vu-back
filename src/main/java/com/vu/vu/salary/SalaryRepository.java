package com.vu.vu.salary;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SalaryRepository extends MongoRepository<Salary, UUID> {
}
