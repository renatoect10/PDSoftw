package com.example.repository;

import com.example.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>, JpaSpecificationExecutor<Aluno> {

    @Query("select a from Aluno a where a.usuario = :usuario and a.senha = :senha")
    Aluno realizarLogin(@Param("usuario") String usuario,
                        @Param("senha") String senha);
}
