package com.forum.orbis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forum.orbis.dto.RespostasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long respostasId;

    @Lob
    @Column(name = "texto", length = 512)
    private String texto;

    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_postagem", nullable = false)
    @JsonIgnore
    private Postagens postagens;

    public RespostasDTO getRespostasDTO() {
        RespostasDTO respostasDTO = new RespostasDTO();
        respostasDTO.setId(respostasId);
        respostasDTO.setTexto(texto);
        respostasDTO.setCreatedDate(createdDate);
        respostasDTO.setIdUsuario(usuario.getId());
        respostasDTO.setIdPostagem(postagens.getId());
        respostasDTO.setNomeDoUsuario(usuario.getNomeDeUsuario());
        return respostasDTO;
    }

}
