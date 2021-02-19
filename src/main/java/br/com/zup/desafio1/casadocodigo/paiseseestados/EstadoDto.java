package br.com.zup.desafio1.casadocodigo.paiseseestados;

public class EstadoDto {

    private String nome;
    private Long idPais;

    public EstadoDto(Estado estado) {
        this.nome = estado.getNome();
        this.idPais = estado.getPais().getId();
    }

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
