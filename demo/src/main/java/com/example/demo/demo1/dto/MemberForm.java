package com.example.demo.demo1.dto;

import com.example.demo.demo1.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private Long memId;
    private String email;
    private String password;
    public Member toEntity() {
        return new Member(memId, email, password);
    }
}
