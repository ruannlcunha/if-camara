package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.service.core.BuscarDeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.edu.ifsul.trabalholpIII.mapper.DeputadoMapper.toResponse;

@Service
public class VisualizarDeputadoService {

    @Autowired
    private BuscarDeputadoService buscarDeputadoService;

    public DeputadoResponse visualizar(Long deputadoId) {
        Deputado deputado = buscarDeputadoService.buscarPorId(deputadoId);

        return toResponse(deputado);
    }

}
