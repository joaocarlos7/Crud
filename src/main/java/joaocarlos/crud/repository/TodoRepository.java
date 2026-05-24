package joaocarlos.crud.repository;

import joaocarlos.crud.dto.TodoDto;
import joaocarlos.crud.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<TodoDto> findByTitleContainingIgnoreCase(String title);
    List<TodoDto> findByDescriptionContainingIgnoreCase(String description);


}


