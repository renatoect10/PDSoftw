package com.example.controller;

import com.example.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping("/realizar_login")
    public void realizarLogin(@RequestParam(value="usuario", required = true) String usuario,
                              @RequestParam(value="senha", required = true) String senha) {

        alunoService.realizarLogin(usuario, senha);
    }

    @RequestMapping("/cadastrar")
    public String cadastrarAluno(@RequestParam(value="nome_aluno", required = true) String nomeAluno,
                               @RequestParam(value="idade", required = true) int idade,
                               @RequestParam(value="usuario", required = true) String usuario,
                               @RequestParam(value="senha", required = true) String senha) {

        alunoService.cadastrarAluno(nomeAluno, idade, usuario, senha);

        return "redirect:realizar_login";
    }
}


