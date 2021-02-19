package br.com.zup.desafio1.casadocodigo.paiseseestados;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public String criaPais(@Valid @RequestBody PaisForm form) {
        Pais pais = form.converter();
        em.persist(pais);
        return pais.toString();
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<PaisDto> listaTodos() {

        return em.createQuery("select p from Pais p", Pais.class)
                .getResultStream()
                .map(PaisDto::new)
                .collect(Collectors.toList());

    }


}
