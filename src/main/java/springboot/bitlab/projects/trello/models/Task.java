package springboot.bitlab.projects.trello.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "t_tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description; // TEXT

    @Column(name = "status")
    private int status;  // 0 - todo, 1 - intest, 2 - done, 3 - failed

    @Column(name = "folder")
    private int folder; // Many To One


}
