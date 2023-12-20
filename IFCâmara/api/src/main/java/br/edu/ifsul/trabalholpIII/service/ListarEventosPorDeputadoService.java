package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.mapper.EventoMapper;
import br.edu.ifsul.trabalholpIII.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarEventosPorDeputadoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoResponse> listarPorDeputado(Long deputadoId) {
        return eventoRepository.findAllByDeputadoEventos_DeputadoIdAndAtivo(deputadoId, true)
                .stream()
                .map(EventoMapper::toResponse)
                .collect(Collectors.toList());
    }

}
