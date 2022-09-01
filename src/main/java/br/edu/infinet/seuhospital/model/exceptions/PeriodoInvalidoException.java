package br.edu.infinet.seuhospital.model.exceptions;

public class PeriodoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PeriodoInvalidoException(String mensagem) {
		super(mensagem);		
	}

}
