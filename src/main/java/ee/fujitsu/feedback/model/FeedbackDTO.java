package ee.fujitsu.feedback.model;

import java.util.List;

public class FeedbackDTO {

    private String authorName;
    private String authorEmail;
    private String content;
    private String[] categories;

    public FeedbackDTO(String authorName, String authorEmail, String content, String[] categories) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.content = content;
        this.categories = categories;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public String getContent() {
        return content;
    }

    public String[] getCategories() {
        return categories;
    }
}
