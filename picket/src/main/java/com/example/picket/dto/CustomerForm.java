package com.example.picket.dto;

import com.example.picket.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CustomerForm {
    private String id;
    private String pass;
    private String email;
    private String name;
    private String birthdate;
    private String tel;
    private Long card;
    private Long balance;
    private Long point;


    public Customer toEntity(){
        return new Customer(id, pass, email, name, birthdate, tel, card, 1000000L, 0L);
    }
}
