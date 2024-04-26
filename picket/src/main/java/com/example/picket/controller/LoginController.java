package com.example.picket.controller;

import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import com.example.picket.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    private String login(String id, String pass, RedirectAttributes rttr){
        if(loginService.authenticate(id, pass)){
            return "redirect:/loginmain";
        } else{
            rttr.addFlashAttribute("error", "아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요.");
            return "redirect:/loginpage";
        }
    }
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/main";
    }
}
