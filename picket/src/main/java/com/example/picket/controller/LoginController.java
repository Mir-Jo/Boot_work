package com.example.picket.controller;

import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import com.example.picket.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoginService loginService;

}
