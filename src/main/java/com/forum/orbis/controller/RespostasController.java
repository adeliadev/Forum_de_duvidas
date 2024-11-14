package com.forum.orbis.controller;

import com.forum.orbis.dto.RespostasDTO;
import com.forum.orbis.service.respostas.RespostasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resposta")
public class RespostasController {

    private final RespostasService respostasService;

    public RespostasController(RespostasService respostasService) {
        this.respostasService = respostasService;
    }
    @PostMapping
    public ResponseEntity<?> addResposta(@RequestBody RespostasDTO respostasDTO){
        RespostasDTO createdRespostasDTO = respostasService.postResposta(respostasDTO);
        if(createdRespostasDTO == null)
            return new ResponseEntity<>("Algo deu errado.", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRespostasDTO);
    }

}
