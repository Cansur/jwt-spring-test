package test.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import test.demo.dto.JoinDto;
import test.demo.service.JoinService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService){
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String postMethodName(JoinDto joinDto) {
        System.out.println(joinDto.getUsername());
        joinService.joinProcess(joinDto);
        return "ok";
    }
    
}
