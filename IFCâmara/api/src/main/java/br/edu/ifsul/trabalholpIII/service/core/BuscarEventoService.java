package br.edu.ifsul.trabalholpIII.service.core;

import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento buscarPorId(Long deputadoId, Long eventoId) {
        return eventoRepository.findByDeputadoEventos_DeputadoIdAndIdAndAtivo(deputadoId, eventoId, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Este evento não existe com este usuário"));

    }

}
