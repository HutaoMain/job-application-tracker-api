package com.jobapplication.tracker.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobapplication.tracker.model.Job;
import com.jobapplication.tracker.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobList() {
        return jobRepository.findAll();
    }

    public List<Job> getJobListByStatusAndEmail(String status, String email) {
        return jobRepository.findByStatusAndEmail(status, email);
    }

    public void moveJobToBoard(String jobId, String targetStatus) {
        Job jobToMove = jobRepository.findById(jobId).orElse(null);

        if (jobToMove != null) {
            jobToMove.setStatus(targetStatus);
            jobRepository.save(jobToMove);
        }
    }

}
