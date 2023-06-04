package springboot.bitlab.projects.trello.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "t_tasks")
@Getter
@Setter
@ToString
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

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, optional = false,
            targetEntity = Folder.class)
    private Folder folder; // Many To One

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            targetEntity = Comment.class,
            mappedBy = "task"
    )
    private List<Comment> comments; // One To Many
}
