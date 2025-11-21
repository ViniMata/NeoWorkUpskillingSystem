package com.NeoWork.NeoWork_Upskilling.repository;

import com.NeoWork.NeoWork_Upskilling.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
