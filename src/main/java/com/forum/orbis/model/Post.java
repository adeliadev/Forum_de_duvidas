package com.forum.orbis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@OneToMany(mappedBy = "topicos")
private List<Topico> topicos;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    private Boolean Like;

    private String tipoPublicacao;

    private int Curtidas;

    private int Respostas;
}
