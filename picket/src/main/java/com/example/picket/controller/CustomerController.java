package com.example.picket.controller;


import com.example.picket.dto.CustomerForm;
import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpRequest;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    /* 변수 선언 컨테이너 */
    @Autowired
    private CustomerRepository customerRepository;
    //=====================================================================
    /* 로그인 컨테이너 */

    /* 회원가입 정보를 전달*/
    @PostMapping("/signup")
    public String createUser(CustomerForm form) {
        String userId = form.getId();
        String username = form.getName();
        Customer idCheck = customerRepository.findById(userId);
        if (idCheck != null) {
            return "/signupError-duplicatedId";
        } else if (userId.length() > 20) {
            return "/signupError-invalidId";
        } else if (username.trim().isEmpty() || username.length() > 15) {
            return "/signupError-invalidName";
        }
        Customer customer = form.toEntity();
        Customer saved = customerRepository.save(customer);
        if (saved != null) {
            return "/login-after-sign";
        }
        return "/signup";
    }

    /* 아이디 찾기 */
    @PostMapping("/findId")
    public String findId(String name, String tel, HttpSession session, RedirectAttributes rttr) {
        List<Customer> checkName = customerRepository.findByName(name);
        Customer checkTel = customerRepository.findByTel(tel);

        if (checkName != null && checkTel != null) {
            for (Customer customer : checkName) {
                if (customer.getId().equals(checkTel.getId())) {
                    String foundId = checkTel.getId();
                    session.setAttribute("foundId", foundId);
                    return "/FindIDPW-IdFound";
                }
            }
            rttr.addFlashAttribute("findIdError", "이름과 전화번호가 일치하지 않습니다.");
            return "redirect:/FindIDPW";
        } else if (checkName != null) {
            rttr.addFlashAttribute("findIdError", "전화번호에 해당하는 ID가 존재하지 않습니다.");
            return "redirect:/FindIDPW";
        } else if (checkTel != null) {
            rttr.addFlashAttribute("findIdError", "이름에 해당하는 ID가 존재하지 않습니다.");
            return "redirect:/FindIDPW";
        } else {
            rttr.addFlashAttribute("message", "ID가 존재하지 않습니다.");
            return "redirect:/FindIDPW";
        }
    }
}