package com.forum.orbis.dto;

import com.forum.orbis.model.Pesquisa;
import lombok.Data;

@Data
public class PesquisaResponseDTO {
    private Long id;
    private String titulo;

    public PesquisaResponseDTO(Pesquisa pesquisa) {
        this.id = pesquisa.getId();
        this.titulo = pesquisa.getTitulo();
    } }