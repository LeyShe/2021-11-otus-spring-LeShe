package otus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.dao.QuestionDao;
import otus.spring.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDaoI;

    @Override
    public List<Question> getAllQuestions() {
        return questionDaoI.findAllQuestions().stream().
                map(record -> new Question(record[0], new ArrayList<String>(List.of(record[1], record[2], record[3], record[4])), record[5]))
                .collect(Collectors.toList());
    }
}
