package com.forum.orbis.dto;

import lombok.Data;

import java.util.List;

@Data

public class PostagemUnicaDTO {

    private PostagensDTO postagensDTO;
    private List<RespostasDTO> respostasDTOList;
}
