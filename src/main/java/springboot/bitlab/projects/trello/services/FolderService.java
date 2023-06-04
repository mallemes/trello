package springboot.bitlab.projects.trello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.bitlab.projects.trello.models.Folder;
import springboot.bitlab.projects.trello.models.Task;
import springboot.bitlab.projects.trello.repositories.FolderRepository;

import java.util.List;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public void save(Folder folder) {
        folderRepository.save(folder);
    }
    public void delete(Folder folder) {
        folderRepository.delete(folder);
    }
    public Folder findById(Long id) {
        return folderRepository.findById(id).orElse(null);
    }
    public List<Folder> findAll() {
        return folderRepository.findAll();
    }

    public List<Task> findAllByFolder(Folder folder){
        return folder.getTasks();
    }
}
