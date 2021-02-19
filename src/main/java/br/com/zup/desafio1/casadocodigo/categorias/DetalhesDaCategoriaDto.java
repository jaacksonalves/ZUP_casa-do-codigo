package br.com.zup.desafio1.casadocodigo.categorias;

public class DetalhesDaCategoriaDto {

    private String nome;

    public DetalhesDaCategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
