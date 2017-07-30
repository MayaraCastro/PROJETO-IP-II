package br.ufrpe.my_pigeon_study.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario extends Pessoa{
	private String usuario;
	private String senha;
	private String email;
	private ArrayList<Atividade> atividades;
	private ArrayList<Task> tasks;
	
	public Usuario(){

	}
	public Usuario(String usuario, String senha){
		this.usuario=usuario;
		this.senha=senha;
	}

	public Usuario(String nome, String usuario, String senha, String sexo, String email, LocalDate dataNasc) {
		super(nome,sexo,dataNasc);
		
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		
		this.atividades = new ArrayList<Atividade>();
		this.tasks = new ArrayList<Task>();

	}
	
	//GETTERS AND SETTERS
	
	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;

	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "Usuario [nome=" + this.getNome() + ", dataNasc=" + this.getDataNasc() + ", usuario=" + usuario + ", senha=" + senha
				+ ", sexo=" + this.getSexo() + ", email=" + email + ", atividades=" + atividades.toString() + ", tasks="
				+ tasks.toString() + "]";
	}


	
}
