package br.com.zup.desafio1.casadocodigo.paiseseestados;

import br.com.zup.desafio1.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValues;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueValues(domainClass = Estado.class, fields = {"nome", "idPais"}, aliases = {"nome", "pais.id"}, message = "Estado já cadastrado")
public class EstadoForm {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País inválido")
    private Long idPais;

    public EstadoForm(@NotBlank String nome, @NotNull Long idPais) {
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
        return new Estado(nome, em.find(Pais.class, idPais));
    }
}
