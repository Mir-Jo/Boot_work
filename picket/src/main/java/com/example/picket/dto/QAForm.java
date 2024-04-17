package com.example.picket.dto;

import com.example.picket.entity.QA;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class QAForm {
    private Long qaId;
    private String category;
    private String name;
    private String tel;
    private String title;
    private String comment;

    public QA toEntity(){
        return new QA(qaId, category, name, tel, title, comment);
    }
}
