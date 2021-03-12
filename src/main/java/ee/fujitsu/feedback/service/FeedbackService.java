package ee.fujitsu.feedback.service;

import ee.fujitsu.feedback.exception.InvalidFeedbackException;
import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.repository.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbacksRepository feedbacksRepository;

    public List<Feedback> findAll() {
        return feedbacksRepository.findAll();
    }

    public Feedback save(Feedback feedback) {
        /* if (feedback.getId() != null || feedback.getAuthorName() != null || feedback.getAuthorEMail() != null
                || feedback.getContent() != null || feedback.getCategory() != null) {
            throw new InvalidFeedbackException("Insufficient data");
        } */
        return feedbacksRepository.save(feedback);
    }
}
