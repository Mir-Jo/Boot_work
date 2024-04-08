package com.example.picket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class QAController {
    /* 1:1문의 등록으로 이동 */
    @GetMapping("/QAWrite")
    public String gotoQAWrite(){ return "/support/QA_Write"; }
}
