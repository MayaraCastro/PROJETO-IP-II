package br.ufrpe.negocio.beans;

import java.util.Arrays;

public class Calendario {
	private Task[] tasks;
	//private Exame[] exames;
	
	//CONSTRUTOR
	public Calendario() {
		super();
	}
	
	//METODOS
	public int contagemRegressiva(){
		
		return(1);//Editar
	}
	//METODOS GET/SET
	public Task[] getTasks() {
		return tasks;
	}
	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Calendario [tasks=" + Arrays.toString(tasks) + "]";
	}
	
	
	
}
