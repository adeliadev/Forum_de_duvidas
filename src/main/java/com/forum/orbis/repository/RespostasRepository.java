package com.forum.orbis.repository;

import com.forum.orbis.model.Respostas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostasRepository extends JpaRepository<Respostas, Long> {
    List<Respostas> findAllByRespostasId(Long postagemId);
}
