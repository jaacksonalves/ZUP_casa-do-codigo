package br.com.zup.desafio1.casadocodigo.livros;

import br.com.zup.desafio1.casadocodigo.categorias.Categoria;
import br.com.zup.desafio1.casadocodigo.autores.Autor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(length = 500)
    private String resumo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    @Column(unique = true)
    private String identificador;
    private LocalDate dataLancamento;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;


    @Deprecated
    public Livro() {

    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String identificador, LocalDate dataLancamento,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.identificador = identificador;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
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

    public String getIdentificador() {
        return identificador;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", paginas=" + paginas +
                ", identificador='" + identificador + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }


}
