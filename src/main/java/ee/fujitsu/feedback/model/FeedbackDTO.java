package ee.fujitsu.feedback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FeedbackDTO {

    private Long id;
    private String authorName;
    private String authorEmail;
    private String content;
    private List<String> categories;
}
