package otus;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import otus.spring.quiz.Quiz;
import otus.spring.service.QuestionServiceImpl;

@PropertySource("/application.properties")
@ComponentScan
@Configuration
public class ApplicationConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();

        Quiz testStart = context.getBean(Quiz.class);
        QuestionServiceImpl service = context.getBean(QuestionServiceImpl.class);
        testStart.startQuiz(service);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
