package com.example.picket.dto;

import com.example.picket.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CustomerForm {
    private Long uid;
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
        return new Customer(uid, id, pass, email, name, birthdate, tel, card, balance, point);
    }
}
