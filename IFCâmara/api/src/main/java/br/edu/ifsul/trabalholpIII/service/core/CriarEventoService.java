package br.edu.ifsul.trabalholpIII.service.core;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.service.ListarEventosService;
import br.edu.ifsul.trabalholpIII.validator.EventoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.edu.ifsul.trabalholpIII.mapper.EventoMapper.toEntity;

@Service
public class CriarEventoService {

    private final int PRIMEIRO_ITEM = 0;

    @Autowired
    private ListarEventosService listarEventosService;

    @Autowired
    private EventoValidator eventoValidator;

    @Transactional
    public Evento criar(Long eventoId) {
        List<EventoResponse> eventos = listarEventosService.listar();
        List<EventoResponse> eventoEncontrado = eventos
                .stream()
                .filter(eventoResponse -> eventoResponse.getId().equals(eventoId))
                .collect(Collectors.toList());

        eventoValidator.eventoExiste(eventoEncontrado);

        EventoResponse response = eventoEncontrado.get(PRIMEIRO_ITEM);

        return toEntity(response);
    }

}
