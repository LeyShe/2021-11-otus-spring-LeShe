package otus.spring.service;

import com.opencsv.exceptions.CsvException;
import otus.spring.model.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions() throws IOException, CsvException;
}
