package br.edu.ifsul.trabalholpIII.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class EventoResponse {

    private Long id;

    private String descricaoTipo;
}
