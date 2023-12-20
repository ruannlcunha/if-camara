package br.edu.ifsul.trabalholpIII.validator;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class EventoValidator {

    public void eventoExiste(List<EventoResponse> evento) {
        if(evento.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "Este evento não existe");
        }
    }

}
