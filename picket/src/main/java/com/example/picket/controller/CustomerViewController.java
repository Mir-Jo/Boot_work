package com.example.picket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerViewController {
    @PostMapping("/login")
    public String login(){
        return "/loginmain";
    }
}
