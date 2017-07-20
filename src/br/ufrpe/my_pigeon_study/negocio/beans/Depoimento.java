package br.ufrpe.my_pigeon_study.negocio.beans;

public class Depoimento {
	private Amigo autor;
	private String mensagem;
	
	//Construtor
	public Depoimento(Amigo autor, String mensagem) {
		super();
		this.autor = autor;
		this.mensagem = mensagem;
	}

	//getters and setters
	public Amigo getAutor() {
		return autor;
	}

	public void setAutor(Amigo autor) {
		this.autor = autor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	//toString
	@Override
	public String toString() {
		return "--Depoimento-- \nAutor: " + autor.getUsuario() + "\n"+ mensagem;
	}
	
	
}
