package br.com.zup.desafio1.casadocodigo.paiseseestados;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<List<Estado>> findByPais(Long idPais);
}
