package br.edu.ifsul.trabalholpIII.service.core;

import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class BuscarDeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;


    public Deputado buscarPorId(Long deputadoId) {
        return deputadoRepository.findById(deputadoId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Este deputado não existe"));

    }

}
