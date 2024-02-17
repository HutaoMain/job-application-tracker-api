package com.jobapplication.tracker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "board")
public class Board {

    @Id
    private String id;

    private String email;

    private String boardName;

    @DBRef
    private List<Job> jobList = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;
}
