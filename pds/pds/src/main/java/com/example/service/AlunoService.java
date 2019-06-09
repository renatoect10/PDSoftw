package com.example.service;

import com.example.model.Aluno;
import com.example.repository.AlunoRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Service
public class AlunoService {

    private Session session;

    @Autowired
    AlunoRepository alunoRepository;

    public void cadastrarAluno(String nomeAluno, Integer idade, String usuario, String senha, HttpServletResponse response) throws IOException{
            PrintWriter out = response.getWriter();

            Aluno a = new Aluno();
            a.setNome(nomeAluno);
            a.setUsuario(usuario);
            a.setSenha(senha);
            a.setIdade(idade);
            alunoRepository.save(a);
            out.println("Usuario cadastrado com sucesso.");
    }

    public void realizarLogin(String usuario, String senha, HttpServletResponse response) throws IOException {
            Aluno a = new Aluno();

            PrintWriter out = response.getWriter();

            a = alunoRepository.realizarLogin(usuario, senha);

            if(a == null){
                out.println("O usuario nao existe");
            }
            else{
                out.println("Seja bem vindo, " + a.getNome());
            }

    }
}
