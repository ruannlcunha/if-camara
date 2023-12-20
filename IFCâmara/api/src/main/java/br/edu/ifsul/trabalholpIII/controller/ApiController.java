package br.edu.ifsul.trabalholpIII.controller;

import br.edu.ifsul.trabalholpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalholpIII.domain.Deputado;
import br.edu.ifsul.trabalholpIII.service.ApiService;
import br.edu.ifsul.trabalholpIII.service.CriarDeputadoService;
import br.edu.ifsul.trabalholpIII.service.ListarTodosDeputadosService;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;

	@Autowired
	private CriarDeputadoService criarDeputadoService;

	@Autowired
	private ListarTodosDeputadosService listarTodosDeputadosService;
	
	@GetMapping("/clone")
	public List<DeputadoResponse> clone() {
		String data = apiService.getData();
		
        JSONObject jsnobject = new JSONObject(data);
        JSONArray jsonArray = jsnobject.getJSONArray("dados");  
        ArrayList<Object> listdata = new ArrayList<Object>();  

        for(int i = 0; i<10; i++) {
	        Deputado deputado = new Gson().fromJson(jsonArray.get(i).toString(), Deputado.class);
			criarDeputadoService.criarDeputado(deputado);
        }

		return listarTodosDeputadosService.listar();
	}

	
}
