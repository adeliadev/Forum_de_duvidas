package com.forum.orbis.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostagensDTO {

    private Long id;
    private String titulo;
    private String texto;
    private List<String> tag;
    private Date createdDate;
    private Long idUsuario;
    private String nomeDeusuario;


}
