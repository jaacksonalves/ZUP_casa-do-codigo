package br.com.zup.desafio1.casadocodigo.livros;

import br.com.zup.desafio1.casadocodigo.autores.DetalhesDoAutorDto;
import br.com.zup.desafio1.casadocodigo.categorias.DetalhesDaCategoriaDto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String dataLancamento;
    private String identificador;
    private DetalhesDoAutorDto autor;
    private DetalhesDaCategoriaDto categoria;

    public DetalhesLivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.dataLancamento = livro.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyy"));
        this.identificador = livro.getIdentificador();
        this.autor = new DetalhesDoAutorDto(livro.getAutor());
        this.categoria = new DetalhesDaCategoriaDto(livro.getCategoria());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public DetalhesDoAutorDto getAutor() {
        return autor;
    }

    public DetalhesDaCategoriaDto getCategoria() {
        return categoria;
    }
}
