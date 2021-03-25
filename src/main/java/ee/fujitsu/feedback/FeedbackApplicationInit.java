package ee.fujitsu.feedback;

import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.repository.FeedbacksRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FeedbackApplicationInit implements CommandLineRunner {

    private final FeedbacksRepository feedbacksRepository;

    @Override
    public void run(String... args) throws Exception {
        Feedback feedback = new Feedback();
        feedback.setAuthorName("Mary Smith");
        feedback.setAuthorEmail("mary.smith@mail.com");
        List<String> categories = new ArrayList<>();
        categories.add("Patients portal");
        categories.add("Doctors portal");
        feedback.setCategories(categories);
        feedback.setContent("10/10 feedback");

        feedbacksRepository.save(feedback);
    }
}
