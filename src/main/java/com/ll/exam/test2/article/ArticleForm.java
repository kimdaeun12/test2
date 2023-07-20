package com.ll.exam.test2.article;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {

    @NotEmpty(message = "제목 필수임")
    private String title;

    @NotEmpty(message = "내용 필수임")
    private String content;
}
