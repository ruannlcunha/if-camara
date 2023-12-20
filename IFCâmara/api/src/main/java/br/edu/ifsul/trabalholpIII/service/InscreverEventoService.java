package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.request.EventoRequest;
import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.domain.DeputadoEvento;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.repository.EventoRepository;
import br.edu.ifsul.trabalholpIII.service.core.BuscarDeputadoService;
import br.edu.ifsul.trabalholpIII.service.core.CriarEventoService;
import br.edu.ifsul.trabalholpIII.service.core.IncluirDeputadoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.ifsul.trabalholpIII.mapper.EventoMapper.toResponse;

@Service
public class InscreverEventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private BuscarDeputadoService buscarDeputadoService;

    @Autowired
    private ListarEventosService listarEventosService;

    @Autowired
    private CriarEventoService criarEventoService;

    @Autowired
    private IncluirDeputadoEventoService incluirDeputadoEventoService;


    @Transactional
    public EventoResponse inscrever(Long deputadoId, EventoRequest request) {
        Deputado deputado = buscarDeputadoService.buscarPorId(deputadoId);

        Evento evento = eventoRepository.findById(request.getEventoId())
                .orElse(criarEventoService.criar(request.getEventoId()));

        evento.setAtivo(true);
        eventoRepository.save(evento);

        DeputadoEvento deputadoEvento = incluirDeputadoEventoService.incluirDeputadoEvento(deputado, evento);

        deputado.adicionarEvento(deputadoEvento);
        evento.adicionarDeputado(deputadoEvento);

        return toResponse(evento);
    }

}
