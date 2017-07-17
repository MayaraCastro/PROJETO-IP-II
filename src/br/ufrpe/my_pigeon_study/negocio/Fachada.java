package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class Fachada {
	
	private Login login;
	private CadastroUsuario cadastroU;
	private static Fachada instancia;
	
	private Fachada(){
		this.login=new Login();
		this.cadastroU=new CadastroUsuario();
	}
	
	public static Fachada getInstancia(){
		if(instancia==null){
			instancia= new Fachada();
		}
		return(instancia);
	}
	
	//USUARIO
	public boolean cadastrarUsuario(Usuario user){
		return(this.cadastroU.cadastrar(user));
	}
	public boolean alterarUsuario(Usuario user){
		return(this.cadastroU.alterar(user));
	}

	public Usuario logar(Usuario user){
		return(this.login.logar(user));
	}

	//TASKS

	public String showTasks(Usuario user){
		return(cadastroU.showTask(user));
	}
	public String calendarioAtividades(Usuario user, int dayOfWeek){
		return(cadastroU.calendarioAtividade(user,dayOfWeek));
	}
	public String calendarioTasks(Usuario user, Data data){
		return(cadastroU.calendarioTask(user,data));
	}
	public boolean cadastrarTask(Usuario user,Task task){
		return(this.cadastroU.cadastrarTask(user,task));
	}
	public Task buscarTask(Usuario user,String nome){
		return(this.cadastroU.buscarTasks(user,nome));
	}
	public boolean alterarTask(Usuario user,Task novaTask,Task nomeOriginal){
		return(cadastroU.alterarTask(user,novaTask,nomeOriginal));
	}
	public boolean deletarTask(Usuario user,String nome){
		return(this.cadastroU.descadastrarTask(user,nome));
	}
	public String showTask(Usuario user){
	return(cadastroU.showTask(user));
}
	//DISCIPLINA
	
	public boolean cadastrarAtividade(Usuario user, Atividade atividade){
		return(this.cadastroU.cadastrarAtividade(user, atividade));
	}
	public Atividade buscarAtividade(Usuario user, String nome){
		return(this.cadastroU.buscarAtividade(user, nome));
	}
	public boolean alterarAtividade(Usuario user,Atividade nova,Atividade original){
		return(cadastroU.alterarAtividade(user, nova,original));
	}
	public boolean deletarAtividade(Usuario user,String nome){
		return(this.cadastroU.descadastrarAtividade(user, nome));
	}
	public String showAtividades(Usuario user){
		return(cadastroU.showAtividade(user));
	}
}
