package com.forum.orbis.controller;

import com.forum.orbis.dto.UsuarioLoginRequest;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody UsuarioLoginRequest loginRequest) {
        Optional<Usuario> userOptional = usuarioService.findByNomeDeUsuario(loginRequest.getNomeDeUsuario());
        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            if (usuarioService.checarSenha(loginRequest.getSenha(), usuario.getSenha())) { // Método de verificação
                return ResponseEntity.ok("Usuário autenticado com sucesso!"); // Você pode devolver um token aqui, se necessário
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}
