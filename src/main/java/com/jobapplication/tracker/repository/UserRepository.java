package com.jobapplication.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobapplication.tracker.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
