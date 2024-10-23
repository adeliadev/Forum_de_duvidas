package com.forum.orbis.dto;

import com.forum.orbis.model.Topico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TopicoDTO {

    private Long id;
    private Long idpost;
    private String titulo;

}
