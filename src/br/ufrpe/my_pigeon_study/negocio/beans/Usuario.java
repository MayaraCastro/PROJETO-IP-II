package br.ufrpe.my_pigeon_study.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable{
	private String usuario;
	private String senha;
	private String email;
	private String nome;
	private LocalDate dataNasc;
	private String sexo;
	private ArrayList<Disciplina> atividades;
	private ArrayList<Task> tasks;
	
	public Usuario(){

	}
	public Usuario(String usuario, String senha){
		this.usuario=usuario;
		this.senha=senha;
	}

	public Usuario(String nome, String usuario, String senha, String sexo, String email, LocalDate dataNasc) {
		this.nome = nome;
		this.sexo =sexo;
		this.dataNasc = dataNasc;
		
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		
		this.atividades = new ArrayList<Disciplina>();
		this.tasks = new ArrayList<Task>();

	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	//GETTERS AND SETTERS


	public ArrayList<Disciplina> getAtividades() {
		return atividades;
	}
	public void setAtividades(ArrayList<Disciplina> atividades) {
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
	
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + this.getNome() + ", dataNasc=" + this.getDataNasc() + ", usuario=" + usuario + ", senha=" + senha
				+ ", sexo=" + this.getSexo() + ", email=" + email + ", atividades=" + atividades.toString() + ", tasks="
				+ tasks.toString() + "]";
	}


	
}
