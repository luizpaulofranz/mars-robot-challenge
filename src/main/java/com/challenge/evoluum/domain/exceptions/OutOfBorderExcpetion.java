package com.challenge.evoluum.domain.exceptions;

public class OutOfBorderExcpetion extends Exception {
	
	private static final long serialVersionUID = 1L;

	public OutOfBorderExcpetion() {
		super("O Robo saiu da área maxima permitida.");
	}
}
