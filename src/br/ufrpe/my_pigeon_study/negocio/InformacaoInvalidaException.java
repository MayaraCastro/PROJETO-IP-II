package br.ufrpe.my_pigeon_study.negocio;

public class InformacaoInvalidaException extends Exception{

	public InformacaoInvalidaException() {
		super("Informação dada inválida");
	}

}
