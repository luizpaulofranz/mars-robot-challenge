package com.challenge.evoluum.domain.exceptions;

public class CommandInvalidExcpetion extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CommandInvalidExcpetion() {
		super("O comando recebido é inválido.");
	}
}
