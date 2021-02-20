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
        Pais pais = em.find(Pais.class, idPais);
        Estado estado = null;
        if (idEstado != null) {
            estado = em.find(Estado.class, idEstado);
        }

        List<Estado> estados = pais.getEstados();

        if (estados.isEmpty() && idEstado == null) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                    estado, telefone, cep);
        }
        if (estados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este País não possui Estados cadastrados");
        }
        if (idEstado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você precisa preencher um Estado para este País");
        }
        assert estado != null;
        if (!pais.getId().equals(estado.getPais().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Estado não pertence a este País");
        }
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                estado, telefone, cep);
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
