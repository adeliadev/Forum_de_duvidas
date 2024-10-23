package com.forum.orbis.dto;

import com.forum.orbis.model.Topico;
import com.forum.orbis.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long id;
    private Boolean curtidas;
    private String tipoPublicacao;
    private int quantidadeDeCurtidas;
    private int respostas;
    private Usuario usuario;
    private Topico topico;

}
