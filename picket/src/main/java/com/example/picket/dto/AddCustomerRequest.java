package com.example.picket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddCustomerRequest {
    private String id;
    private String pass;
    private String email;
    private String name;
    private String birthdate;
    private String tel;
    private Long card;
    private Long balance;
    private Long point;
}
