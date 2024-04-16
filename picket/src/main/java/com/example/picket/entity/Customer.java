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
    @Column(name = "id")
    private String id;
    @Column(name = "pw", nullable=false)
    private String pass;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name= "name", nullable = false)
    private String name;
    @Column(name = "birthdate", nullable = false)
    private String birthdate;
    @Column(name="tel", unique = true, nullable = false)
    private String tel;
    @Column(name="card")
    private Long card;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "point")
    private Long point;
}
