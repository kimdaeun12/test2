package com.ll.exam.test2.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Size;


@Getter
@Setter
public class UserCreateForm {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "ID 쓰삼")
    private String username;

    @NotEmpty(message = "비밀번호쓰삼")
    private String password1;

    @NotEmpty(message = "비밀번호 확인하삼")
    private String password2;

    @NotEmpty(message = "이메일 쓰삼")
    @Email
    private String email;
}
