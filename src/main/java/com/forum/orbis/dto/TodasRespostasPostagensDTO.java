package com.forum.orbis.dto;

import lombok.Data;

import java.util.List;

@Data
public class TodasRespostasPostagensDTO {

    private List<PostagensDTO> postagensDTOList;
    private Integer TotalDePaginas;
    private Integer NumeroDaPagina;
}
