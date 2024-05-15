package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String newArticleForm() {
        return "members/new";
    }

    @PostMapping("/join") //form - action 경로와 반드시 일치
    public String createArticle(MemberForm form) {
        System.out.println(form.toString());

        //DTO -> Entity
        Member member = form.toEntity();
        System.out.println(member.toString());

        //Repository -> Entity DB SAVE
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }
}
