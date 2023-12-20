package br.edu.ifsul.trabalholpIII.controller;

import br.edu.ifsul.trabalholpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalholpIII.service.ListarTodosDeputadosService;
import br.edu.ifsul.trabalholpIII.service.VisualizarDeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {

	@Autowired
	private ListarTodosDeputadosService listarTodosDeputadosService;

	@Autowired
	private VisualizarDeputadoService visualizarDeputadoService;

	@ResponseStatus(OK)
	@GetMapping
	public List<DeputadoResponse> listarTodosDeputados() {

		return listarTodosDeputadosService.listar();
	}

	@ResponseStatus(OK)
	@GetMapping("/{deputadoId}")
	public DeputadoResponse visualizar(@PathVariable Long deputadoId) {
		return visualizarDeputadoService.visualizar(deputadoId);
	}
	
}
