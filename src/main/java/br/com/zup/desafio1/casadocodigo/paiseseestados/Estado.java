package br.com.zup.desafio1.casadocodigo.paiseseestados;

import javax.persistence.*;

@Entity
@Table(name = "estados", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "pais_id"}))
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Pais pais;


    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }


}
