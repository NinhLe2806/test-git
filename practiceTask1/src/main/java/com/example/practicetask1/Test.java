package com.example.practicetask1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class Test {
    @GetMapping("/msg")
    public String test(){
        return "employee";
    }
}

