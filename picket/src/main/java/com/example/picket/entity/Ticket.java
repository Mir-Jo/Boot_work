package com.example.picket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Ticket {
    @Id
    @Column(name="T_NUM")
    private String tNum;
    @Column(name="T_DATE", nullable = false)
    private String tDate;
    @Column(name = "T_TITLE", nullable = false)
    private String tTitle;
    @JoinColumn(name="customer_id")
    private String id;
}
