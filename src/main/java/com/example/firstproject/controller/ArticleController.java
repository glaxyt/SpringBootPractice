package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j //logging 기능을 위한 어노테이션 추가
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    } // /articles/new url 요청

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        // System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntitiy();
        log.info(article.toString());
        // System.out.println(article.toString());
        // 2. 리파지터리롤 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());
        return "";
    } // new.mustache에서 전송받은 폼 데이터가 post형식으로 전달 되었기에 이를 받아주는 controller 코드 작성.
    // 이를 위해 dto(data transfer object)에 전달된 폼 데이터를 담는다.
}
