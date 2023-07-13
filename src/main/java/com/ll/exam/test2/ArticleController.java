package com.ll.exam.test2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("list", articleList);
        return "list";
    }
    @GetMapping("/create")
    private String create(Model model){
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("article", articleList);

        return "form";
    }
    @PostMapping("/create")
    private String create(@RequestParam String title, @RequestParam String content){
        this.articleService.create(title, content);
        return "redirect:/article/list";
    }

    @GetMapping("/detail/{id}")
    private String detail(Model model, @PathVariable("id") Integer id){
        Article article = this.articleService.getList().get(id);
        model.addAttribute("detail",article);
        return "detail";
    }
}
