package com.jobapplication.tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobapplication.tracker.model.Board;

@Repository
public interface BoardRepository extends MongoRepository<Board, String> {

    List<Board> findByEmail(String email);

}
