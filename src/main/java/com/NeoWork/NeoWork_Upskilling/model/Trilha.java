package com.NeoWork.NeoWork_Upskilling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trilhas")
@Data
@Builder
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da trilha é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 500, message = "Descrição pode ter no máximo 500 caracteres")
    private String descricao;

    @NotBlank(message = "O nível é obrigatória")
    @Pattern(regexp = "INICIANTE|INTERMEDIARIO|AVANCADO",
             message = "Nível deve ser INICIANTE, INTERMEDIARIO ou AVANCADO")
    private String nivel;

    @Min(value = 1, message = "A carga horária deve ser positiva")
    private int cargaHoraria;

    @Size(max = 100, message = "Foco principal deve ter no máximo 100 caracteres")
    private String focoPrincipal;

    @ManyToMany
    @JoinTable(
            name = "trilha_competencia",
            joinColumns = @JoinColumn(name = "trilha_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private List<Competencia> competencias;

    @OneToMany(mappedBy = "trilha")
    @JsonIgnore
    private List<Matricula> matriculas;
}
