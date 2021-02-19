package br.com.zup.desafio1.casadocodigo.paiseseestados;

public class PaisDto {

    private Long id;
    private String nome;

    public PaisDto(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


}
