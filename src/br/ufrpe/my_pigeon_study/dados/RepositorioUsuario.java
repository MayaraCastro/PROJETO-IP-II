package br.ufrpe.my_pigeon_study.dados;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int quantUsuarios;

	private Atividade[] atividades;
	private int qtdAtv;
	private int tamAtiv = 100;

	private int quantTask;
	private Task[] tasks;

	private static RepositorioUsuario instancia;
	
	//CONSTRUTOR
	public RepositorioUsuario(){
		this.usuarios=new Usuario[100];
		this.quantUsuarios=0;

		this.atividades = new Atividade[tamAtiv];
		this.qtdAtv = 0;


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
	
	
	
	public Atividade[] getAtividades() {
		return atividades;
	}
	public int getQtdAtv() {
		return qtdAtv;
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
	
	public Atividade buscarAtiv(String atividade){
		for(Atividade ativ:this.atividades){
			if(ativ!=null&&ativ.getNome().equals(atividade)){
				return(ativ);
			}
		}
		return(null);
	}
	
	public boolean addAtividade(Atividade atividade){
		if(atividade != null && this.qtdAtv <= this.tamAtiv){
			if(this.buscarAtiv(atividade.getNome()) ==  null){
				this.atividades[this.qtdAtv] = atividade;
			this.qtdAtv++;
			return true;
			}
			
		}
		return false;
	}
	

	public boolean removerAtividade(String atividade){
		if(this.buscarAtiv(atividade)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0;i<tamAtiv;i++){
			if(this.atividades[i]!=null){
				if(entra){
					this.atividades[i-1]=this.atividades[i];
					this.atividades[i]=null;
				}
				else
				{
					if(this.atividades[i].getNome().equals(atividade)){
						entra=true;
						this.qtdAtv--;
						if(this.qtdAtv<0){
							this.qtdAtv=0;
						}
					}
				}
			}
		}
		return(true);
	}
	
	public boolean alterarAtiv(Atividade novaAtiv){
		if(novaAtiv!=null){
			for(int i=0;i<tamAtiv;i++){
				if(this.atividades[i]!=null&&this.atividades[i].getNome().equals(novaAtiv.getNome())){
					this.atividades[i]=novaAtiv;
					return(true);
				}
			}
		}
		return(false);
	}
	
	public String showAtiv(){
		for(Atividade a: this.atividades){
			if(a != null){
				a.toString();
			}
			else{
				return null;
			}
		}
		return null;
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
		for(int i=0;i<100;i++){
			if(user.getTasks()[i]!=null){
				if(entra){
					user.getTasks()[i-1]=user.getTasks()[i];
					user.getTasks()[i]=null;
				}
				else
				{
					if(user.getTasks()[i].getNome().equals(task)){
						entra=true;
						int ant=user.getProximaTask();
						user.setProximaTask(--ant);
						if(user.getProximaTask()<0){
							user.setProximaTask(0);
						}
					}
				}
			}
		}
		return(true);
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
