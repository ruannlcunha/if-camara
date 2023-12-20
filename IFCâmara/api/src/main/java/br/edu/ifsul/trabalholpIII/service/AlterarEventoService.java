package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.request.EventoRequest;
import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.repository.EventoRepository;
import br.edu.ifsul.trabalholpIII.service.core.BuscarEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.ifsul.trabalholpIII.mapper.EventoMapper.toResponse;

@Service
public class AlterarEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private BuscarEventoService buscarEventoService;

    @Transactional
    public EventoResponse alterar(Long deputadoId, EventoRequest request) {
        Evento evento = buscarEventoService.buscarPorId(deputadoId, request.getEventoId());

        evento.setDescricaoTipo(request.getDescricao());

        eventoRepository.save(evento);
        return toResponse(evento);
    }

}
