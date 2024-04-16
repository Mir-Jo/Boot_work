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
public class WishList {
    @Id
    @Column(name = "W_TITLE")
    private String wTitle;
    @Column(name="W_ID", nullable = false)
    private String wId;
}
