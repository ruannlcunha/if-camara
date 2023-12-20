package br.edu.ifsul.trabalholpIII.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Evento {

	@Id
	private Long id;

	private String descricaoTipo;

	private Boolean ativo;

	@OneToMany(mappedBy = "evento")
	private List<DeputadoEvento> deputadoEventos = new ArrayList<>();


	public void adicionarDeputado(DeputadoEvento deputadoEvento) {
		this.deputadoEventos.add(deputadoEvento);
		deputadoEvento.setEvento(this);
	}
}
