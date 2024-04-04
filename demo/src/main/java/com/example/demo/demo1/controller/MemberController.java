package com.example.demo.demo1.controller;

import com.example.demo.demo1.dto.MemberForm;
import com.example.demo.demo1.entity.Member;
import com.example.demo.demo1.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    private Member other;
    @GetMapping("/signup")
        public String newMemberForm() { return "members/new"; }

    @PostMapping("/join")
    public String createMember(MemberForm form) {
        log.info(form.toString());
        Member member = form.toEntity();
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "redirect:/members/"+saved.getMemId();
    }
    @GetMapping("/members/{memId}")
    public String show(@PathVariable Long memId, Model model){
        log.info("memId = "+memId);
        Member member = memberRepository.findById(memId).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        ArrayList<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/index";
    }

    @GetMapping("/members/{memId}/edit")
    public String edit(@PathVariable Long memId, Model model){
        Member memberEntity = memberRepository.findById(memId).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }
    @PostMapping("/members/update")
    public String update(MemberForm form){
        log.info(form.toString());
        Member memberEntity = form.toEntity();
        log.info(memberEntity.toString());
        Member target = memberRepository.findById(memberEntity.getMemId()).orElse(null);
        if(target!= null){
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/"+memberEntity.getMemId();
    }
    @GetMapping("/members/{memId}/delete")
    public String delete(@PathVariable Long memId,RedirectAttributes rttr){
        log.info("삭제요청됨");
        Member target = memberRepository.findById(memId).orElse(null);
        log.info(target.toString());
        if(target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("memmsg", "삭제됐습니다!");
        }
            return "redirect:/members";
    }
}
