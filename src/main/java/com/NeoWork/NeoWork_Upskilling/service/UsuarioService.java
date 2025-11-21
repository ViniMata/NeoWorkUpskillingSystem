package com.NeoWork.NeoWork_Upskilling.service;

import com.NeoWork.NeoWork_Upskilling.dto.UsuarioDTO;
import com.NeoWork.NeoWork_Upskilling.exception.UsuarioNaoEncontradoException;
import com.NeoWork.NeoWork_Upskilling.model.Usuario;
import com.NeoWork.NeoWork_Upskilling.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Usuario criar(UsuarioDTO dto) {

        repository.findByEmail(dto.getEmail())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Email já cadastrado");
                });

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setAreaAtuacao(dto.getAreaAtuacao());
        usuario.setNivelCarreira(dto.getNivelCarreira());

        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, UsuarioDTO dto) {
        Usuario existente = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        if (!existente.getEmail().equals(dto.getEmail())) {
            repository.findByEmail(dto.getEmail())
                    .ifPresent(u -> {
                        throw new IllegalArgumentException("Email já cadastrado");
                    });
        }

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setAreaAtuacao(dto.getAreaAtuacao());
        existente.setNivelCarreira(dto.getNivelCarreira());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        Usuario u = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        repository.delete(u);
    }
}
