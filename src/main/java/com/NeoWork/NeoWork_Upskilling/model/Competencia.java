package com.NeoWork.NeoWork_Upskilling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "competencias")
@Data
@Builder
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da competência é obrigatório")
    @Size(min = 3, max = 100)
    private String nome;

    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    private String categoria;

    @Size(max = 500, message = "Descrição pode ter no máximo 500 caracteres")
    private String descricao;

    public Competencia() {}

    public Competencia(String nome, String categoria, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    @ManyToMany(mappedBy = "competencias")
    @JsonIgnore
    private List<Trilha> trilhas;
}
