package com.forum.orbis.service;

import com.forum.orbis.model.Pesquisa;
import com.forum.orbis.repository.PesquisaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesquisaService {

    private final PesquisaRepository pesquisaRepository;

    public PesquisaService(PesquisaRepository pesquisaRepository) {
        this.pesquisaRepository = pesquisaRepository;
    }

    public List<Pesquisa> buscarPorTitulo(String query) {
        return pesquisaRepository.findByTituloContainingIgnoreCase(query);
    }
}
