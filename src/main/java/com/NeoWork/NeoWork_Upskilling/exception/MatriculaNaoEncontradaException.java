package com.NeoWork.NeoWork_Upskilling.exception;

public class MatriculaNaoEncontradaException extends RuntimeException {
    public MatriculaNaoEncontradaException(Long id) {
        super("Matrícula com ID " + id + " não encontrada.");
    }
}
