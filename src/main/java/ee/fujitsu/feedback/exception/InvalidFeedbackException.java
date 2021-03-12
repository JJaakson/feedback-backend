package ee.fujitsu.feedback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFeedbackException extends RuntimeException {

    public InvalidFeedbackException() {
    }

    public InvalidFeedbackException(String message) {
        super(message);
    }
}
