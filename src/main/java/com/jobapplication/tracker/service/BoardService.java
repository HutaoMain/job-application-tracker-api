package com.jobapplication.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapplication.tracker.model.Board;
import com.jobapplication.tracker.repository.BoardRepository;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board getBoardById(String id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

}
