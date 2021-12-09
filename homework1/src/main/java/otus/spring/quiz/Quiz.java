package otus.spring.quiz;

import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import otus.spring.model.Question;
import otus.spring.service.QuestionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class Quiz {
    private static final Logger LOG = LoggerFactory.getLogger(Quiz.class);

    public void startQuiz(QuestionService questionService) {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var correctAnswers = new ArrayList<>();
        try {
            System.out.println("Please enter your name:");
            var studentName = reader.readLine();
            System.out.println(studentName + ", please answer the questions:");
            var questions = questionService.getAllQuestions();
            for (Question question : questions) {
                System.out.println(question.getQuestion() + "\nMake your choice:");
                System.out.println(Arrays.toString(question.getVariants()));
                var answer = reader.readLine();
                if (question.getAnswer().equals(answer)) {
                    correctAnswers.add(answer);
                }
            }
            var isPassTest = correctAnswers.size() >= 3;
            if (isPassTest) {
                System.out.println("Great job!");
            } else {
                System.out.println("Try later.");
            }
        } catch (CsvException | IOException e) {
            LOG.error("Ошибка при чтении файла.");
            e.printStackTrace();
        }

    }
}
