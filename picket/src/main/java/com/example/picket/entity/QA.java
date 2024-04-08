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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qaId;
    @Column
    private Long category;
    @Column
    private String name;
    @Column
    private String tel;
    @Column
    private String title;
    @Column
    private String content;
}
