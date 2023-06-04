package springboot.bitlab.projects.trello.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.bitlab.projects.trello.models.Category;
import springboot.bitlab.projects.trello.models.Folder;
import springboot.bitlab.projects.trello.models.Task;
import springboot.bitlab.projects.trello.services.CategoryService;
import springboot.bitlab.projects.trello.services.FolderService;
import springboot.bitlab.projects.trello.services.TaskService;

import java.util.HashSet;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final FolderService folderService;
    private final TaskService taskService;
    private final CategoryService categoryService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("folders", folderService.findAll());
        return "index";
    }
    @PostMapping(value = "/folder/create")
    public String createFolder(Folder folder) {
        folderService.save(folder);
        return "redirect:/";
    }

    @GetMapping(value = "/folder/details/{folderId}")
    public String folderDetails(@PathVariable Long folderId, Model model) {
        Folder folder = folderService.findById(folderId);
        model.addAttribute("folder", folder);
        List<Category> categories = categoryService.findAll();
        categories.removeAll(folder.getCategories());
        model.addAttribute("categories", categories);
        model.addAttribute("tasks", folder.getTasks());
        return "folder-details";
    }

    @PostMapping("/task/create")
    public String createTask(@RequestParam Long folderId, Task task) {
        Folder folder = folderService.findById(folderId);
        if (folder == null) {
            return "redirect:/";
        }
        task.setStatus(0);
        task.setFolder(folder);
        taskService.save(task);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/folder/attach/category")
    public String attachCategory(@RequestParam Long folderId, @RequestParam Long categoryId) {
        Folder folder = folderService.findById(folderId);
        Category category = categoryService.findById(categoryId);
        if (folder == null || category == null) {
            return "redirect:/";
        }
        folder.getCategories().add(category);
        folderService.save(folder);
        return "redirect:/folder/details/" + folderId;
    }

    @PostMapping("/folder/detach/category")
    public String detachCategory(@RequestParam Long folderId, @RequestParam Long categoryId) {
        Folder folder = folderService.findById(folderId);
        Category category = categoryService.findById(categoryId);
        if (folder == null || category == null) {
            return "redirect:/";
        }
        folder.getCategories().remove(category);
        folderService.save(folder);
        return "redirect:/folder/details/" + folderId;
    }
}
