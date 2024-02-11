package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    } // /articles/new url 요청

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        return "";
    } // new.mustache에서 전송받은 폼 데이터가 post형식으로 전달 되었기에 이를 받아주는 controller 코드 작성.
    // 이를 위해 dto(data transfer object)에 전달된 폼 데이터를 담는다.
}
