package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "";
    }
}
