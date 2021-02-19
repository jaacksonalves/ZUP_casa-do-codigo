package br.com.zup.desafio1.casadocodigo.autores;

import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class AutorForm {

    @NotBlank(message = "Campo obrigatório!")
    @Size(min = 3)
    private final String nome;
    @Email(message = "Email deve ser válido!")
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já cadastrado")
    private final String email;
    @NotBlank(message = "Campo obrigatório!")
    @Size(min = 5, max = 400)
    private final String descricao;

    public AutorForm(@NotBlank @Size(min = 5) String nome, @Email String email, @NotBlank @Size(min = 5, max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}
