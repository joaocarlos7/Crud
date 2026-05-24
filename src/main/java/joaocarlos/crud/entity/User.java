package joaocarlos.crud.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import jakarta.persistence.OneToMany;

@Data // Importa Getters e Setters Automaticamente
@Entity // Representa uma entidade do Banco
@Table(name = "users") // Representa a tabela do banco


public class User {

    @Id // Sinaliza que irá ser o ID da entidade
    @GeneratedValue // Será gerenciado de forma sequencial o ID
    private Long id;

    private String name;
    private String mail;
    private String password;

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public User() {}

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Todo> todo;
}
