package com.forum.orbis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLoginRequest {
    private String nomeDeUsuario;
    private String senha;
}
