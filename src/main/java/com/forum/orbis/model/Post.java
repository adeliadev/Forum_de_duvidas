package com.forum.orbis.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean curtidas;

    private String tipoPublicacao;

    private int quantidadeDeCurtidas;

    private int respostas;
}

