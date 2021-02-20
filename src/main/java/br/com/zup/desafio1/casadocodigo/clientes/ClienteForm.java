package br.com.zup.desafio1.casadocodigo.clientes;

import br.com.zup.desafio1.casadocodigo.compartilhado.CPFOuCNPJ;
import br.com.zup.desafio1.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.desafio1.casadocodigo.paiseseestados.Estado;
import br.com.zup.desafio1.casadocodigo.paiseseestados.Pais;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteForm {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Documento já cadastrado")
    @CPFOuCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "País não existe")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id", message = "Estado não existe")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
                       @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long idPais, Long idEstado,
                       @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public Cliente converter(EntityManager em) {
        List<Estado> estados = em.find(Pais.class, idPais).getEstados();

        if (!estados.isEmpty() && idEstado != null) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, em.find(Pais.class, idPais), em.find(Estado.class, idEstado), telefone, cep);
        }
        if (estados.isEmpty() && idEstado == null) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, em.find(Pais.class, idPais), telefone, cep);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reveja campos de País e Estado");
        }

    }

    @Deprecated
    public Long getIdPais() {
        return idPais;
    }

    @Deprecated
    public Long getIdEstado() {
        return idEstado;
    }


}
