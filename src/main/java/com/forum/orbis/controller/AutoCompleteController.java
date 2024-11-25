package com.forum.orbis.controller;

import com.forum.orbis.dto.PesquisaDTO;
import com.forum.orbis.dto.PesquisaResponseDTO;
import com.forum.orbis.model.Pesquisa;
import com.forum.orbis.repository.PesquisaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pesquisas")
public class AutoCompleteController {

    private final PesquisaRepository pesquisaRepository;


    public AutoCompleteController(PesquisaRepository pesquisaRepository) {
        this.pesquisaRepository = pesquisaRepository;
    }

    @PostMapping("/postar")
    public ResponseEntity<String> criarPesquisa(@RequestBody PesquisaDTO pesquisaDTO) {
        try {
            Pesquisa pesquisa = new Pesquisa();
            pesquisa.setTitulo(pesquisaDTO.getTitulo());

            pesquisaRepository.save(pesquisa);

            return ResponseEntity.ok("Postagem criada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar postagem.");
        }
    }

    @GetMapping("/sugestoes")
    public List<PesquisaResponseDTO> buscarSugestoes(@RequestParam String query) {
        return pesquisaRepository.findByTituloContainingIgnoreCase(query)
                .stream()
                .map(PesquisaResponseDTO::new)
                .toList();
    }

    @GetMapping("/historico")
    public List<PesquisaResponseDTO> buscarHistorico() {
        List<Pesquisa> historico = pesquisaRepository.findTop10ByOrderByIdDesc(); // Exemplo: retorna as 10 últimas postagens
        return historico.stream()
                .map(PesquisaResponseDTO::new)
                .toList();
    }
}