package br.com.zup.desafio1.casadocodigo.paiseseestados;

import br.com.zup.desafio1.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValues;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


public class EstadoForm2 {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País inválido")
    private Long idPais;

    public EstadoForm2(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Deprecated
    public String getNome() {
        return nome;
    }

    @Deprecated
    public Long getIdPais() {
        return idPais;
    }


    public Estado converter(EntityManager em) {
        List<EstadoDto> estados = em.createQuery("select e from Estado e", Estado.class)
                .getResultStream()
                .map(EstadoDto::new)
                .collect(Collectors.toList());

        Estado novoEstado = new Estado(nome, em.find(Pais.class, idPais));

        if (estados.contains(novoEstado)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else return novoEstado;
    }
}
