package br.Giuseppe.Luna.beans;

public class Amigos {
	private String nome;//recebe do usuario
	private String email;//recebe do usuario
	private int amizade;//if 0=nao amigo; if 1==amigo; if 2==pendentes
	
	public Amigos(){
		this.nome=null;
		this.email=null;
		this.amizade=0;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAmizade() {
		return this.amizade;
	}

	public void setAmizade(int amizade) {
		this.amizade = amizade;
	}
	
	public String toString(){
		return "Amigo[Nome: "+this.nome+", Email: "+this.email+"]";
	}
	
}
