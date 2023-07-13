package com.ll.exam.test2.article;

import com.ll.exam.test2.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
