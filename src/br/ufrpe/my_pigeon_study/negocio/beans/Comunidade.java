package br.ufrpe.my_pigeon_study.negocio.beans;
import java.util.ArrayList;


public class Comunidade {
	private String nome;
	private String usuario;
	private ArrayList<Amigo> amigos;

	public Comunidade(String nome, String usuario) {
		this.amigos= new ArrayList<Amigo>();
		this.nome=nome;
		this.usuario=usuario;
	}
	//GETTERS AND SETTERS
	public ArrayList<Amigo> getMembros() {
		return amigos;
	}

	public void setMembros(ArrayList<Amigo> membros) {
		this.amigos = membros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Amigo> getAmigos() {
		return amigos;
	}
	public void setAmigos(ArrayList<Amigo> amigos) {
		this.amigos = amigos;
	}
	@Override
	public String toString() {
		return "Usuario [Nome da Comunidade=" + this.getNome()+"; Numero de Membros: "+this.getMembros().size()+"]";
	}
	
}
