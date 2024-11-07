package com.forum.orbis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCadastroRequest {
    private String nomeDeUsuario;
    private String email;
    private String senha;
}
