package com.forum.orbis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forum.orbis.dto.RespostasDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long respostasId;

    @Lob
    @Column(name = "texto", length = 512)
    private String texto;

    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Usuario usuario;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPostagem", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Postagens postagens;

    public Long getRespostasId() {
        return respostasId;
    }

    public void setRespostasId(Long id) {
        this.respostasId = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagens getPostagens() {
        return postagens;
    }

    public void setPostagens(Postagens postagens) {
        this.postagens = postagens;
    }

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
