package com.forum.orbis.repository;

import com.forum.orbis.model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {

    @Query("SELECT p FROM Pesquisa p WHERE LOWER(p.titulo) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Pesquisa> findByTituloContainingIgnoreCase(String query);

    List<Pesquisa> findTop10ByOrderByIdDesc();
}
