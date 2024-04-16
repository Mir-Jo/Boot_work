package com.example.picket.dto;

import com.example.picket.entity.Performance;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PerformanceForm {
    private String title;
    private String place;
    private String category;
    private Long tickets;

    public Performance toEntity() { return new Performance(title,place,category,tickets);}
}
