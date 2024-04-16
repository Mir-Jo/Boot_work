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
import java.util.Optional;

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
    public String createUser(CustomerForm form, RedirectAttributes rttr) {
        String userId = form.getId();
        String username = form.getName();
        Customer idCheck = customerRepository.findById(userId).orElse(null);
        /* 회원가입중 예외처리 */
        if (idCheck != null) {
            rttr.addFlashAttribute("message","이미 사용중인 ID입니다!");
            return "redirect:/loginpage";
        } else if (userId.length() > 20) {
            rttr.addFlashAttribute("message", "유효하지 않은 ID입니다!");
            return "redirect:/loginpage";
        } else if (username.trim().isEmpty() || username.length() > 15) {
            rttr.addFlashAttribute("message", "유효하지 않은 이름입니다!");
            return "redirect:/loginpage";
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
    public String findId(String name, String tel, RedirectAttributes rttr) {
        List<Customer> checkName = customerRepository.findByName(name);
        Customer checkTel = customerRepository.findByTel(tel);

        if (checkName != null && checkTel != null) {
            for (Customer customer : checkName) {
                if (customer.getId().equals(checkTel.getId())) {
                    String foundId = checkTel.getId();
                    rttr.addFlashAttribute("foundId", foundId);
                    return "redirect:/FindIDPW";
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
            rttr.addFlashAttribute("findIdError", "ID가 존재하지 않습니다.");
            return "redirect:/FindIDPW";
        }
    }

    /* 비밀번호 찾기 */
    @PostMapping("/findPass")
    public String findPass(String name, String tel, String id,RedirectAttributes rttr){
        List<Customer> checkName = customerRepository.findByName(name);
        Customer checkTel = customerRepository.findByTel(tel);
        Customer checkId = customerRepository.findById(id).orElse(null);
        if(checkId != null && checkTel != null && checkName != null){
            if(checkId.getPass().equals(checkTel.getPass())){
                String foundPass = checkTel.getPass();
                rttr.addFlashAttribute("foundPass", foundPass);
                return "redirect:/FindIDPW";
            }
        } else if(checkId == null){
            rttr.addFlashAttribute("findPWError",
                    "입력하신 정보로 등록된 계정이 없습니다. 회원가입을 진행해주세요.");
            return "redirect:/FindIDPW";
        } else {
        rttr.addFlashAttribute("findPWError",
                "입력하신 정보로 등록된 계정을 찾을 수 없습니다. 다시 시도해주세요.");
        }
        return "redirect:/FindIDPW";
    }
}