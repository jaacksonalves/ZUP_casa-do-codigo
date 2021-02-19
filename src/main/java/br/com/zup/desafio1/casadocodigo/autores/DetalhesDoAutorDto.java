package br.com.zup.desafio1.casadocodigo.autores;

public class DetalhesDoAutorDto {

    private String nome;
    private String descricao;

    public DetalhesDoAutorDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
