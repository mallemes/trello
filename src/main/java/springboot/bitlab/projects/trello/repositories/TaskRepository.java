package springboot.bitlab.projects.trello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.bitlab.projects.trello.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
