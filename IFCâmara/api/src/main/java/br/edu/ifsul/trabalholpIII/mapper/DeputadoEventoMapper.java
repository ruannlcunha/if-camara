package br.edu.ifsul.trabalholpIII.mapper;

import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.domain.DeputadoEvento;
import br.edu.ifsul.trabalholpIII.domain.Evento;

public class DeputadoEventoMapper {

    public static DeputadoEvento toEntity(Deputado deputado, Evento evento) {
        return DeputadoEvento.builder()
                .deputado(deputado)
                .evento(evento)
                .ativo(true)
                .build();
    }

}
