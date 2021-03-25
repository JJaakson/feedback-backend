package ee.fujitsu.feedback.service;

import ee.fujitsu.feedback.exception.InvalidFeedbackException;
import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.model.FeedbackDTO;
import ee.fujitsu.feedback.repository.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FeedbackService {

    @Autowired
    private FeedbacksRepository feedbacksRepository;

    private final Map<Integer, String> categories = new HashMap<>() {{
        put(1, "Patients portal");
        put(2, "Doctors portal");
        put(3, "Registration");
        put(4, "Virtual visit");
        put(5, "OpenKM");
        put(6, "Microsoft SharePoint");
    }};

    public List<Feedback> findAll() {
        return feedbacksRepository.findAll();
    }

    public Feedback save(FeedbackDTO feedbackDTO) {
        String[] categoryArray = feedbackDTO.getCategories();
        if (feedbackDTO.getAuthorName() == null || feedbackDTO.getAuthorEmail() == null
                || feedbackDTO.getContent() == null || categoryArray == null) {
            throw new InvalidFeedbackException("Insufficient data");
        }
        List<String> correctCategories = new ArrayList<>();
        for (String s : categoryArray) {
            correctCategories.add(categories.get(Integer.parseInt(s)));
        }
        Feedback feedback = new Feedback();
        feedback.setAuthorName(feedbackDTO.getAuthorName());
        feedback.setAuthorEmail(feedbackDTO.getAuthorEmail());
        feedback.setCategories(correctCategories);
        feedback.setContent(feedbackDTO.getContent());
        return feedbacksRepository.save(feedback);
    }
}
