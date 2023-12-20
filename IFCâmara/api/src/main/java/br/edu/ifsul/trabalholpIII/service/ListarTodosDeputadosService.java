package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalholpIII.mapper.DeputadoMapper;
import br.edu.ifsul.trabalholpIII.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarTodosDeputadosService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    public List<DeputadoResponse> listar() {
        return deputadoRepository.findAll()
                .stream()
                .map(DeputadoMapper::toResponse)
                .collect(Collectors.toList());
    }

}
