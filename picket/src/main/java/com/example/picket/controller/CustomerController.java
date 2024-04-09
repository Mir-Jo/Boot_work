package com.example.picket.controller;


import com.example.picket.dto.CustomerForm;
import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String createUser(CustomerForm form){
//        log.info(form.toString());
        Customer customer = form.toEntity();
//        log.info(customer.toString());
        Customer saved = customerRepository.save(customer);
        if( saved != null) {
        return "/login-after-sign";
        }else{
        return null;
        }
    }
}
