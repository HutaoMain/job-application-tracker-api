package com.jobapplication.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobapplication.tracker.model.Job;
import java.util.List;

public interface JobRepository extends MongoRepository<Job, String> {

    List<Job> findByEmail(String email);

}
