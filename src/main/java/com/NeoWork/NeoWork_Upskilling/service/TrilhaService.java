package com.NeoWork.NeoWork_Upskilling.service;

import com.NeoWork.NeoWork_Upskilling.dto.TrilhaDTO;
import com.NeoWork.NeoWork_Upskilling.exception.TrilhaNaoEncontradoException;
import com.NeoWork.NeoWork_Upskilling.model.Trilha;
import com.NeoWork.NeoWork_Upskilling.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {
    private final TrilhaRepository repository;

    public TrilhaService(TrilhaRepository repository) {
        this.repository = repository;
    }

    public List<Trilha> listarTrilhas() {
        return repository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradoException(id));
    }

    public Trilha criar(TrilhaDTO dto) {
        Trilha trilha = new Trilha();

        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setFocoPrincipal(dto.focoPrincipal());

        return repository.save(trilha);
    }

    public Trilha atualizar(Long id, TrilhaDTO dto) {
        Trilha trilha = buscarPorId(id);

        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setFocoPrincipal(dto.focoPrincipal());

        return repository.save(trilha);
    }

    public void deletar(Long id) {
        Trilha trilha = buscarPorId(id);
        repository.delete(trilha);
    }
}
