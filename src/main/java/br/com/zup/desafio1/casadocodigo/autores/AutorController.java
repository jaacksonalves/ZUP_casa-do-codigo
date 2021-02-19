package br.com.zup.desafio1.casadocodigo.autores;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String cadastraAutor(@Valid @RequestBody AutorForm form) {
        Autor autor = form.converter();
        em.persist(autor);
        return autor.toString();
    }

}
