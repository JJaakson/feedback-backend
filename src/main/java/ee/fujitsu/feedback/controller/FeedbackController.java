package ee.fujitsu.feedback.controller;

import ee.fujitsu.feedback.model.Feedback;
import ee.fujitsu.feedback.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("feedback")
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("all")
    public List<Feedback> getFeedbacks() {
        return feedbackService.findAll();
    }

    @PostMapping
    public Feedback saveFeedback(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }
}
