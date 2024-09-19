package test.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {
    
    @GetMapping("/")
    public String getMainPage() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return "Main Controller : " + name;
    }
}
