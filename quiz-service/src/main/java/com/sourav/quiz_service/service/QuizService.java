package com.sourav.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sourav.quiz_service.dao.QuizDao;
import com.sourav.quiz_service.feign.QuizInterface;
import com.sourav.quiz_service.model.QuestionWrapper;
import com.sourav.quiz_service.model.Quiz;
import com.sourav.quiz_service.model.Response;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity< String > createQuiz( String category, int numQ,
            String title )
    {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, null).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity< List< QuestionWrapper > > getQuizQuestions( Integer id )
    {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        if (!quiz.isEmpty())
        {
            // List<Question> questionsFromDB = quiz.get().getQuestions();
            // for (Question q: questionsFromDB) {
            //     QuestionWrapper qw = new QuestionWrapper();
            //     qw.setId(q.getId());
            //     qw.setCategory(q.getCategory());
            //     qw.setOption1(q.getOption1());
            //     qw.setOption2(q.getOption2());
            //     qw.setOption3(q.getOption3());
            //     qw.setOption4(q.getOption4());
            //     qw.setQuestionTitle(q.getQuestionTitle());
            //     questionsForUsers.add(qw);
            // }
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
        // for (Response response: responses) {
        //     Optional<Question> getparticularQuestion = questionDao.findById(response.getId());

        //     if ((getparticularQuestion != null) &&
        //         (response.getResponse().equals(getparticularQuestion.get().getRightAnswer()))) {
        //         rightAnswer++;
        //     }
        // }
        return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
    }

}
