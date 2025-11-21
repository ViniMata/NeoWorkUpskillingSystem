package com.NeoWork.NeoWork_Upskilling.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CompetenciaDTO {

    @NotBlank(message = "O nome da competência é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;

    @Size(max = 100)
    private String categoria;

    @Size(max = 500)
    private String descricao;

    public CompetenciaDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
