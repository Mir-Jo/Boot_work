package com.example.picket.service;

import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private CustomerRepository customerRepository;


    public boolean authenticate(String id, String password) {
        Customer customerId = customerRepository.findById(id).orElse(null);
        Customer customerPw = customerRepository.findByPass(password).orElse(null);
        if(customerId != null && customerPw != null) {
            if(customerId.getPass().equals(customerPw.getPass())){
                return true;
            }
        }
        return false;
    }
}
