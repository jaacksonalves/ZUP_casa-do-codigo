package br.com.zup.desafio1.casadocodigo.clientes;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @PersistenceContext
    private EntityManager em;


    @PostMapping
    @Transactional
    public String cadastraCliente(@Valid @RequestBody ClienteForm form) {
        Cliente cliente = form.converter(em);
        em.persist(cliente);
        return cliente.getId().toString();
    }
}
