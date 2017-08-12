package br.ufrpe.my_pigeon_study.negocio.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task extends Disciplina{

	private LocalDate data;

	public Task(LocalDate data, String nome,int semana, LocalTime horario, String obs) {

		super(nome, semana,horario, obs);
		this.data = data;
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String toString() {
		return "Task [data=" + this.getData() + ", nome=" + this.getNome() + ", descricao=" + this.getObs() + "]";
	}
	
}