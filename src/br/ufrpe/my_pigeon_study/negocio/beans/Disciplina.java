package br.ufrpe.my_pigeon_study.negocio.beans;

import java.time.LocalTime;

public class Disciplina extends Atividade{
	//ATRIBUTOS
	private int dia_da_semana;
	private LocalTime horario;

	
	//CONSTRUTOR
	public Disciplina(String nome, int dia_da_semana, LocalTime horario, String obs) {
		super(nome,obs);
		this.setDia_da_semana( dia_da_semana);
		this.setHorario(horario);
	}
	//METODOS GET/SET
	public int getDia_da_semana() {
		return dia_da_semana;
	}
	public void setDia_da_semana(int dia_da_semana) {
		if(dia_da_semana>=1 && dia_da_semana<=7){
			this.dia_da_semana = dia_da_semana;
		}
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	//TOSTRING
	@Override
	public String toString() {
		return "Disciplina [nome=" + getNome() + ", dia_da_semana=" + dia_da_semana + ", horario=" + horario +", obs=" + getObs() + "]";
	}
	
	

}
