package emrah.springsecurityfolksdev.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */


@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String helloWorldPrivate() {
        return "Hello World! form Private";
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String helloWorldUser() {
        return "Hello World! form User";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloWorldAdmin() {
        return "Hello World! form Admin";
    }
}
