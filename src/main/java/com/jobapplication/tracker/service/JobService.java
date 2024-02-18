package com.jobapplication.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobapplication.tracker.model.Board;
import com.jobapplication.tracker.model.Job;
import com.jobapplication.tracker.repository.BoardRepository;
import com.jobapplication.tracker.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    // public void createJob(Job job, String boardId) {
    // Board board = boardRepository.findById(boardId).orElse(null);
    // if (board != null) {
    // Job savedJob = jobRepository.save(job);
    // board.getJobList().add(savedJob);
    // boardService.createBoard(board);
    // } else {
    // System.out.println("board is null");
    // }
    // }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobList() {
        return jobRepository.findAll();
    }

    public void moveJobToBoard(String jobId, String targetBoardId) {
        Job jobToMove = jobRepository.findById(jobId).orElse(null);

        if (jobToMove != null) {
            Board sourceBoard = findBoardContainingJob(jobId);

            if (sourceBoard != null) {
                sourceBoard.getJobList().removeIf(job -> job.getId().equals(jobToMove.getId()));
                boardRepository.save(sourceBoard);
            }

            Board targetBoard = boardRepository.findById(targetBoardId).orElse(null);

            if (targetBoard != null) {
                targetBoard.getJobList().add(jobToMove);
                boardRepository.save(targetBoard);
            }
        }
    }

    private Board findBoardContainingJob(String jobId) {
        Board board = boardRepository.findByJobListId(jobId);
        try {
            String boardJson = objectMapper.writeValueAsString(board);
            System.out.println("Board JSON: " + boardJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return board;
    }
}
