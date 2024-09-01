package emrah.springsecurityfolksdev.security.controller;

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
    public String helloWorld() {
        return "Hello World form Public";
    }
}
