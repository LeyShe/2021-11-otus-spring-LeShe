package otus.spring.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Question {
    private String question;
    private List<String> variants;
    private String answer;
}
