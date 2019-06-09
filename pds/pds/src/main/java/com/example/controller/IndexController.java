package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @RequestMapping(value = "/realizar_login")
    public String realizarLogin() {
        return "/aluno/realizar_login";
    }

    @RequestMapping(value = "/cadastrar_aluno")
    public String cadastrarAluno(){
        return "/aluno/cadastrar";
    }
}
