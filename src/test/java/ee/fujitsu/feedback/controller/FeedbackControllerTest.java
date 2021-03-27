package ee.fujitsu.feedback.controller;

import ee.fujitsu.feedback.model.FeedbackDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeedbackControllerTest {

    public static final ParameterizedTypeReference<List<FeedbackDTO>> LIST_OF_FEEDBACKS =
            new ParameterizedTypeReference<>() { };

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void one_can_query_feedbacks() {
        ResponseEntity<List<FeedbackDTO>> exchange = testRestTemplate.exchange("/feedback/all",
                HttpMethod.GET, null, LIST_OF_FEEDBACKS);
        List<FeedbackDTO> feedbacks = assertOk(exchange);
        assertFalse(feedbacks.isEmpty());
        FeedbackDTO feedback = feedbacks.get(0);
        assertEquals("Mary Smith", feedback.getAuthorName());
    }

    @Test
    void one_can_save_one_feedback() {
        FeedbackDTO newFeedback = new FeedbackDTO();
        newFeedback.setAuthorName("Pille");
        newFeedback.setAuthorEmail("pille@mail.ee");
        newFeedback.setContent("8/10 is fine");
        List<String> categories = new ArrayList<>();
        categories.add("1");
        categories.add("2");
        newFeedback.setCategories(categories);
        ResponseEntity<FeedbackDTO> exchange = testRestTemplate.exchange("/feedback",
                HttpMethod.POST, new HttpEntity<>(newFeedback), FeedbackDTO.class);
        FeedbackDTO addedFeedback = assertOk(exchange);
        assertNotNull(addedFeedback.getId());
        assertEquals("Pille", addedFeedback.getAuthorName());
        assertEquals("pille@mail.ee", addedFeedback.getAuthorEmail());
        assertEquals("8/10 is fine", addedFeedback.getContent());
        assertEquals(2, addedFeedback.getCategories().size());
        ResponseEntity<List<FeedbackDTO>> exchangeList = testRestTemplate.exchange("/feedback/all",
                HttpMethod.GET, null, LIST_OF_FEEDBACKS);
        List<FeedbackDTO> feedbacks = assertOk(exchangeList);
        assertEquals(2, feedbacks.size());
    }

    private <T> T assertOk(ResponseEntity<T> exchange) {
        assertNotNull(exchange.getBody());
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        return exchange.getBody();
    }

}
