package joaocarlos.crud;

import joaocarlos.crud.dto.UserCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudApplicationTests {

    @Test
    void testeCreateSuccess() {
        var crud = new UserCreateDto(2012212222,"laura", "laura@mail.com", "laura123");
    }

    @Test
    void testeCreateFailure() {

    }

}
