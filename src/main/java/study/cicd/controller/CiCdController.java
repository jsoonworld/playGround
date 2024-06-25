package study.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiCdController {

    @GetMapping("/")
    public String testController() {
        return "Hello, terning!";
    }
}
