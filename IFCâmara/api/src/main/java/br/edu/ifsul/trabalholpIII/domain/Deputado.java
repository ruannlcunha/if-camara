package br.edu.ifsul.trabalholpIII.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@Setter
public class Deputado {

	@Id
	private Long id;

	private String nome;

	private String siglaPartido;

	private String siglaUf;

	private String urlFoto;

	@OneToMany(mappedBy = "deputado")
	private List<DeputadoEvento> deputadoEventos = new ArrayList<>();

	public void adicionarEvento(DeputadoEvento deputadoEvento) {
		this.deputadoEventos.add(deputadoEvento);
		deputadoEvento.setDeputado(this);
	}

}
