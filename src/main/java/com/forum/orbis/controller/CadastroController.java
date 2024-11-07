package com.forum.orbis.controller;

import com.forum.orbis.dto.UsuarioCadastroRequest;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CadastroController {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioCadastroRequest request) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(request.getNomeDeUsuario(), request.getEmail(), request.getSenha());
            return ResponseEntity.ok("Usuário registrado com sucesso:" + usuario.getNomeDeUsuario());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
