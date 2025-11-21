package com.NeoWork.NeoWork_Upskilling.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "Usuário é obrigatório")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    @NotNull(message = "Trilha é obrigatória")
    private Trilha trilha;

    @Column(nullable = false)
    private LocalDate dataInscricao = LocalDate.now();

    @NotBlank(message = "Status é obrigatório")
    private String status; // INSCRITO, CONCLUIDO, CANCELADO
}
