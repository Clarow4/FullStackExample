package com.example.nateratechinterview;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nateratechinterview.entities.Articles;
import com.example.nateratechinterview.repositories.ArticleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticlesController {

    private ArticleRepository articleRepository;

    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/articles")
    public Iterable<Articles> getArticles() {
        return articleRepository.findAll();
    }

    @PostMapping("/articles/")
    public HttpStatus addArticle(@RequestBody Articles article) {
        articleRepository.save(article);

        return HttpStatus.CREATED;
    }
}
