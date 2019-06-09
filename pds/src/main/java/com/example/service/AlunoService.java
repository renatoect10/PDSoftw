package com.example.service;

import com.example.model.Aluno;
import com.example.repository.AlunoRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlunoService {

    private Session session;

    @Autowired
    AlunoRepository alunoRepository;

    public void cadastrarAluno(String nomeAluno, Integer idade, String usuario, String senha){
            Aluno a = new Aluno();
            a.setNome(nomeAluno);
            a.setUsuario(usuario);
            a.setSenha(senha);
            a.setIdade(idade);
            alunoRepository.save(a);
    }

    public void realizarLogin(String usuario, String senha){
            Aluno a = new Aluno();

            a = alunoRepository.realizarLogin(usuario, senha);

            if(a == null){
                System.out.println("O usuario nao existe.");
            }
            else{
                System.out.println("Seja bem vindo, " + a.getNome());
            }

    }
}
