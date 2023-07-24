package com.ll.exam.test2.article;

import com.ll.exam.test2.article.Article;
import com.ll.exam.test2.article.ArticleRepository;
import com.ll.exam.test2.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;


    public void create(String title, String content, SiteUser author) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        this.articleRepository.save(article);
    }


    public List<Article> getList(){
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        return article.get();
    }
    public void modify(Article article, String title, String content) {
        article.setContent(content);
        article.setTitle(title);
        this.articleRepository.save(article);

    }
    public void delete(Article article)  {

        this.articleRepository.delete(article);

    }


}