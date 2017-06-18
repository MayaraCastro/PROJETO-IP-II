package br.ufrpe.my_pigeon_study.negocio.beans;
import br.ufrpe.my_pigeon_study.dados.*;
import java.util.Arrays;

public class Calendario {
	private RepositorioTask tasks;
	private RepositorioDisciplina discis;
	//private Exame[] exames;
	
	//CONSTRUTOR
	public Calendario() {
		super();
		this.tasks=new RepositorioTask();
		this.discis= new RepositorioDisciplina();
	}
	
	//METODOS
	public int contagemRegressiva(){
		
		return(1);//Editar
	}
	public String showDisciplinas(){
		return(Arrays.toString(this.discis.getDisciplinas()));
	}
	public String showTasks(){
		return(Arrays.toString(this.tasks.getTask()));
	}
	//METODOS GET/SET
	public RepositorioTask getTasks() {
		return tasks;
	}
	public void setTasks(RepositorioTask tasks) {
		this.tasks = tasks;
	}
	public RepositorioDisciplina getDisciplinas() {
		return discis;
	}
	public void setDisciplinas(RepositorioDisciplina discis) {
		this.discis = discis;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Calendario [tasks=" + Arrays.toString(tasks.getTask()) + "]";
	}
	
	
	
}
