package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String newArticleForm() {
        return "members/new";
    }

    @PostMapping("/join") //form - action 경로와 반드시 일치
    public String createArticle(MemberForm form) {
        log.info(form.toString());

        //DTO -> Entity
        Member member = form.toEntity();
        log.info(member.toString());

        //Repository -> Entity DB SAVE
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        //ID 기준 데이터 조회하기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        //조회결과 담은 변수를 모델에 담기
        model.addAttribute("member", memberEntity);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        //전체 데이터 조회하기
        List<Member> memberList = memberRepository.findAll();

        //조회결과 담은 변수를 모델에 담기
        model.addAttribute("memberList", memberList);

        return "members/index";
    }
}
