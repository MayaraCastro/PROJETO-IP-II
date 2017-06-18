package br.ufrpe.my_pigeon_study.dados;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class RepositorioTask {
	private Task[] tasks;
	private int quantdTask;
	
	public RepositorioTask(){
		tasks= new Task[100];
		quantdTask=0;
	}
	
	public Task[] getTask(){
		return this.tasks;
	}
	
	public int getQuantdTask(){
		return this.quantdTask;
	}
	public Task buscar(String nome){
		for(int i=0;i<this.quantdTask;i++){
			if(this.tasks[i].getNome().equals(nome) && this.tasks[i]!=null){
				return this.tasks[i];
			}
		}	
		return null;
	}
	public boolean inserir(Task task){
		if(this.quantdTask>this.tasks.length || task==null){
			return false;
		}
		Task busca=this.buscar(task.getNome());
		if(busca!=null){
			return false;
						
		}
		this.tasks[this.quantdTask]=task;
		this.quantdTask++;
		return true;
	}
	
	public boolean remover(String nome){
		
		if(this.buscar(nome)==null){
			return false;
		}
		for(int i=0; i<this.quantdTask;i++){
			if(this.tasks[i].getNome().equals(nome) && this.tasks[i]!=null){
				System.out.println("segundo nulo");

				for(int j=i;j<(this.tasks.length-1);j++){
					this.tasks[j]=this.tasks[j+1];
				}
				this.quantdTask--;
				return true;
			}
		}
		System.out.println("vexx");

		return false;
		
	}
	public boolean alterar(Task newTask, String nomeOriginal){
		if(newTask!=null){
			for(int i=0; i<this.quantdTask;i++){
				if(this.tasks[i].getNome().equals(nomeOriginal) && this.tasks[i]!=null){

					this.tasks[i]=newTask;
					return true;		
				}
			}
		}
		return false;
	}
	

}
