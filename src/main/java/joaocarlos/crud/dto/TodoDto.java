package joaocarlos.crud.dto;

public record TodoDto (Long id, String title, String description, int priority, Long userId) {
}
