package joaocarlos.crud.service;

import joaocarlos.crud.dto.TodoCreateDto;
import joaocarlos.crud.dto.TodoDto;
import joaocarlos.crud.entity.Todo;
import joaocarlos.crud.entity.User;
import joaocarlos.crud.repository.TodoRepository;
import joaocarlos.crud.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // Injeção de dependência
    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    // Converter Entity para DTO (Exit)
    private TodoDto toDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getPriority(), todo.getUser().getId());
}

    // Converter DTO para Entity (Entry)
    private Todo toEntity(TodoCreateDto tododto) {
        Todo todo = new Todo();
        todo.setTitle(tododto.title());
        todo.setDescription(tododto.description());
        todo.setPriority(tododto.priority());
        return todo;
    }

    // Métodos
    // Criar
    public TodoDto create (TodoCreateDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Todo todo = toEntity(dto);
        todo.setUser(user);

        return toDto(todoRepository.save(todo));
    }
    // Alterar
    public TodoDto update (long id, TodoCreateDto dto) {
        Todo todo = todoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Task not found"));
        todo.setTitle(dto.title());
        todo.setDescription(dto.description());
        todo.setPriority(dto.priority());

        return toDto(todoRepository.save(todo));
    }
    // Deletar
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
    // Listar todos
    public List<TodoDto> list() {
        Sort sort = Sort.by("priority").descending();
        return todoRepository.findAll(sort).stream().
                map(this::toDto).
                toList();
    }

    public List<TodoDto> findByTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is null or empty");
        }
        return todoRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<TodoDto> findByDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description is null or empty");
        }
        return todoRepository.findByDescriptionContainingIgnoreCase(description);
    }


}
