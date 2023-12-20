package br.edu.ifsul.trabalholpIII.mapper;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Evento;

import java.util.ArrayList;

public class EventoMapper {

    public static Evento toEntity(EventoResponse response) {
        return Evento
                .builder()
                .id(response.getId())
                .descricaoTipo(response.getDescricaoTipo())
                .deputadoEventos(new ArrayList<>())
                .ativo(true)
                .build();
    }

    public static EventoResponse toResponse(Evento evento) {
        return EventoResponse.builder()
                .id(evento.getId())
                .descricaoTipo(evento.getDescricaoTipo())
                .build();
    }

}
