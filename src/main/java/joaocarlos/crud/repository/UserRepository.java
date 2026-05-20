package joaocarlos.crud.repository;

import joaocarlos.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


        // Interface a qual irá acessar o banco
public interface UserRepository extends JpaRepository<User, Long> {
}