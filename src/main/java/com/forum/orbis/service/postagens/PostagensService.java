package com.forum.orbis.service.postagens;

import com.forum.orbis.dto.PostagemUnicaDTO;
import com.forum.orbis.dto.PostagensDTO;
import com.forum.orbis.dto.TodasRespostasPostagensDTO;

public interface PostagensService {


    PostagensDTO addPostagem(PostagensDTO postagensDTO);

    TodasRespostasPostagensDTO getTodasAsPostagens(int numeracaoDaPagina);

    PostagemUnicaDTO getPostagemById(Long postagemId);
}
