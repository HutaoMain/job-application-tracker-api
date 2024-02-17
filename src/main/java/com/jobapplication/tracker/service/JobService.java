package com.jobapplication.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapplication.tracker.model.Board;
import com.jobapplication.tracker.model.Job;
import com.jobapplication.tracker.repository.BoardRepository;
import com.jobapplication.tracker.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    BoardRepository boardRepository;

    public Job createJob(Job job, String boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);

        if (board != null) {
            Job newJob = new Job();
            newJob.setEmail(job.getEmail());
            newJob.setJobName(job.getJobName());
            newJob.setCompanyName(job.getCompanyName());
            newJob.setJobDescription(job.getJobDescription());
            newJob.setAskingSalary(job.getAskingSalary());
            newJob.setBoard(board);
            return jobRepository.save(job);
        } else {
            System.out.println("board is null");
            return job;
        }
    }

    // public Job createJob(Job job) {
    // return jobRepository.save(job);
    // }

    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobList() {
        return jobRepository.findAll();
    }
}
