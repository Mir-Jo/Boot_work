package com.example.picket.controller;

import com.example.picket.dto.QAForm;
import com.example.picket.entity.QA;
import com.example.picket.repository.QARepository;
import com.example.picket.service.QAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class QAController {

    @Autowired
    private QARepository qaRepository;

    @PostMapping("/newQA")
    public String sendQA(QAForm form, RedirectAttributes rttr) {
        QA qa = form.toEntity();
        if (qa.getName() == null || qa.getName().trim().equals("")) {
            rttr.addFlashAttribute("QAError", "이름을 입력해주세요.");
            return "redirect:/QAWrite";
        }
        if (qa.getTel() == null || qa.getTel().trim().equals("")) {
            rttr.addFlashAttribute("QAError", "전화번호를 입력해주세요.");
            return "redirect:/QAWrite";
        }
        if (qa.getTitle() == null || qa.getTitle().trim().equals("")) {
            rttr.addFlashAttribute("QAError", "제목을 입력해주세요.");
            return "redirect:/QAWrite";
        }
        if (qa.getComment() == null || qa.getComment().trim().equals("")) {
            rttr.addFlashAttribute("QAError", "내용을 입력해주세요.");
            return "redirect:/QAWrite";
        }
            QA savedQA = qaRepository.save(qa);
            rttr.addFlashAttribute("QASuccess", "문의가 등록되었습니다.");
            return "redirect:/QAList";
    }
}
