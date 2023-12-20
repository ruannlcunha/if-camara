package br.edu.ifsul.trabalholpIII.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class DeputadoResponse {

    private Long id;

    private String nome;

    private String siglaPartido;

    private String siglaUf;

    private String urlFoto;
}
