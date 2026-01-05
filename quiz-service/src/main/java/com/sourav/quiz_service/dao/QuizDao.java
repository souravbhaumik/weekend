package com.sourav.quiz_service.dao;

import org.springframework.stereotype.Repository;

import com.sourav.quiz_service.model.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
