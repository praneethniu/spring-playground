package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class PiController {
    @GetMapping("/pi")
    public String pi() {
        return String.valueOf(Math.PI);
    }
}
