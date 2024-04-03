package com.example.demo.demo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long memId;
    @Column
    private String email;
    @Column
    private String password;

    public Long getMemId(){ return memId; }
}
