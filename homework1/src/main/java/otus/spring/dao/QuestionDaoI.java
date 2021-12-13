package otus.spring.dao;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface QuestionDaoI {

    List<String[]> findAllQuestions() throws IOException, CsvException;
}
