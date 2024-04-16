package com.example.picket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Performance {
    @Id
    @Column(name="title")
    private String title;
    @Column(name = "place", nullable = false)
    private String place;
    @Column(name = "category", unique = true, nullable = false)
    private String category;
    @Column(name = "tickets", nullable = false)
    private Long tickets;
}
