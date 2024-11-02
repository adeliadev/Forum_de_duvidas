package com.forum.orbis.controller;

import com.forum.orbis.dto.UsuarioDTO;
import com.forum.orbis.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO registrarUsuario(@RequestBody UsuarioDTO usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/buscar/{nomeDeUsuario}")
    public Optional<UsuarioDTO> buscarPorNome(@PathVariable String nomeDeUsuario) {
        return usuarioService.buscarPorNome(nomeDeUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Optional<UsuarioDTO> buscarPorId = UsuarioService.buscarPorId(id);
        return buscarPorId.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarId(@PathVariable Long id){
    Optional<UsuarioDTO> atualizarId = UsuarioService.atualizarId(id);
        return atualizarId.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<UsuarioDTO> buscarPorEmail(@PathVariable String email){
        Optional<UsuarioDTO> buscarPorEmail = UsuarioService.buscarPorEmail(email);
        return buscarPorEmail.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/buscar/{email}")
    public ResponseEntity<UsuarioDTO> atualizarEmail(@PathVariable String email) {
        Optional<UsuarioDTO> atualizarEmail = UsuarioService.atualizarEmail(email);
        return atualizarEmail.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{senha}")
    public ResponseEntity<UsuarioDTO> buscarPorSenha(@PathVariable String senha){
        Optional<UsuarioDTO> buscarPorSenha = UsuarioService.buscarPorSenha(senha);
        return buscarPorSenha.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/buscar/{senha}")
    public ResponseEntity<UsuarioDTO> atualizarSenha(@PathVariable String senha){
        Optional<UsuarioDTO> atualizarSenha = UsuarioService.atualizarSenha(senha);
        return atualizarSenha.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/posts")
    public ResponseEntity<UsuarioDTO> buscarPosts(@PathVariable String posts) {
        Optional<UsuarioDTO> buscarPosts = UsuarioService.buscarPosts(posts);
        return buscarPosts.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
