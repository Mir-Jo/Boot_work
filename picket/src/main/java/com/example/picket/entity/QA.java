package com.example.picket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class QA {
    @Column(name = "qaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qaId;
    @Column(name="category", nullable = false)
    private Long category;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="tel", nullable = false)
    private String tel;
    @Id
    @Column(name="title")
    private String title;
    @Column(name = "comment", nullable = false)
    private String comment;
}
