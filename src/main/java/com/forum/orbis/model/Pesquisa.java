package com.forum.orbis.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
}
