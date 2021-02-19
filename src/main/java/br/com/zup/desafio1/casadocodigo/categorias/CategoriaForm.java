package br.com.zup.desafio1.casadocodigo.categorias;

import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
