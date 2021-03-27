package ee.fujitsu.feedback.service;

import ee.fujitsu.feedback.exception.InvalidFeedbackException;
import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.model.FeedbackDTO;
import ee.fujitsu.feedback.repository.FeedbacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<FeedbackDTO> findAll() {
        return feedbacksRepository.findAll().stream()
                .map(this::convertFeedback)
                .collect(Collectors.toList());
    }

    public Feedback save(FeedbackDTO feedbackDTO) {
        List<String> categoryArray = feedbackDTO.getCategories();
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

    private FeedbackDTO convertFeedback(Feedback feedback) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setId(feedback.getId());
        dto.setAuthorName(feedback.getAuthorName());
        dto.setAuthorEmail(feedback.getAuthorEmail());
        dto.setContent(feedback.getContent());
        dto.setCategories(feedback.getCategories());
        return dto;
    }
}
