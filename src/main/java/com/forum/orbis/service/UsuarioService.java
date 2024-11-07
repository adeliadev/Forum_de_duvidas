package com.forum.orbis.service;

import com.forum.orbis.model.Nivel;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(String nomeDeUsuario, String email, String senha) {
        if (usuarioRepository.findByNomeDeUsuario(nomeDeUsuario).isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }
        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("E-mail já está em uso");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeDeUsuario(nomeDeUsuario);
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode(senha));
        usuario.setNivel(Nivel.USUARIO);

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByNomeDeUsuario(String nomeDeUsuario) {
        return usuarioRepository.findByNomeDeUsuario(nomeDeUsuario);
    }

    public boolean checarSenha(String senhaCadastrada, String senhaCriptografada) {
        return passwordEncoder.matches(senhaCadastrada, senhaCriptografada);
    }
}
