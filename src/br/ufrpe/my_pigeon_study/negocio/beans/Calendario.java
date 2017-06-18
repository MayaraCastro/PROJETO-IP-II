package br.ufrpe.my_pigeon_study.negocio.beans;
import java.util.Arrays;

public class Calendario {
	private Task[] tasks;
	private Disciplina[] discis;
	//private Task[] exames;
	
	//CONSTRUTOR
	public Calendario() {
		super();
		this.tasks= new Task[100];
		this.discis= new Disciplina[100];
		//this.exames= new Task[100];
	}
	
	//METODOS
	public int contagemRegressiva(){
		
		return(1);//Editar
	}
	public String showDisciplinas(){
		return(Arrays.toString(this.discis));
	}
	public String showTasks(){
		return(Arrays.toString(this.tasks));
	}
	//METODOS GET/SET
	public Task[] getTasks() {
		return tasks;
	}
	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}
	public Disciplina[] getDisciplinas() {
		return discis;
	}
	public void setDisciplinas(Disciplina[] discis) {
		this.discis = discis;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Calendario [tasks=" + Arrays.toString(tasks) + "]";
	}
	
	
	
}
