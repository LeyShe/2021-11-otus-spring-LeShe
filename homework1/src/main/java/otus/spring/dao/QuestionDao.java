package otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
@NoArgsConstructor
public class QuestionDao implements QuestionDaoI {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionDao.class);

    private CSVReader csvReader;

    @Value("${file.path}")
    private String path;

    @Override
    public List<String[]> findAllQuestions() throws IOException, CsvException {
        try {
            var reader = Files.newBufferedReader(Paths.get(
                    ClassLoader.getSystemResource(path).toURI()));
            csvReader = new CSVReader(reader);
        } catch (URISyntaxException e) {
            LOG.error("Неверный путь к файлу.");
            e.printStackTrace();
        }
        return csvReader.readAll();
    }
}
