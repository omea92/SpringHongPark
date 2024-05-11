package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //클라이언트 호출받으면 컨트롤러가 받는다
public class FirstController {

    @GetMapping("/hi") //URL 경로 GET방식 매핑
    public String niceToMeetYou(Model model) { //화면에 전달할 데이터 바구니 MODEL
        model.addAttribute("username", "hongpark"); // MUSTACHE 파라미터 필드 매핑
        return "greetings"; //화면단 소스명과 반드시 일치
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
