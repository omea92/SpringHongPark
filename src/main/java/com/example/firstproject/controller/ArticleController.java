package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
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
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create") //form - action 경로와 반드시 일치
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        //DTO -> Entity
        Article article = form.toEntity();
        log.info(article.toString());

        //Repository -> Entity DB SAVE
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        //ID 기준으로 데이터 조회
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //모델에 조회결과 담은 데이터변수 등록하기
        model.addAttribute("article", articleEntity);

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        //전체 데이터 조회
        List<Article> articleEntityList = articleRepository.findAll();

        //전체데이터 조회결과 담은 변수를 모델에 담기
        model.addAttribute("articleList", articleEntityList);

        return "articles/index";
    }
}
