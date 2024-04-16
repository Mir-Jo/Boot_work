package com.example.picket.dto;

import com.example.picket.entity.FAQ;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class FAQForm {
    private String faqTitle;
    private String faqCategory;
    private String faqContent;

    public FAQ toEntity(){ return new FAQ(faqTitle, faqCategory, faqContent);}

}
