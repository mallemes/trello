package springboot.bitlab.projects.trello.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_comments")
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="comment")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Task.class)
    private Task task;


}
