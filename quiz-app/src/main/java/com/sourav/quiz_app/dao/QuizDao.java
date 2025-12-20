package com.sourav.quiz_app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sourav.quiz_app.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
