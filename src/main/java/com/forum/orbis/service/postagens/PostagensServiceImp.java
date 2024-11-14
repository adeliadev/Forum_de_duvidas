package com.forum.orbis.service.postagens;

import com.forum.orbis.dto.PostagemUnicaDTO;
import com.forum.orbis.dto.PostagensDTO;
import com.forum.orbis.dto.RespostasDTO;
import com.forum.orbis.dto.TodasRespostasPostagensDTO;
import com.forum.orbis.model.Postagens;
import com.forum.orbis.model.Respostas;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.repository.PostagensRepository;
import com.forum.orbis.repository.RespostasRepository;
import com.forum.orbis.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostagensServiceImp implements PostagensService {

    private final UsuarioRepository usuarioRepository;

    private final PostagensRepository postagensRepository;

    private final RespostasRepository respostasRepository;



    public static final int BUSCAR_RESULTADO_POR_PAGINA = 5;

    public PostagensServiceImp(UsuarioRepository usuarioRepository, PostagensRepository perguntasRepository, RespostasRepository respostasRepository) {
        this.usuarioRepository = usuarioRepository;
        this.postagensRepository = perguntasRepository;
        this.respostasRepository = respostasRepository;

    }



    @Override
    public PostagensDTO addPostagem(PostagensDTO postagensDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(postagensDTO.getId()); //getusuarioid ou getid?
        if (optionalUsuario.isPresent()){
            Postagens pergunta = new Postagens();
            pergunta.setTitulo(postagensDTO.getTitulo());
            pergunta.setTexto(postagensDTO.getTexto());
            pergunta.setTag(postagensDTO.getTag());
            pergunta.setCreatedDate(new Date()); //necessario criar a classe Date.
            Postagens createdPostagem = postagensRepository.save(pergunta);
            PostagensDTO createdPostagensDTO = new PostagensDTO();
            createdPostagensDTO.setId(createdPostagem.getId());
            createdPostagensDTO.setTitulo(createdPostagem.getTitulo() );
            return createdPostagensDTO;
        }
        return null;
    }

    @Override
    public TodasRespostasPostagensDTO getTodasAsPostagens(int numeracaoDaPagina) {
        Pageable paginacao = PageRequest.of(numeracaoDaPagina, BUSCAR_RESULTADO_POR_PAGINA);
        Page<Postagens> paginaDePostagens = postagensRepository.findAll(paginacao);

        TodasRespostasPostagensDTO todasRespostasPostagensDTO = new TodasRespostasPostagensDTO();
        todasRespostasPostagensDTO.setPostagensDTOList(paginaDePostagens.getContent().stream().map(Postagens::getPostagensDTO).collect(Collectors.toList()));
        todasRespostasPostagensDTO.setNumeroDaPagina(paginaDePostagens.getPageable().getPageNumber());
        todasRespostasPostagensDTO.setTotalDePaginas(paginaDePostagens.getTotalPages());
        return todasRespostasPostagensDTO;
    }

    @Override
    public PostagemUnicaDTO getPostagemById(Long postagemId) {
        Optional<Postagens> optionalPostagens = postagensRepository.findById(postagemId);
        if (optionalPostagens.isPresent()) {
            PostagemUnicaDTO postagemUnicaDTO = new PostagemUnicaDTO();
            List<RespostasDTO> respostasDTOList = new ArrayList<>();
            postagemUnicaDTO.setPostagensDTO(optionalPostagens.get().getPostagensDTO());
            List<Respostas> listaDeRespostas = respostasRepository.findAllByRespostasId(postagemId);
            for (Respostas respostas : listaDeRespostas){
                RespostasDTO respostasDTO = respostas.getRespostasDTO();

                respostasDTOList.add(respostasDTO);

            }
            postagemUnicaDTO.setRespostasDTOList(respostasDTOList);
            return postagemUnicaDTO;
        }
        return null;
    }
}
