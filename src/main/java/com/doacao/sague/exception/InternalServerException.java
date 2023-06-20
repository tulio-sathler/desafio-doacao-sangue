package com.doacao.sague.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public InternalServerException(String message) {
		super();
		this.message = message;
	}

}
