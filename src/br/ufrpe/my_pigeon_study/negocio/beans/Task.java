package br.ufrpe.my_pigeon_study.negocio.beans;

public class Task {

	private String data;
	private String nome;
	private String descricao;
	private int tipo;
	
	public Task() {
		
	}
	
	public Task(String data, String nome, String descricao, int tipo) {
		super();
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return "Task [data=" + data + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}
	
}
