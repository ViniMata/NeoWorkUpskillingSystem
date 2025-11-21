package com.NeoWork.NeoWork_Upskilling.exception;

public class CompetenciaNaoEncontradaException extends RuntimeException {

  public CompetenciaNaoEncontradaException(Long id) {
    super("Competência com ID " + id + " não encontrada.");
  }
}
