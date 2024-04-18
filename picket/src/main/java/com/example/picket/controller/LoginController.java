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

    @PostMapping("/login")
    public String login(String id, String password, HttpSession session, Model model, RedirectAttributes rttr){
        if (loginService.authenticate(id, password)){
            Customer customer = customerRepository.findById(id).orElse(null);
            String name = customer.getName();
            session.setAttribute("id",id);
            setSessionTimeout(session, 30);
            if(name != null){
            rttr.addFlashAttribute("logined", name+"님 환영합니다.");
            }
            return "redirect:/loginmain";
    } else{
        model.addAttribute("error", "잘못된 ID 혹은 비밀번호입니다.");
        return "/login/login";
        }
    }
    public void setSessionTimeout(HttpSession session, int minutes){
        int seconds = minutes * 60;
        session.setMaxInactiveInterval(seconds);
    }
}
