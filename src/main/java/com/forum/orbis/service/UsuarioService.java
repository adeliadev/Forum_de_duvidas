package com.forum.orbis.service;

import com.forum.orbis.dto.UsuarioDTO;
import com.forum.orbis.model.Nivel;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNomeDeUsuario(usuarioDTO.getNomeDeUsuario());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setSenha(usuarioDTO.getSenha());
            usuario.setNivel(usuarioDTO.getNivel());

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return convertToDTO(usuarioAtualizado);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
