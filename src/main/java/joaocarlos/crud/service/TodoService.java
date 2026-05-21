package joaocarlos.crud.service;

import joaocarlos.crud.dto.TodoCreateDto;
import joaocarlos.crud.dto.TodoDto;
import joaocarlos.crud.entity.Todo;
import joaocarlos.crud.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private TodoDto toDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getPriority());
}

    private Todo toEntity(TodoCreateDto tododto) {
        Todo todo = new Todo();
        todo.setTitle(tododto.title());
        todo.setDescription(tododto.description());
        todo.setPriority(tododto.priority());
        return todo;
    }


    public TodoDto create (TodoCreateDto dto) {
        return toDto(todoRepository.save(toEntity(dto)));
    }
    public TodoDto update (long id, TodoCreateDto dto) {
        Todo todo = todoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Task not found"));
        todo.setTitle(dto.title());
        todo.setDescription(dto.description());
        todo.setPriority(dto.priority());

        return toDto(todoRepository.save(todo));
    }
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
    public List<TodoDto> list() {
        Sort sort = Sort.by("priority").descending();
        return todoRepository.findAll(sort).stream().
                map(this::toDto).
                toList();
    }


}
