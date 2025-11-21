package com.NeoWork.NeoWork_Upskilling.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{
    public UsuarioNaoEncontradoException(Long id) {
        super("Usuario não encontrado com id: " + id);
    }
}
