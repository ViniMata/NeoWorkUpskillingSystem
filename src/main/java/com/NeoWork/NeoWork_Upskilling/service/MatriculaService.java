package com.NeoWork.NeoWork_Upskilling.service;

import com.NeoWork.NeoWork_Upskilling.dto.MatriculaDTO;
import com.NeoWork.NeoWork_Upskilling.exception.MatriculaNaoEncontradaException;
import com.NeoWork.NeoWork_Upskilling.exception.TrilhaNaoEncontradoException;
import com.NeoWork.NeoWork_Upskilling.exception.UsuarioNaoEncontradoException;
import com.NeoWork.NeoWork_Upskilling.model.Matricula;
import com.NeoWork.NeoWork_Upskilling.model.Trilha;
import com.NeoWork.NeoWork_Upskilling.model.Usuario;
import com.NeoWork.NeoWork_Upskilling.repository.MatriculaRepository;
import com.NeoWork.NeoWork_Upskilling.repository.TrilhaRepository;
import com.NeoWork.NeoWork_Upskilling.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;

    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNaoEncontradaException(id));
    }

    @Transactional
    public Matricula criar(MatriculaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(dto.getUsuarioId()));

        Trilha trilha = trilhaRepository.findById(dto.getTrilhaId())
                .orElseThrow(() -> new TrilhaNaoEncontradoException(dto.getTrilhaId()));

        matriculaRepository.findByUsuarioAndTrilha(usuario, trilha).ifPresent(m -> {
            throw new IllegalArgumentException("Usuário já está matriculado nessa trilha.");
        });

        Matricula matricula = Matricula.builder()
                .usuario(usuario)
                .trilha(trilha)
                .status(Matricula.Status.valueOf(dto.getStatus()))
                .build();

        return matriculaRepository.save(matricula);
    }

    @Transactional
    public Matricula atualizar(Long id, MatriculaDTO dto) {
        Matricula existente = matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNaoEncontradaException(id));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(dto.getUsuarioId()));

        Trilha trilha = trilhaRepository.findById(dto.getTrilhaId())
                .orElseThrow(() -> new TrilhaNaoEncontradoException(dto.getTrilhaId()));

        if (!existente.getUsuario().getId().equals(usuario.getId())
                || !existente.getTrilha().getId().equals(trilha.getId())) {
            matriculaRepository.findByUsuarioAndTrilha(usuario, trilha).ifPresent(m -> {
                throw new IllegalArgumentException("Usuário já está matriculado nessa trilha.");
            });
        }

        existente.setUsuario(usuario);
        existente.setTrilha(trilha);
        existente.setStatus(Matricula.Status.valueOf(dto.getStatus()));

        return matriculaRepository.save(existente);
    }

    public void deletar(Long id) {
        Matricula m = matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNaoEncontradaException(id));
        matriculaRepository.delete(m);
    }
}
