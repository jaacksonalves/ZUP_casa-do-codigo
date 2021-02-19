package br.com.zup.desafio1.casadocodigo.livros;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String cadastraLivro(@Valid @RequestBody LivroForm form) {
        Livro livro = form.converter(em);
        em.persist(livro);
        return livro.toString();
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<LivroDto> listarLivros() {
        return em.createQuery("select l from Livro l", Livro.class)
                .getResultStream()
                .map(LivroDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public DetalhesLivroDto detalharLivroPorId(@PathVariable("id") Long id) {

        Livro livroBuscado = em.find(Livro.class, id);
        if (livroBuscado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        }
        return new DetalhesLivroDto(livroBuscado);
    }

}
