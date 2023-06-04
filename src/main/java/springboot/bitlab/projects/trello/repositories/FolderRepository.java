package springboot.bitlab.projects.trello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.bitlab.projects.trello.models.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long> {

}
