package joaocarlos.crud.service;

import joaocarlos.crud.dto.UserCreateDto;
import joaocarlos.crud.dto.UserDto;
import joaocarlos.crud.entity.User;
import joaocarlos.crud.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;

    // Injeção de dependência
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Converter: Entity -> DTO (Exit)
    private UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getMail());
    }

    // Converter: DTO -> Entity (Entry)
    private User toEntity(UserCreateDto userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setMail(userDto.mail());
        user.setPassword(userDto.password());
        return user;
    }


    // Métodos públicos, Inserir, Apagar, Listar e Atualizar

    // Criar
    public UserDto create(UserCreateDto dto) {
         return toDto(userRepository.save(toEntity(dto)));
    }
    // Atualizar
    public UserDto update(Long id, UserCreateDto dto) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found: " + id));
        user.setName(dto.name());
        user.setMail(dto.mail());
        user.setPassword(dto.password());

        return toDto(userRepository.save(user));
    }
    // Deletar
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    // Listar todos
    public List<UserDto> list() {
        Sort sort = Sort.by("name").ascending();
        return userRepository.findAll(sort).stream().
                map(this::toDto).
                toList();
    }
    // Encontrar pelo ID
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

}
