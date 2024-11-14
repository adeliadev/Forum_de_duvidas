package com.forum.orbis.service.respostas;

import com.forum.orbis.dto.RespostasDTO;
import com.forum.orbis.model.Postagens;
import com.forum.orbis.model.Respostas;
import com.forum.orbis.model.Usuario;
import com.forum.orbis.repository.PostagensRepository;
import com.forum.orbis.repository.RespostasRepository;
import com.forum.orbis.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RespostasServiceImp implements RespostasService{

    private final UsuarioRepository usuarioRepository;

    private PostagensRepository postagensRepository;
    private RespostasRepository respostasRepository;

    public RespostasServiceImp(UsuarioRepository usuarioRepository, PostagensRepository postagensRepository, RespostasRepository respostasRepository) {
        this.usuarioRepository = usuarioRepository;
        this.postagensRepository = postagensRepository;
        this.respostasRepository = respostasRepository;
    }

    @Override
    public RespostasDTO postResposta(RespostasDTO respostasDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(respostasDTO.getIdUsuario());
        Optional<Postagens> optionalPostagens = postagensRepository.findById(respostasDTO.getIdPostagem());
        if (optionalUsuario.isPresent() && optionalPostagens.isPresent()){
            Respostas respostas = new Respostas();
            respostas.setTexto(respostasDTO.getTexto());
            respostas.setCreatedDate(new Date());
            respostas.setUsuario(optionalUsuario.get());
            respostas.setPostagens(optionalPostagens.get());
            Respostas createdRespostas = respostasRepository.save(respostas);
            RespostasDTO createdRespostasDTO = new RespostasDTO();
            createdRespostasDTO.setId(createdRespostas.getRespostasId());
            return createdRespostasDTO;

        }
        return null;
    }
}
