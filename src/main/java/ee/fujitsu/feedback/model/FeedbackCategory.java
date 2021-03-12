package ee.fujitsu.feedback.model;

public enum FeedbackCategory {
    PATIENTS("Patient portal"),
    DOCTORS("Doctors portal"),
    REGISTRATION("Registration"),
    VIRTUAL("Virtual visit"),
    OPENKM("OpenKM"),
    MSSHAREPOINT("Microsoft SharePoint");

    private final String content;

    FeedbackCategory(String content) {
        this.content = content;
    }
}
