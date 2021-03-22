package ee.fujitsu.feedback;

import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.model.FeedbackCategory;
import ee.fujitsu.feedback.repository.FeedbacksRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FeedbackApplicationInit implements CommandLineRunner {

    private final FeedbacksRepository feedbacksRepository;

    @Override
    public void run(String... args) throws Exception {
        Feedback feedback = new Feedback();
        feedback.setAuthorName("Harry Potter");
        feedback.setAuthorEmail("harry.potter@hogwarts.com");
        feedback.setContent("I am a wizard");
        feedback.setCategory(FeedbackCategory.REGISTRATION);

        feedbacksRepository.save(feedback);
    }
}
