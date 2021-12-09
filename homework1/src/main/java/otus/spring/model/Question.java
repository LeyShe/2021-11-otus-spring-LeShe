package otus.spring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Question {
    private String question;
    private String[] variants;
    private String answer;
}
