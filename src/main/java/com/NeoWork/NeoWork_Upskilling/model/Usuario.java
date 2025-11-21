package com.NeoWork.NeoWork_Upskilling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(max = 100, message = "Área de atuação deve ter no máximo 100 caracteres")
    private String areaAtuacao;

    @Size(max = 50, message = "Nível de carreira deve ter no máximo 50 caracteres")
    private String nivelCarreira;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Matricula> matriculas;
}
