package com.ll.exam.test2.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/create")
    private String create(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("article", articleList);

        return "create_form";
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }
    @PostMapping("/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
    @GetMapping("/modify/{id}")
    public String modify(Model model, @PathVariable("id") Integer id, ArticleForm articleForm){
        Article article = this.articleService.getArticle(id);
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        model.addAttribute("article", article);
        return "create_form";
    }
    @PostMapping("/modify/{id}")
    public String modify(Model model, @PathVariable("id") Integer id, @Valid ArticleForm articleForm, BindingResult bindingResult){
        Article article = this.articleService.getArticle(id);

        if(bindingResult.hasErrors()){
            return "article_form";
        }

        this.articleService.modify(article, articleForm.getTitle(), articleForm.getContent());


        return String.format("redirect:/article/detail/%s", article.getId());
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Article article = this.articleService.getArticle(id);
        this.articleService.delete(article);
        return "redirect:/article/list";
    }
//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/modify/{id}")
//    public String articleModify(ArticleForm questionForm, @PathVariable("id") Integer id, Principal principal) {
//        Article article = this.articleService.getArticle(id);
//        if(!article.getId().equals(principal.getName())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
//        }
//        questionForm.setTitle(article.getTitle());
//        questionForm.setContent(article.getContent());
//        return "question_form";
//    }
}
