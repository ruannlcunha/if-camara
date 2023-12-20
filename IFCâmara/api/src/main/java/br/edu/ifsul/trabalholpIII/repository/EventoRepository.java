package br.edu.ifsul.trabalholpIII.repository;

import br.edu.ifsul.trabalholpIII.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long>{

    List<Evento> findAllByDeputadoEventos_DeputadoIdAndAtivo(Long deputadoId, boolean ativo);

    Optional<Evento> findByDeputadoEventos_DeputadoIdAndIdAndAtivo(Long deputadoId, Long eventoId, boolean ativo);
}
