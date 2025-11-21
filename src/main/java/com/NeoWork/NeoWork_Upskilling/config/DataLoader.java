package com.NeoWork.NeoWork_Upskilling.config;

import com.NeoWork.NeoWork_Upskilling.model.*;
import com.NeoWork.NeoWork_Upskilling.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            UsuarioRepository usuarioRepository,
            TrilhaRepository trilhaRepository,
            CompetenciaRepository competenciaRepository,
            MatriculaRepository matriculaRepository
    ) {
        return args -> {

            // Evitar duplicação ao reiniciar
            if (usuarioRepository.count() > 0) return;

            // ------------------------------
            // 1️⃣ Criar Usuários
            // ------------------------------
            Usuario u1 = usuarioRepository.save(
                    Usuario.builder()
                            .nome("Ana Silva")
                            .email("ana@neowork.com")
                            .areaAtuacao("Tecnologia")
                            .nivelCarreira("Júnior")
                            .build()
            );

            Usuario u2 = usuarioRepository.save(
                    Usuario.builder()
                            .nome("Bruno Costa")
                            .email("bruno@neowork.com")
                            .areaAtuacao("Design")
                            .nivelCarreira("Pleno")
                            .build()
            );

            Usuario u3 = usuarioRepository.save(
                    Usuario.builder()
                            .nome("Carla Souza")
                            .email("carla@neowork.com")
                            .areaAtuacao("Dados")
                            .nivelCarreira("Sênior")
                            .build()
            );

            // ------------------------------
            // 2️⃣ Criar Competências
            // ------------------------------
            Competencia c1 = competenciaRepository.save(
                    Competencia.builder()
                            .nome("Lógica de Programação")
                            .categoria("Fundamentos")
                            .descricao("Base essencial para qualquer carreira em TI.")
                            .build()
            );

            Competencia c2 = competenciaRepository.save(
                    Competencia.builder()
                            .nome("Java")
                            .categoria("Back-end")
                            .descricao("Fundamentos e aplicações do Java moderno.")
                            .build()
            );

            Competencia c3 = competenciaRepository.save(
                    Competencia.builder()
                            .nome("Spring Boot")
                            .categoria("Back-end")
                            .descricao("Criação de APIs e aplicações Rest.")
                            .build()
            );

            Competencia c4 = competenciaRepository.save(
                    Competencia.builder()
                            .nome("Banco de Dados SQL")
                            .categoria("Dados")
                            .descricao("Modelagem e consultas SQL.")
                            .build()
            );

            Competencia c5 = competenciaRepository.save(
                    Competencia.builder()
                            .nome("Git e Versionamento")
                            .categoria("Ferramentas")
                            .descricao("Domínio básico de Git e GitHub.")
                            .build()
            );

            // ------------------------------
            // 3️⃣ Criar Trilhas
            // ------------------------------
            Trilha t1 = trilhaRepository.save(
                    Trilha.builder()
                            .nome("Back-end com Java")
                            .descricao("Aprenda Java e desenvolvimento de APIs.")
                            .nivel("Intermediário")
                            .cargaHoraria(120)
                            .focoPrincipal("Desenvolvimento Back-end")
                            .build()
            );

            Trilha t2 = trilhaRepository.save(
                    Trilha.builder()
                            .nome("Fundamentos de Programação")
                            .descricao("Base sólida para iniciantes em tecnologia.")
                            .nivel("Iniciante")
                            .cargaHoraria(80)
                            .focoPrincipal("Lógica e Fundamentos")
                            .build()
            );

            Trilha t3 = trilhaRepository.save(
                    Trilha.builder()
                            .nome("Dados e SQL")
                            .descricao("Aprenda a manipular e consultar bancos de dados.")
                            .nivel("Intermediário")
                            .cargaHoraria(100)
                            .focoPrincipal("Análise de Dados")
                            .build()
            );

            // ------------------------------
            // 4️⃣ Relacionar Trilhas ↔ Competências
            // ------------------------------
            t1.setCompetencias(List.of(c1, c2, c3, c5));
            t2.setCompetencias(List.of(c1, c5));
            t3.setCompetencias(List.of(c4, c5));

            trilhaRepository.save(t1);
            trilhaRepository.save(t2);
            trilhaRepository.save(t3);

            // ------------------------------
            // 5️⃣ Criar Matrículas
            // ------------------------------
            matriculaRepository.save(
                    Matricula.builder()
                            .usuario(u1)
                            .trilha(t1)
                            .status("INSCRITO")
                            .build()
            );

            matriculaRepository.save(
                    Matricula.builder()
                            .usuario(u2)
                            .trilha(t2)
                            .status("INSCRITO")
                            .build()
            );

            matriculaRepository.save(
                    Matricula.builder()
                            .usuario(u3)
                            .trilha(t3)
                            .status("CONCLUIDO")
                            .build()
            );

        };
    }
}
