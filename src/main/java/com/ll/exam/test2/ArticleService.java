package com.ll.exam.test2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public List<Article> getList(){
        return this.articleRepository.findAll();
    }


    public void create(String title, String content){
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);

    }
}
