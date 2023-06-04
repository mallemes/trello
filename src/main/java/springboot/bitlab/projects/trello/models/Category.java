package springboot.bitlab.projects.trello.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            targetEntity = Folder.class , mappedBy = "categories")
    private List<Folder> folders; // Many To Many  bidirectional


}
