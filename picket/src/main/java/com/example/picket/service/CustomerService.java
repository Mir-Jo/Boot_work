package com.example.picket.service;

import com.example.picket.dto.AddCustomerRequest;
import com.example.picket.entity.Customer;
import com.example.picket.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final Long DEFAULT_BALANCE = 1000000L;
    private static final Long DEFAULT_POINT = 0L;
    public String save(AddCustomerRequest dto) {
        return customerRepository.save(Customer.builder()
                .id(dto.getId())
                .pass(bCryptPasswordEncoder.encode(dto.getPass()))
                .email(dto.getEmail())
                .name(dto.getName())
                .birthdate(dto.getBirthdate())
                .tel(dto.getTel())
                .card(dto.getCard())
                .balance(dto.getBalance() != null ? dto.getBalance() : DEFAULT_BALANCE)
                .point(dto.getPoint() != null ? dto.getPoint(): DEFAULT_POINT)
                .build()).getId();
    }
}
