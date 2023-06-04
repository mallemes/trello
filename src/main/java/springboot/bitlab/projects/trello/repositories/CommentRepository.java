package springboot.bitlab.projects.trello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.bitlab.projects.trello.models.Comment;

@Repository
public interface  CommentRepository extends JpaRepository<Comment, Long> {
}
