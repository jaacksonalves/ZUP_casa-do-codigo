package br.com.zup.desafio1.casadocodigo.paiseseestados;

import javax.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
