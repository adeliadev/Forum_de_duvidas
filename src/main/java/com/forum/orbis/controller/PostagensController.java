package com.forum.orbis.controller;

import com.forum.orbis.dto.PostagemUnicaDTO;
import com.forum.orbis.dto.PostagensDTO;
import com.forum.orbis.dto.TodasRespostasPostagensDTO;
import com.forum.orbis.service.postagens.PostagensService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perguntas")
public class PostagensController {

    private final PostagensService postagensService;

    public PostagensController(PostagensService postagensService) {
        this.postagensService = postagensService;
    }
    @PostMapping("/postagens")
    public ResponseEntity<?> postPergunta(@RequestBody PostagensDTO perguntasDTO){
        PostagensDTO createdPostagensDTO = postagensService.addPostagem(perguntasDTO);
        if (createdPostagensDTO == null){
            return new ResponseEntity<>("Algo deu errado", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPostagensDTO);
    }
    @GetMapping("/postagens/{numeracaoDaPagina}")

    public ResponseEntity<TodasRespostasPostagensDTO> getTodasPostagens(@PathVariable int numeracaoDaPagina){
        TodasRespostasPostagensDTO todasRespostasPostagensDTO = postagensService.getTodasAsPostagens(numeracaoDaPagina);
        return ResponseEntity.ok(todasRespostasPostagensDTO);
    }
    @GetMapping("/postagem/{postagemId}")
    public ResponseEntity<?> getRespostaById(@PathVariable Long postagemId){
        PostagemUnicaDTO postagemUnicaDTO = postagensService.getPostagemById(postagemId);
        if(postagemUnicaDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postagemUnicaDTO);


    }
}
