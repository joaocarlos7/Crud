package joaocarlos.crud.entity;


import jakarta.persistence.*;
import lombok.Data;

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

}
