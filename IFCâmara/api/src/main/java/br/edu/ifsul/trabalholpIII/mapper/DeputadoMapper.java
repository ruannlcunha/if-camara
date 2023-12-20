package br.edu.ifsul.trabalholpIII.mapper;

import br.edu.ifsul.trabalholpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalholpIII.domain.Deputado;

public class DeputadoMapper {

    public static DeputadoResponse toResponse(Deputado deputado) {
        return DeputadoResponse.builder()
                .id(deputado.getId())
                .nome(deputado.getNome())
                .siglaPartido(deputado.getSiglaPartido())
                .siglaUf(deputado.getSiglaUf())
                .urlFoto(deputado.getUrlFoto())
                .build();
    }

}
