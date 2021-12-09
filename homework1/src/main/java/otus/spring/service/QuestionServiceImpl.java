package otus.spring.service;

import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.dao.QuestionDaoI;
import otus.spring.model.Question;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionDaoI questionDaoI;

    @Override
    public List<Question> getAllQuestions() throws IOException, CsvException {
        return questionDaoI.findAllQuestions().stream().
                map(record -> new Question(record[0], new String[]{record[1], record[2], record[3], record[4]}, record[5]))
                .collect(Collectors.toList());
    }
}
