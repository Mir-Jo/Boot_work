package com.example.picket.service;

import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerDetailService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer loadUserByUsername(String id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(id));
    }
}
