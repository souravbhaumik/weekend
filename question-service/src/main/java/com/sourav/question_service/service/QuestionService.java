package com.sourav.question_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sourav.question_service.dao.QuestionDao;
import com.sourav.question_service.model.Question;
import com.sourav.question_service.model.QuestionWrapper;
import com.sourav.question_service.model.Response;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List< Question >> getAllQuestions()
    {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List< Question >> getQuestionsByCategory( String cat )
    {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(cat), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion( Question question )
    {
        questionDao.save(question);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity< List< Integer > > getQuestionsForQuiz(
            String category, Integer numOfQuestions )
    {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category, numOfQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity< List< QuestionWrapper > > getQuestionsFromId(
            List<Integer> questionIds )
    {
        List<QuestionWrapper> qw = new ArrayList<>();
        List<Question> q = new ArrayList<>();
        
        q.addAll(questionDao.findAllById(questionIds));
        for (Question q_: q) {
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setId(q_.getId());
            questionWrapper.setCategory(q_.getCategory());
            questionWrapper.setOption1(q_.getOption1());
            questionWrapper.setOption2(q_.getOption2());
            questionWrapper.setOption3(q_.getOption3());
            questionWrapper.setOption4(q_.getOption4());
            questionWrapper.setQuestionTitle(q_.getQuestionTitle());
            qw.add(questionWrapper);
        }

        return new ResponseEntity<>(qw, HttpStatus.OK);
    }

    public ResponseEntity< Integer > getScore( List<Response> responses )
    {
        int rightAnswer = 0;
        for (Response response: responses) {
            Optional<Question> getparticularQuestion = questionDao.findById(response.getId());

            if ((getparticularQuestion != null) &&
                (response.getResponse().equals(getparticularQuestion.get().getRightAnswer()))) {
                rightAnswer++;
            }
        }
        return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
    }

}
