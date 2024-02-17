package com.jobapplication.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobapplication.tracker.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {

}
