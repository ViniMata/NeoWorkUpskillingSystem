package com.NeoWork.NeoWork_Upskilling.controller;

import com.NeoWork.NeoWork_Upskilling.dto.TrilhaDTO;
import com.NeoWork.NeoWork_Upskilling.model.Trilha;
import com.NeoWork.NeoWork_Upskilling.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {
    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trilha> listarTodas() {
        return service.listarTrilhas();
    }

    @GetMapping("/{id}")
    public Trilha buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Trilha atualizar(
            @PathVariable Long id,
            @RequestBody @Valid TrilhaDTO dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Entity> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
