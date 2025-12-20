package com.sourav.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sourav.quiz_app.dao.QuestionDao;
import com.sourav.quiz_app.dao.QuizDao;
import com.sourav.quiz_app.model.Question;
import com.sourav.quiz_app.model.QuestionWrapper;
import com.sourav.quiz_app.model.Quiz;
import com.sourav.quiz_app.model.Response;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity< String > createQuiz( String category, int numQ,
            String title )
    {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity< List< QuestionWrapper > > getQuizQuestions( Integer id )
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        if (!quiz.isEmpty())
        {
            List<Question> questionsFromDB = quiz.get().getQuestions();
            for (Question q: questionsFromDB) {
                QuestionWrapper qw = new QuestionWrapper();
                qw.setId(q.getId());
                qw.setCategory(q.getCategory());
                qw.setOption1(q.getOption1());
                qw.setOption2(q.getOption2());
                qw.setOption3(q.getOption3());
                qw.setOption4(q.getOption4());
                qw.setQuestionTitle(q.getQuestionTitle());
                questionsForUsers.add(qw);
            }
            return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(questionsForUsers, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity< Integer > calculateResult( Integer id,
            List<Response> responses )
    {
        // questionDao.findAllById(new ArrayList<>(List.of(responses.ge)));
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
