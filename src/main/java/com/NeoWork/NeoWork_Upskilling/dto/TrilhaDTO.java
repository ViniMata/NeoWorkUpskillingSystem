package com.NeoWork.NeoWork_Upskilling.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TrilhaDTO (
    Long id,

    @NotBlank(message = "O nome da trilha é obrgatório")
    String nome,

    @NotBlank(message = "A descrição é obrigatória")
    String descricao,

    @Pattern(
            regexp   = "INICANTE|INTERMEDIARIO|AVANCADO",
            message = "Nível deve ser INCIANTE, INTERMEDIARIO ou AVANCADO"
    )
    String nivel,

    @Min(value = 1, message = "Carga horária deve ser positiva")
    int cargaHoraria,

    String focoPrincipal

) {}
