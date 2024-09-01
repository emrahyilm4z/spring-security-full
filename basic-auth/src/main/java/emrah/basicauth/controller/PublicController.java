package emrah.basicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String helloWorldPublic() {
        return "Hello World Public";
    }

    @GetMapping("/user")
    public String helloWorldUserPublic() {
        return "Hello World Public User";
    }

    @GetMapping("/admin")
    public String helloWorldAdminPublic() {
        return "Hello World Public Admin";
    }
}
