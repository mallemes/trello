package springboot.bitlab.projects.trello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.bitlab.projects.trello.models.Comment;
import springboot.bitlab.projects.trello.repositories.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
