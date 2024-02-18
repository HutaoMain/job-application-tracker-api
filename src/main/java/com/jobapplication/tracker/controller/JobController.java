package com.jobapplication.tracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jobapplication.tracker.model.Job;
import com.jobapplication.tracker.service.JobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/api/job")
@CrossOrigin("*")
public class JobController {

    @Autowired
    JobService jobService;

    // @PostMapping("/create/{boardId}")
    // public ResponseEntity<?> createJob(@RequestBody Job job, @PathVariable String
    // boardId) {
    // jobService.createJob(job, boardId);
    // return ResponseEntity.ok("Job created");
    // }

    @PostMapping("/create")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Job>> getJobList() {
        List<Job> jobList = jobService.getJobList();
        return ResponseEntity.ok(jobList);
    }

    @PatchMapping("/move-job")
    public ResponseEntity<Void> moveJobToBoard(@RequestParam String jobId, @RequestParam String targetBoardId) {
        jobService.moveJobToBoard(jobId, targetBoardId);
        return ResponseEntity.ok().build();
    }

}
