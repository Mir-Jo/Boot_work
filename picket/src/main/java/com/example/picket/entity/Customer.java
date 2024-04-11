package com.example.picket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer {
    @Id
    private String id;
    @Column
    private String pass;
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String birthdate;
    @Column
    private String tel;
    @Column
    private Long card;
    @Column
    private Long balance;
    @Column
    private Long point;
}
