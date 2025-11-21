package com.NeoWork.NeoWork_Upskilling.repository;

import com.NeoWork.NeoWork_Upskilling.model.Matricula;
import com.NeoWork.NeoWork_Upskilling.model.Trilha;
import com.NeoWork.NeoWork_Upskilling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Optional<Matricula> findByUsuarioAndTrilha(Usuario usuario, Trilha trilha);
}
