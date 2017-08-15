package br.ufrpe.my_pigeon_study.negocio.beans;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task extends Atividade{

	private LocalDate data;
	LocalTime horario;

	public Task(LocalDate data, String nome, LocalTime horario, String obs) {

		super(nome, obs);
		this.data = data;
		this.horario = horario;
	}
	
	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public LocalTime getHorario(LocalTime horario) {
		return this.horario;
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