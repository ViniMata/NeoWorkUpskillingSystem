package com.NeoWork.NeoWork_Upskilling.controller;

import com.NeoWork.NeoWork_Upskilling.dto.CompetenciaDTO;
import com.NeoWork.NeoWork_Upskilling.model.Competencia;
import com.NeoWork.NeoWork_Upskilling.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {
    private final CompetenciaService service;

    public CompetenciaController(CompetenciaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Competencia>> listar(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarCompetecias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Competencia> criar(@Valid @PathVariable CompetenciaDTO dto) {
        Competencia nova = service.criar(dto);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public Competencia atualizar(
            @PathVariable Long id,
            @RequestBody @Valid CompetenciaDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entity> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
