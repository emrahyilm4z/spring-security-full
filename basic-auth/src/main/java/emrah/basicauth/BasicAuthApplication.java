package emrah.basicauth;

import emrah.basicauth.dto.CreateUserRequest;
import emrah.basicauth.entities.Role;
import emrah.basicauth.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

    private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) {
        createDummyData();
    }

    private void createDummyData() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name("emrah")
                .userName("emrah12")
                .password("admin")
                .authorities(Set.of(Role.ROLE_EMRAH))
                .build();

        userService.createUser(createUserRequest);

        CreateUserRequest createUserRequest1 = CreateUserRequest.builder()
                .name("apo")
                .userName("apo123")
                .password("admin")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();

        userService.createUser(createUserRequest1);

        CreateUserRequest createUserRequest2 = CreateUserRequest.builder()
                .name("ent")
                .userName("ent123")
                .password("admin")
                .authorities(Set.of(Role.ROLE_USER))
                .build();

        userService.createUser(createUserRequest2);
    }


}
