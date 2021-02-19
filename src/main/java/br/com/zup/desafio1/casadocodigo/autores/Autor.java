package br.com.zup.desafio1.casadocodigo.autores;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(length = 400)
    private String descricao;
    private final LocalDateTime dataRegistro = LocalDateTime.now(ZoneId.of("UTC"));

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
