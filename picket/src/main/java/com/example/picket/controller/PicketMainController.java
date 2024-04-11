package com.example.picket.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class PicketMainController {
    //===================================================================
    /* 링크 이동 컨테이너 */

    /* 메인으로 이동 */
    @GetMapping("/main")
    public String gotoMain() {
        return "main";
    }

    /* 로그인상태인 메인으로 이동 */
    @GetMapping("/loginmain")
    public String gotologinMain(){
        return "/loginmain";
    }

    /* 고객센터로 이동 */
    @GetMapping("/support")
    public String supportMain() { return "/support/support";}

    /* 마이페이지로 이동 */
    @GetMapping("/mypagemain")
    public String gotoMyPage() { return "/mypage/mypagemain";}
    @GetMapping("/profile")
    public String gotoProfile() { return "/mypage/profile";}

    /* 내 문의내역으로 이동 */
    @GetMapping("/QAList")
    public String gotoQAList() { return "/mypage/QA_list";}

    /* 로그인&회원가입 페이지로 이동*/
    @GetMapping("/loginpage")
    public String signupMain() { return "/login/login"; }

    @GetMapping("/FindIDPW")
    public String findIDPW(){ return "/login/FindIDPW"; }

    /* 회원가입 후에 로그인창으로 이동 */
    @PostMapping("/login-after-sign")
    public String signupMainAfterSign(RedirectAttributes rttr) {
        rttr.addFlashAttribute("message", "가입이 완료되었습니다.");
        return "redirect:/loginpage";
    }
    /*회원가입 중 오류발생 */
    @PostMapping("/signupError-duplicatedId")
    public String duplicatedIdError(RedirectAttributes rttr){
        rttr.addFlashAttribute("message","이미 사용중인 ID입니다!");
        return "redirect:/loginpage";
    }
    @PostMapping("/signupError-invalidId")
    public String invalidIdError(RedirectAttributes rttr){
        rttr.addFlashAttribute("message", "유효하지 않은 ID입니다!");
        return "redirect:/loginpage";
    }
    @PostMapping("/signupError-invalidName")
    public String invalidNameError(RedirectAttributes rttr){
        rttr.addFlashAttribute("findIdError", "유효하지 않은 이름입니다!");
        return "redirect:/loginpage";
    }
    /*ID찾은 후 FindIDPW로 이동*/
    @PostMapping("/FindIDPW-IdFound")
    public String idFound(HttpSession session, RedirectAttributes rttr){
        String foundId = (String)session.getAttribute("foundId");
        if(foundId != null ) {
            rttr.addFlashAttribute("foundId", foundId);
        }
        return "redirect:/FindIDPW";
    }

    /* 카테고리별 작품목록으로 이동 */
    @GetMapping("/concertlist")
    public String concertList() {return "/category/ConcertList";}
    @GetMapping("musicallist")
    public String musicalList() {return "/category/MusicalList";}
    @GetMapping("/actlist")
    public String actList() {return "/category/ActList";}
    @GetMapping("/classiclist")
    public String classicList() {return "/category/ClassicList";}
    @GetMapping("/exhibitlist")
    public String exhibitList() {return "/category/ExhibitList";}

    /* 1:1문의 등록으로 이동 */
    @GetMapping("/QAWrite")
    public String gotoQAWrite(){ return "/support/QA_Write"; }
}
