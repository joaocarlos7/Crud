package joaocarlos.crud.dto;




// Controla o que irá retornar do banco
public record UserCreateDto(Long id, String name, String mail, String password) {


}