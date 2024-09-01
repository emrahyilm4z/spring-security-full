package emrah.basicauth.controller;

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
        return "Hello World Private";
    }

    @GetMapping("/user")
    public String helloWorldUserPrivate() {
        return "Hello World Private User";
    }

    @GetMapping("/admin")
    public String helloWorldAdminPrivate() {
        return "Hello World Private Admin";
    }
}
