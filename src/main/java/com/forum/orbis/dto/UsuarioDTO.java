package com.forum.orbis.dto;

import com.forum.orbis.model.Nivel;
import com.forum.orbis.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nomeDeUsuario;
    private String email;
    private Nivel nivel;
    private List<Post> posts;
}
