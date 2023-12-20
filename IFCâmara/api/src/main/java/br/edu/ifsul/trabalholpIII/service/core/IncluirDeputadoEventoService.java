package br.edu.ifsul.trabalholpIII.service.core;

import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.domain.DeputadoEvento;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.repository.DeputadoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.edu.ifsul.trabalholpIII.mapper.DeputadoEventoMapper.toEntity;

@Service
public class IncluirDeputadoEventoService {

    @Autowired
    private DeputadoEventoRepository deputadoEventoRepository;

    @Transactional
    public DeputadoEvento incluirDeputadoEvento(Deputado deputado, Evento evento) {
        DeputadoEvento deputadoEvento = toEntity(deputado, evento);

        deputadoEventoRepository.save(deputadoEvento);
        return deputadoEvento;
    }

}
