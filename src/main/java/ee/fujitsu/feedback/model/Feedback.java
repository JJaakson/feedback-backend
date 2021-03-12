package ee.fujitsu.feedback.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private String authorEMail;
    private String content;
    @Enumerated(EnumType.STRING)
    private FeedbackCategory category;
}
