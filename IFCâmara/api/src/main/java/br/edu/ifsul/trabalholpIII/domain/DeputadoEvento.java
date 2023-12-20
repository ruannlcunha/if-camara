package br.edu.ifsul.trabalholpIII.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class DeputadoEvento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "deputado_id")
    private Deputado deputado;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

}
