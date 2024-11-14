package com.forum.orbis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forum.orbis.dto.PostagensDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "postagens")
@NoArgsConstructor
public class Postagens {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Long postagemId;

    private Date createdDate;



    @Lob
    @Column(name = "texto", length = 512)
    private String texto;



    @ElementCollection(targetClass = String.class)
    private List<String> tag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Usuario usuario;

    public PostagensDTO getPostagensDTO(){
        PostagensDTO postagensDTO = new PostagensDTO();
        postagensDTO.setId(id);
        postagensDTO.setTitulo(titulo);
        postagensDTO.setTexto(texto);
        postagensDTO.setTag(tag);
        postagensDTO.setCreatedDate(createdDate);
        postagensDTO.setIdUsuario(usuario.getId());
        postagensDTO.setNomeDeusuario(usuario.getNomeDeUsuario());
        return postagensDTO;
    }




}

