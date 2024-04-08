package com.example.picket.dto;

import com.example.picket.entity.QA;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class QAForm {
    private Long qaId;
    private Long category;
    private String name;
    private String tel;
    private String title;
    private String content;

    public QA toEntity(){
        return new QA(qaId, category, name, tel, title, content);
    }
}
