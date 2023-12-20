package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarDeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    @Transactional
    public Deputado criarDeputado(Deputado deputado) {

        return deputadoRepository.save(deputado);

    }
}
