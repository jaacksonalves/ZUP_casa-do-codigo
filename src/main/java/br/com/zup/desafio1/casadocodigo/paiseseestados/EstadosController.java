package br.com.zup.desafio1.casadocodigo.paiseseestados;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    @PersistenceContext
    private EntityManager em;


    @PostMapping
    @Transactional
    public String cria(@RequestBody @Valid EstadoForm estadoForm) {

        Estado estado = estadoForm.converter(em);
        em.persist(estado);
        return estado.toString();
    }

}
