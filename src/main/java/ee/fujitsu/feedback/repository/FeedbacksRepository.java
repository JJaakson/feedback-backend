package ee.fujitsu.feedback.repository;

import ee.fujitsu.feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbacksRepository extends JpaRepository<Feedback, Long> {
}
