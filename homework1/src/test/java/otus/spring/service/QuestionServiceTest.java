package otus.spring.service;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import otus.spring.model.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    QuestionService questionService;
    List<Question> questions;

    @BeforeEach
    void setUp() {
        questions = new ArrayList<>();
        Question question = new Question("Say 1", new ArrayList<String>(List.of("1", "2", "3", "4")), "1");
        questions.add(question);
    }

    @Test
    void findAllQuestionsTest() {
        Mockito.lenient().when(questionService.getAllQuestions()).thenReturn(questions);
    }
}
