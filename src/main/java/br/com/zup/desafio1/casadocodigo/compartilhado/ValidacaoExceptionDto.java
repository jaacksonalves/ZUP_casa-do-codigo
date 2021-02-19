package br.com.zup.desafio1.casadocodigo.compartilhado;

import java.time.LocalDateTime;

public class ValidacaoExceptionDto {

    private String titulo;
    private String detalhe;
    private String status;
    private LocalDateTime hora;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getHora() {
        return hora;
    }
}
