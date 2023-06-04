package springboot.bitlab.projects.trello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.bitlab.projects.trello.models.Comment;
import springboot.bitlab.projects.trello.models.Folder;
import springboot.bitlab.projects.trello.models.Task;
import springboot.bitlab.projects.trello.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.deleteById(task.getId());
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    public List<Comment> taskComments(Task task){
         return task.getComments();
    }

//    public  List<Task> findAllByFolderId(Long id){
//        return taskRepository.findAllByFolderId(id);
//    }




}
