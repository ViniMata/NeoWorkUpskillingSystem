package com.NeoWork.NeoWork_Upskilling.exception;

public class TrilhaNaoEncontradoException extends RuntimeException{
    public TrilhaNaoEncontradoException(Long id) {
        super("Trilha com ID " + id + "não encontrada.");
    }
}
