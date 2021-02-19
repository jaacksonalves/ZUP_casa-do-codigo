package br.com.zup.desafio1.casadocodigo.paiseseestados;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados2")
public class EstadosController2 {

    @PersistenceContext
    private EntityManager em;


    @PostMapping
    @Transactional
    public String cria(@RequestBody @Valid EstadoForm form) {
        Estado novoEstado = form.converter(em);
        em.persist(novoEstado);
        return novoEstado.toString();
    }

}
