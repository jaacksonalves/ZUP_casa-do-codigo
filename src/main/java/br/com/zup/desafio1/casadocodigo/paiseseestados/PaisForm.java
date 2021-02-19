package br.com.zup.desafio1.casadocodigo.paiseseestados;

import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País já cadastrado")
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(nome);
    }
}
