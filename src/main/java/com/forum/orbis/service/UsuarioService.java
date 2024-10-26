package com.forum.orbis.service;

import com.forum.orbis.dto.UsuarioDTO;
import com.forum.orbis.model.Nivel;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNomeDeUsuario(usuarioDTO.getNomeDeUsuario());
        novoUsuario.setEmail(usuarioDTO.getEmail());
        novoUsuario.setNivel(Nivel.USUARIO);

        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);

        UsuarioDTO usuarioRetornado = new UsuarioDTO();
        usuarioRetornado.setId(usuarioSalvo.getId());
        usuarioRetornado.setNomeDeUsuario(usuarioSalvo.getNomeDeUsuario());
        usuarioRetornado.setEmail(usuarioSalvo.getEmail());
        usuarioRetornado.setNivel(usuarioSalvo.getNivel());

        return usuarioRetornado;
    }

    public UsuarioDTO convertToDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNomeDeUsuario(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNivel(),
                usuario.getPosts()
        );
    }

    public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNomeDeUsuario(usuarioDTO.getNomeDeUsuario());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setNivel(usuarioDTO.getNivel());
        usuario.setPosts(usuarioDTO.getPosts());
        return usuario;
    }
}
