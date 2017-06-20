package br.ufrpe.my_pigeon_study.dados;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int quantUsuarios;
	private int quantTask;
	private int proximaTask;
	private Task[] tasks;
	private static RepositorioUsuario instancia;
	
	//CONSTRUTOR
	public RepositorioUsuario(){
		this.usuarios=new Usuario[100];
		this.quantUsuarios=0;
		this.quantTask=100;
		this.proximaTask=0;
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
	
	//Metodos relacionados ao Task
	
	public boolean inserirTask(Task task){
		if(task!=null&&this.proximaTask<this.quantTask){
			if(this.buscar(task.getNome())==null){
				this.tasks[this.proximaTask]=task;
				this.proximaTask++;
				return(true);
			}			
		}
		return(false);
	}
	public Task buscarTask(String task){
		for(Task tas:this.tasks){
			if(tas!=null&& tas.getNome().equals(task)){
				return(tas);
			}
		}
		return(null);
	}
	
	public boolean removerTask(String task){
		if(buscar(task)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0;i<100;i++){
			if(this.tasks[i]!=null){
				if(entra){
					this.tasks[i-1]=this.tasks[i];
					this.tasks[i]=null;
				}
				else
				{
					if(this.tasks[i].getNome().equals(task)){
						entra=true;
						this.proximaTask--;
						if(this.proximaTask<0){
							this.proximaTask=0;
						}
					}
				}
			}
		}
		return(true);
	}

	public boolean alterarTask(Task novoTask){
		if(novoTask!=null){
			for(int i=0;i<100;i++){
				if(this.tasks[i]!=null&&this.tasks[i].getNome().equals(novoTask.getNome())){
					this.tasks[i]=novoTask;
					return(true);
				}
			}
		}
		return(false);
	}

}
