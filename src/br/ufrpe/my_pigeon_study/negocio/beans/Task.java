package br.ufrpe.my_pigeon_study.negocio.beans;

public class Task extends Atividade{

	private Data data;
	private String descricao;
	private int tipo;
	
	public Task(Data data, String nome, String descricao, int tipo, int dia_da_semana, Horario horario, String obs) {

		super(nome, dia_da_semana,horario, obs);
		this.data = data;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
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
		return "Task [data=" + this.getData() + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ", tipo=" + this.getTipo() + "]";
	}
	
}
