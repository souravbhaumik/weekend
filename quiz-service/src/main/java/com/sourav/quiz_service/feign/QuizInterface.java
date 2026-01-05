package com.sourav.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sourav.quiz_service.model.QuestionWrapper;
import com.sourav.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions);

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
