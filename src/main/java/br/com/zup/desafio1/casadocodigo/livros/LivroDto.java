package br.com.zup.desafio1.casadocodigo.livros;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}


