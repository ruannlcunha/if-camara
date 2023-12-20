package br.edu.ifsul.trabalholpIII.controller;

import br.edu.ifsul.trabalholpIII.controller.request.EventoRequest;
import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private InscreverEventoService inscreverEventoService;

	@Autowired
	private ListarEventosService listarEventosService;

	@Autowired
	private ListarEventosPorDeputadoService listarEventosPorDeputadoService;

	@Autowired
	private AlterarEventoService alterarEventoService;

	@Autowired
	private RemoverEventoService removerEventoService;

	@ResponseStatus(OK)
	@GetMapping
	public List<EventoResponse> listar() {
		return listarEventosService.listar();
	}


	@GetMapping("/{deputadoId}")
	public List<EventoResponse> listarPorDeputado(@PathVariable Long deputadoId) {
		return listarEventosPorDeputadoService.listarPorDeputado(deputadoId);
	}

	@ResponseStatus(CREATED)
	@PostMapping("/{deputadoId}")
	public EventoResponse inscreverEventoEmDeputado(@PathVariable Long deputadoId, @RequestBody EventoRequest request) {
		return inscreverEventoService.inscrever(deputadoId, request);
	}

	@PutMapping("/{deputadoId}")
	public EventoResponse alterarEvento(@PathVariable Long deputadoId, @RequestBody EventoRequest request) {
		return alterarEventoService.alterar(deputadoId, request);
	}

	@DeleteMapping("/{deputadoId}/remover/{eventoId}")
	public EventoResponse removerEvento(@PathVariable Long deputadoId, @PathVariable Long eventoId) {
		return removerEventoService.remover(deputadoId, eventoId);
	}
	
}
