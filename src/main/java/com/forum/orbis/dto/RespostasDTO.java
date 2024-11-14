package com.forum.orbis.dto;

import lombok.Data;

import java.awt.*;
import java.util.Date;

@Data
public class RespostasDTO {

    private Long id;
    private String texto;
    private Date createdDate;
    private Long idPostagem;
    private Long idUsuario;
    private String nomeDoUsuario;
    private Image arquivo;
}
