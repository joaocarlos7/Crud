package joaocarlos.crud.controller;


import joaocarlos.crud.dto.TodoCreateDto;
import joaocarlos.crud.dto.TodoDto;
import joaocarlos.crud.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")

public class TodoController {

    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    TodoDto create(@RequestBody TodoCreateDto todo) {
        return todoService.create(todo);
    }

    @PutMapping("{id}") // Irá requisitar um usuário
    TodoDto update(@PathVariable Long id, @RequestBody TodoCreateDto todo) {
        return todoService.update(id, todo);
    }

    @GetMapping // Irá retornar
    List<TodoDto> list() {
        return todoService.list();
    }

    @DeleteMapping("{id}") // Irá requisitar um id como variável
    void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }
}
