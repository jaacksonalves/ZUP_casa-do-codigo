package br.com.zup.desafio1.casadocodigo.categorias;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String cadastraCategoria(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.converter();
        em.persist(categoria);
        return categoria.toString();

    }
}
