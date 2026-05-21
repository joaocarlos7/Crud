package joaocarlos.crud.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "/todo")

public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private int priority;


}
