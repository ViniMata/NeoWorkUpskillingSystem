package com.NeoWork.NeoWork_Upskilling.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MatriculaDTO {

    @NotNull(message = "usuarioId é obrigatório")
    private Long usuarioId;

    @NotNull(message = "trilhaId é obrigatório")
    private Long trilhaId;

    // aceitar apenas os valores definidos no enum (string)
    @NotNull(message = "status é obrigatório")
    @Pattern(regexp = "INSCRITO|CONCLUIDO|CANCELADO",
            message = "status deve ser INSCRITO, CONCLUIDO ou CANCELADO")
    private String status;

    public MatriculaDTO() {}

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getTrilhaId() { return trilhaId; }
    public void setTrilhaId(Long trilhaId) { this.trilhaId = trilhaId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
