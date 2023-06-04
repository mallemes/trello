package springboot.bitlab.projects.trello.repositories;

import org.springframework.stereotype.Repository;
import springboot.bitlab.projects.trello.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
