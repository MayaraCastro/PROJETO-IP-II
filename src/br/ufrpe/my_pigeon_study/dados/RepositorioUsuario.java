package br.ufrpe.my_pigeon_study.dados;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class RepositorioUsuario implements Repositorio, Serializable{
	private ArrayList<Usuario> usuarios;
	private final  String PATH="file.dat";
	private static RepositorioUsuario instancia;
	
	//CONSTRUTOR
	public RepositorioUsuario(){
		this.usuarios=new ArrayList<Usuario>();
	}
	public void salve() {
		try {
			ManipuladorArquivo.escritor(PATH, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static RepositorioUsuario getInstancia(){
		if(instancia==null){
			instancia=new RepositorioUsuario();
		}
		return(instancia);
	}
	
	//METODOS GET
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	//OUTROS METODOS
	public boolean inserir(Object obj){
		Usuario user = (Usuario) obj;
		if(user!=null){
			if(!this.usuarios.contains(user)){
				this.usuarios.add(user);
				this.salve();
				return(true);
			}			
		}
		return(false);
	}
	public Object buscar(String usuario){
		for(Usuario user:this.usuarios){
			if(user!=null&&user.getUsuario().equals(usuario)){
				return(user);
			}
		}
		return(null);
	}
	
	public boolean remover(String user){
		if(buscar(user)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0; i < this.usuarios.size(); i++){
			if(this.usuarios.get(i) != null){
				if(entra){
					this.usuarios.set(i-1, this.usuarios.get(i));
					this.usuarios.set(i, null);
				}
				else
				{
					if(this.usuarios.get(i).getUsuario().equals(user)){
						entra=true;
						this.usuarios.set(i, null);
					}
				}
			}
		}
		if(entra) {
			this.salve();
		}
		return(entra);
	}

	public boolean alterar(Object novoObject){
		Usuario novoUser=(Usuario) novoObject ;
		if(novoUser!=null){
			for(int i=0; i < this.usuarios.size(); i++){
				if(this.usuarios.get(i) != null && this.usuarios.get(i).getUsuario().equals(novoUser.getUsuario())){
					this.usuarios.set(i, novoUser);
					this.salve();
					return(true);
				}
			}
		}
		return(false);
	}
	

	//ATIVIDADES
	
	public Disciplina buscarAtiv(Usuario user, String atividade){
		ArrayList<Disciplina> atividades = user.getAtividades();
		for(Disciplina ativ : atividades){
			if(ativ != null && ativ.getNome().equals(atividade)){
				return(ativ);
			}
		}
		return(null);
	}


	public boolean addAtividade(Usuario user, Disciplina atividade){
		if(atividade != null){
			if(this.buscarAtiv(user, atividade.getNome()) ==  null){
				
				ArrayList<Disciplina> atividades = user.getAtividades();
				atividades.add(atividade);
				user.setAtividades(atividades);
				this.salve();
				return (true);
			}	
		}
		return false;
	}
	
	public boolean removerAtividade(Usuario user, String atividade){
		if(buscarAtiv(user,atividade) == null){
			return (false);
		}	
		boolean entra=false;
		for(int i=0; i < user.getAtividades().size(); i++){
			if(user.getAtividades().get(i) != null){
				if(entra){
					user.getAtividades().set(i-1, user.getAtividades().get(i));
					user.getAtividades().set(i, null);
				}
				else
				{
					if(user.getAtividades().get(i).getNome().equals(atividade)){
						entra=true;
						user.getAtividades().set(i, null);
					}
				}
			}
		}
		this.salve();
		return (true);
}
	
	
	public boolean alterarAtiv(Usuario user, Disciplina novaAtiv, Disciplina antiga){
		if(novaAtiv!=null && antiga != null){
			for(int i=0; i < user.getAtividades().size(); i++){
				if(user.getAtividades().get(i) != null && user.getAtividades().get(i).getNome().equals(antiga.getNome())){
					user.getAtividades().set(i, novaAtiv);
					this.salve();
					return(true);
				}
			}
		}
		return(false);
	}
		

	//Metodos relacionados ao Task
	
	public boolean inserirTask(Usuario user, Task task){
		if(task != null){
			if(this.buscarTask(user, task.getNome()) == null){
				ArrayList<Task> tasks = user.getTasks();
				tasks.add(task);
				this.salve();
				return(true);
			}			
		}
		return(false);
	}
	public Task buscarTask(Usuario user, String task){
		ArrayList<Task> tasks=user.getTasks();
		for(Task tas : tasks){
			if(tas !=null && tas.getNome().equals(task)){
				return(tas);
			}
		}
		return(null);
	}
	
	public boolean removerTask(Usuario user, String task){
		if(buscarTask(user, task) == null){
			return(false);
		}
		boolean entra=false;
		ArrayList<Task> tasks = user.getTasks();
		for(int i = 0; i < tasks.size(); i++){
			if(tasks.get(i) != null){
				if(entra){
					tasks.set(i-1, tasks.get(i));
					tasks.set(i, null);
				}
				else
				{
					if(tasks.get(i).getNome().equals(task)){
						entra=true;
						tasks.set(i,null);
					}
				}
			}
		}
		if(entra) {
			this.salve();
		}
		user.setTasks(tasks);
		return(entra);
	}

	public boolean alterarTask(Usuario user, Task novoTask, Task antigaTask){
		if(novoTask != null && antigaTask != null){
			for(int i=0; i < user.getTasks().size(); i++){
				if(user.getTasks().get(i) != null && user.getTasks().get(i).getNome().equals(antigaTask.getNome())){
					user.getTasks().set(i, novoTask);
					this.salve();
					return(true);
				}
			}
		}
		return(false);

	}
	
}
