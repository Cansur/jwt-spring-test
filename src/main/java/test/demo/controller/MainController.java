package test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
    
    @GetMapping("/")
    public String getMainPage() {
        return "index.html";
    }
    
    @GetMapping("/login")
    public String getLogin() {
        return "index.html";
    }
    
}
