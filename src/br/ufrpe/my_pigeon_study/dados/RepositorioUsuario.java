package br.ufrpe.my_pigeon_study.dados;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int quantUsuarios;

	

	private static RepositorioUsuario instancia;
	
	//CONSTRUTOR
	public RepositorioUsuario(){
		this.usuarios=new Usuario[100];
		this.quantUsuarios=0;

	
	}
	public static RepositorioUsuario getInstancia(){
		if(instancia==null){
			instancia=new RepositorioUsuario();
		}
		return(instancia);
	}
	
	//METODOS GET
	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quantUsuarios;
	}

	//OUTROS METODOS
	public boolean inserir(Usuario user){
		if(user!=null&&this.quantUsuarios<100){
			if(this.buscar(user.getUsuario())==null){
				this.usuarios[this.quantUsuarios]=user;
				this.quantUsuarios++;
				return(true);
			}			
		}
		return(false);
	}
	
	public Usuario buscar(String usuario){
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
		for(int i=0;i<100;i++){
			if(this.usuarios[i]!=null){
				if(entra){
					this.usuarios[i-1]=this.usuarios[i];
					this.usuarios[i]=null;
				}
				else
				{
					if(this.usuarios[i].getUsuario().equals(user)){
						entra=true;
						this.usuarios[i]=null;
						this.quantUsuarios--;
						if(this.quantUsuarios<0){
							this.quantUsuarios=0;
						}
					}
				}
			}
		}
		return(true);
	}

	public boolean alterar(Usuario novoUser){
		if(novoUser!=null){
			for(int i=0;i<100;i++){
				if(this.usuarios[i]!=null&&this.usuarios[i].getUsuario().equals(novoUser.getUsuario())){
					this.usuarios[i]=novoUser;
					return(true);
				}
			}
		}
		return(false);
	}
	

	//ATIVIDADES
	
	public Atividade buscarAtiv(Usuario user,String atividade){
		Atividade[] atividades = user.getAtividades();
		for(Atividade ativ : atividades){
			if(ativ!=null&&ativ.getNome().equals(atividade)){
				return(ativ);
			}
		}
		return(null);
	}


	public boolean addAtividade(Usuario user,Atividade atividade){
		int proxima = user.getProximaAtividade();
		int total = user.getQuantAtividade();
		
		if(atividade != null && proxima < total){
			System.out.println("alo");
			if(this.buscarAtiv(user,atividade.getNome()) ==  null){
				
				Atividade[] atividades = user.getAtividades();
				atividades[user.getProximaAtividade()] = atividade;
				user.setProximaAtividade(++proxima);
				user.setAtividades(atividades);
				return (true);
			}
			
		}
		return false;
	}
	

	public boolean removerAtividade(Usuario user,String atividade){
		int proxima = user.getProximaAtividade();
		
		if(buscarAtiv(user,atividade) == null){
			return (false);
		}
		
		boolean entra=false;
		for(int i=0;i<100;i++){
			if(user.getAtividades()[i] != null){
				if(entra){
					user.getAtividades()[i-1] = user.getAtividades()[i];
					user.getAtividades()[i] = null;
				}
				else
				{
					if(user.getAtividades()[i].getNome().equals(atividade)){
						entra=true;
						user.getAtividades()[i] = null;
						int anterior = user.getProximaAtividade();
						user.setProximaAtividade(--anterior);
						
						if(user.getProximaAtividade() < 0){
							user.setProximaAtividade(0);
					}
				}
			}
		}
		
	}
		return (true);
}
	
	
	public boolean alterarAtiv(Usuario user,Atividade novaAtiv, Atividade antiga){
		if(novaAtiv!=null && antiga != null){
			for(int i=0;i<user.getQuantAtividade();i++){
				if(user.getAtividades()[i] != null && user.getAtividades()[i].getNome().equals(antiga.getNome())){
					user.getAtividades()[i] = novaAtiv;
					return(true);
				}
			}
		}
		return(false);
	}
		

	//Metodos relacionados ao Task
	
	public boolean inserirTask(Usuario user, Task task){
		int pxm=user.getProximaTask();
		int tot=user.getQuantTask();
		if(task!=null&& pxm<tot ){
			if(this.buscarTask(user,task.getNome())==null){
				Task[] tasks = user.getTasks();
				tasks[user.getProximaTask()]=task;
				user.setProximaTask(++pxm);
				user.setTasks(tasks);
				return(true);
			}			
		}
		return(false);
	}
	public Task buscarTask(Usuario user,String task){
		Task[] tasks=user.getTasks();
		for(Task tas:tasks){
			if(tas!=null&& tas.getNome().equals(task)){
				return(tas);
			}
		}
		return(null);
	}
	
	public boolean removerTask(Usuario user,String task){
		int pxm=user.getProximaTask();
		if(buscarTask(user,task)==null){
			return(false);
		}
		boolean entra=false;
		Task[] tasks = user.getTasks();
		for(int i=0;i<100;i++){
			if(tasks[i]!=null){
				if(entra){
					tasks[i-1]=tasks[i];
					tasks[i]=null;
				}
				else
				{
					if(tasks[i].getNome().equals(task)){
						entra=true;
						tasks[i]=null;
						int ant=user.getProximaTask();
						user.setProximaTask(--ant);
						if(user.getProximaTask()<0){
							user.setProximaTask(0);
						}
					}
				}
			}
		}
		user.setTasks(tasks);
		return(entra);
	}

	public boolean alterarTask(Usuario user,Task novoTask, Task antigaTask){
		if(novoTask!=null && antigaTask!=null){
			for(int i=0;i<user.getQuantTask();i++){
				if(user.getTasks()[i]!=null&&user.getTasks()[i].getNome().equals(antigaTask.getNome())){
					user.getTasks()[i]=novoTask;
					return(true);
				}
			}
		}
		return(false);

	}
	

}
