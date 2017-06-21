package br.ufrpe.my_pigeon_study.negocio.beans;

import java.util.Arrays;

public class Usuario {
	private String nome;
	private Data dataNasc;
	private String usuario;
	private String senha;
	private int sexo;//1-feminino, 2-masculino e 3-outro
	private String email;
	private Atividade[] atividades;//TODO AJEITAR
	private Task[] tasks;
	private int proximaTask;
	private int proximaAtividade;
	private int quantTask;
	private int quantAtividade;


	
	
	
	public Usuario() {
		super();
	}
	public Usuario(String usuario, String senha){
		this.senha=senha;
		this.usuario=usuario;
	}
	public Usuario(String nome, Data dataNasc, String usuario, String senha, int sexo, String email) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.senha = senha;
		this.sexo = sexo;
		this.email = email;
		this.atividades=new Atividade[100];
		this.tasks = new Task[100];
		this.proximaTask=0;
		this.proximaAtividade=0;
		this.quantTask=100;
		this.quantAtividade=100;

	}	
	
	
	public int getQuantTask() {
		return quantTask;
	}
	public void setQuantTask(int quantTask) {
		this.quantTask = quantTask;
	}
	public int getProximaTask() {
		return proximaTask;
	}
	public void setProximaTask(int proximaTask) {
		this.proximaTask = proximaTask;
	}
	public int getProximaAtividade() {
		return proximaAtividade;
	}
	public void setProximaAtividade(int proximaAtividade) {
		this.proximaAtividade = proximaAtividade;
	}
	public Atividade[] getAtividades() {
		return atividades;
	}
	public void setAtividades(Atividade[] atividades) {
		this.atividades = atividades;
	}
	public Task[] getTasks() {
		return tasks;
	}
	public void setTasks(Task[] tasks) {
		this.tasks = tasks;

	}

	public int getQuantAtividade() {
		return quantAtividade;
	}
	public void setQuantAtividade(int quantAtividade) {
		this.quantAtividade = quantAtividade;
	}
	public Task[] getLembrar() {
		return tasks;
	}


	public void setLembrar(Task[] tasks) {
		this.tasks = tasks;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Data getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Data dataNasc) {
		this.dataNasc = dataNasc;
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


	public int getSexo() {
		return sexo;
	}


	public void setSexo(int sexo) {
		this.sexo = sexo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", dataNasc=" + dataNasc + ", usuario=" + usuario + ", senha=" + senha
				+ ", sexo=" + sexo + ", email=" + email + ", atividades=" + Arrays.toString(atividades) + ", tasks="
				+ Arrays.toString(tasks) + "]";
	}


	
}
