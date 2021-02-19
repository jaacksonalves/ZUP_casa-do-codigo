package br.com.zup.desafio1.casadocodigo.livros;

import br.com.zup.desafio1.casadocodigo.compartilhado.ExistsId;
import br.com.zup.desafio1.casadocodigo.compartilhado.UniqueValue;
import br.com.zup.desafio1.casadocodigo.categorias.Categoria;
import br.com.zup.desafio1.casadocodigo.autores.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já cadastrado")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(value = 20, message = "Preço mínimo de 20,00")
    private BigDecimal preco;
    @Min(value = 100, message = "Mínimo de 100 páginas")
    private Integer paginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "identificador", message = "Identificador já cadastrado")
    private String identificador;
    @NotNull
    @Future(message = "Deve ser uma data futura")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Categoria não existe")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id", message = "Autor não existe")
    private Long idAutor;


    //Cirei o setter, para a anotação @JsonFormat funcionar
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                     @NotNull @Min(value = 20, message = "Preço mínimo de 20,00") BigDecimal preco, @Min(value = 100, message = "Mínimo de 100 páginas") Integer paginas,
                     @NotBlank String identificador, @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.identificador = identificador;
        // tive que tirar a data do construtor, pois o json não estava conseguindo converter de string pra Date this.dataLancamento = dataLancamento;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converter(EntityManager em) {
        @NotNull Categoria categoria = em.find(Categoria.class, idCategoria);
        @NotNull Autor autor = em.find(Autor.class, idAutor);

        return new Livro(titulo, resumo, sumario, preco, paginas, identificador, dataLancamento, categoria, autor);
    }


}
