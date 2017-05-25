package br.ufrpe.negocio.beans;

public class Task {
	
	//oi

	private String data;
	private String nome;
	private String descricao;
	private String tipo;
	private String disciplina;
	private Task lembrar;


	
	public Task() {
		
	}
	
	public Task(String data, String nome, String descricao, String tipo, String disciplina) {
		super();
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.disciplina = disciplina;
	}
	
	
	
	public Task getLembrar() {
		return lembrar;
	}

	public void setLembrar(Task lembrar) {
		this.lembrar = lembrar;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public void deleteTask(Task lemb){
		lemb.data = null;
		lemb.descricao = null;
		lemb.disciplina = null;
		lemb.nome = null;
		lemb.tipo = null;
	}

	
	public String toString() {
		return "Task [data=" + data + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + ", disciplina="
				+ disciplina + "]";
	}
	
}
