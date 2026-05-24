package joaocarlos.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Data
@Entity
@Table(name = "todo")

public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private int priority;


    public Todo(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public Todo() {}

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
