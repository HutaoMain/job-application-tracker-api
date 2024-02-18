package com.jobapplication.tracker.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "jobs")
public class Job {

    @Id
    private String id;

    private String email;

    private String jobName;

    private String companyName;

    private String jobDescription;

    private Integer askingSalary;

    private String boardId;

    @CreatedDate
    private LocalDateTime createdAt;
}
