package springboot.bitlab.projects.trello.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_folders")
@Getter
@Setter
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            targetEntity = Category.class)
    private List<Category> categories; // Many To Many bidirectional

    @OneToMany(fetch = FetchType.EAGER,
            targetEntity = Task.class, mappedBy = "folder")
    private  List<Task> tasks; // One To Many
}
