package otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionDaoImpl.class);

    @Value("${file.path}")
    private String path;

    @Override
    public List<String[]> findAllQuestions(){
        List<String[]> rows = new ArrayList<>();
        try {
            var reader = Files.newBufferedReader(Paths.get(
                    ClassLoader.getSystemResource(path).toURI()));
            CSVReader csvReader = new CSVReader(reader);
            rows.addAll(csvReader.readAll());
        } catch (URISyntaxException e) {
            LOG.error("Неверный путь к файлу.", e);
        } catch (IOException | CsvException e) {
            LOG.error("Ошибка парсинга.", e);
        }
        return rows;
    }
}
