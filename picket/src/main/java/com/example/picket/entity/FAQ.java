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
public class FAQ {
    @Id
    @Column(name="FAQ_TITLE")
    private String faqTitle;
    @Column(name="FAQ_CATEGORY", nullable = false)
    private String faqCategory;
    @Column(name="FAQ_CONTENT", nullable = false)
    private String faqContent;
}
