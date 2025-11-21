package com.NeoWork.NeoWork_Upskilling.service;

import com.NeoWork.NeoWork_Upskilling.dto.CompetenciaDTO;
import com.NeoWork.NeoWork_Upskilling.exception.CompetenciaNaoEncontradaException;
import com.NeoWork.NeoWork_Upskilling.model.Competencia;
import com.NeoWork.NeoWork_Upskilling.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository repository;

    public CompetenciaService(CompetenciaRepository repository) {
        this.repository = repository;
    };

    public List<Competencia> listarCompetecias() {
        return repository.findAll();
    }

    public Competencia buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CompetenciaNaoEncontradaException(id));
    }

    public Competencia criar(CompetenciaDTO dto) {
        Competencia c = new Competencia(
                dto.getNome(),
                dto.getCategoria(),
                dto.getDescricao()
        );

        return repository.save(c);
    }

    public Competencia atualizar(Long id, CompetenciaDTO dto) {
        Competencia existente = buscarPorId(id);

        existente.setNome(dto.getNome());
        existente.setCategoria(dto.getCategoria());
        existente.setDescricao(dto.getDescricao());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        Competencia existente = buscarPorId(id);
        repository.delete(existente);
    }
}
