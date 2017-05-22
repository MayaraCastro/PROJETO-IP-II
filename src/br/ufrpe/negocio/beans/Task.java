package br.ufrpe.negocio.beans;

public class Task {

	private String data;
	private String nome;
	private String descricao;
	private String tipo;
	private String disciplina;


	
	
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

	
	public String toString() {
		return "Task [data=" + data + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + ", disciplina="
				+ disciplina + "]";
	}
	
}
