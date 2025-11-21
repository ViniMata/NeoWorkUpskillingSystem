package com.NeoWork.NeoWork_Upskilling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ============================
    // 1) Erros de validação (DTO)
    // ============================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {

        List<Map<String, String>> errosCampos = new ArrayList<>();

        for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
            Map<String, String> campo = new HashMap<>();
            campo.put("campo", erro.getField());
            campo.put("mensagem", erro.getDefaultMessage());
            errosCampos.add(campo);
        }

        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("status", HttpStatus.BAD_REQUEST.value());
        corpo.put("erro", "Erro de validação");
        corpo.put("campos", errosCampos);
        corpo.put("timestamp", LocalDateTime.now());

        return ResponseEntity.badRequest().body(corpo);
    }

    // ============================
    // 2) Erros 404 – Entidades não encontradas
    // ============================
    @ExceptionHandler({
            UsuarioNaoEncontradoException.class,
            TrilhaNaoEncontradoException.class,
            CompetenciaNaoEncontradaException.class,
            MatriculaNaoEncontradaException.class
    })
    public ResponseEntity<Object> handleNotFound(RuntimeException ex) {

        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("status", HttpStatus.NOT_FOUND.value());
        corpo.put("erro", "Recurso não encontrado");
        corpo.put("mensagem", ex.getMessage());
        corpo.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corpo);
    }

    // ============================
    // 3) JSON mal formatado
    // ============================
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleJsonMalFormatado(HttpMessageNotReadableException ex) {

        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("status", HttpStatus.BAD_REQUEST.value());
        corpo.put("erro", "JSON inválido ou mal formatado");
        corpo.put("mensagem", "O corpo da requisição está incorreto. Verifique o JSON enviado.");
        corpo.put("timestamp", LocalDateTime.now());

        return ResponseEntity.badRequest().body(corpo);
    }

    // ============================
    // 4) Erro genérico interno (500)
    // ============================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleErroGeral(Exception ex) {

        Map<String, Object> corpo = new LinkedHashMap<>();
        corpo.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        corpo.put("erro", "Erro interno no servidor");
        corpo.put("mensagem", ex.getMessage());
        corpo.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(corpo);
    }
}
