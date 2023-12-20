package br.edu.ifsul.trabalholpIII.service;

import br.edu.ifsul.trabalholpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalholpIII.domain.Evento;
import br.edu.ifsul.trabalholpIII.mapper.EventoMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Service
public class ListarEventosService {

    @Autowired
    private ApiService apiService;

    @ResponseStatus(OK)
    @GetMapping
    public List<EventoResponse> listar() {
        String data = apiService.getDataEventos();
        Set<Evento> eventos = new HashSet<>();

        JSONObject jsnobject = new JSONObject(data);
        JSONArray jsonArray = jsnobject.getJSONArray("dados");

        jsonArray.forEach(jsonObject -> {
            Evento evento = new Gson().fromJson(jsonObject.toString(), Evento.class);
            if(eventos.stream().noneMatch(eve -> eve.getDescricaoTipo().equals(evento.getDescricaoTipo()))) {
                eventos.add(evento);
            }
        });

        return eventos
                .stream()
                .map(EventoMapper::toResponse)
                .collect(Collectors.toList());
    }


}
