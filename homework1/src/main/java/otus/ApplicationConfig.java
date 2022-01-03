package otus;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import otus.spring.quiz.QuizImpl;

@PropertySource("/application.properties")
@ComponentScan
@Configuration
public class ApplicationConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        QuizImpl testStart = context.getBean(QuizImpl.class);
        testStart.startQuiz();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
