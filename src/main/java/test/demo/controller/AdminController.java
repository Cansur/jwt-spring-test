package test.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AdminController {
    
    @GetMapping("/admin")
    public String getMethodName() {
        return "Admin Controller";
    }
    
}
