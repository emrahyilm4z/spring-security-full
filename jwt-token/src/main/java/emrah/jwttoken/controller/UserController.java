package emrah.jwttoken.controller;

import emrah.jwttoken.dto.AuthRequest;
import emrah.jwttoken.dto.CreateUserRequest;
import emrah.jwttoken.entities.User;
import emrah.jwttoken.services.AuthenticationService;
import emrah.jwttoken.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@RestController
@Slf4j
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello World!";
    }

    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody CreateUserRequest createUserRequest) {

        return userService.createUser(createUserRequest);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest) {

        return authenticationService.authenticate(authRequest);

    }

    @GetMapping("/user")
    public String getUserString() {

        return "This is the User";
    }

    @GetMapping("/admin")
    public String getAdminString() {

        return "This is the Admin";
    }

}
