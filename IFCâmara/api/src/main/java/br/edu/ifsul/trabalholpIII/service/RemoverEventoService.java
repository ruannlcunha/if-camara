package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.repository.EventoRepository;
import br.edu.ifsul.trabalholpIII.service.core.BuscarEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.ifsul.trabalholpIII.mapper.EventoMapper.toResponse;

@Service
public class RemoverEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private BuscarEventoService buscarEventoService;

    @Transactional
    public EventoResponse remover(Long deputadoId, Long eventoId) {
        Evento evento = buscarEventoService.buscarPorId(deputadoId, eventoId);

        evento.setAtivo(false);

        eventoRepository.save(evento);
        return toResponse(evento);
    }

}
