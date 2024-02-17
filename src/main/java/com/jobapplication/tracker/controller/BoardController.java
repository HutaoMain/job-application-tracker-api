package com.jobapplication.tracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jobapplication.tracker.model.Board;
import com.jobapplication.tracker.service.BoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/board")
@CrossOrigin("*")
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board createBoard = boardService.createBoard(board);
        return ResponseEntity.ok(createBoard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable String id) {
        Board board = boardService.getBoardById(id);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boardList = boardService.getBoardList();
        return ResponseEntity.ok(boardList);
    }

}
