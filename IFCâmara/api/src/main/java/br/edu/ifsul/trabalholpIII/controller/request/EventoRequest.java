package br.edu.ifsul.trabalholpIII.controller.request;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter @Setter
public class EventoRequest {

    @NotNull
    private Long eventoId;

    private String descricao;

}
