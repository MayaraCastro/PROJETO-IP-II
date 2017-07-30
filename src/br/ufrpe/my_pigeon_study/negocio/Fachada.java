package br.ufrpe.my_pigeon_study.negocio;
import java.time.LocalDate;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
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
	public boolean cadastrarUsuario(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		return(this.cadastroU.cadastrar(user));
	}
	public boolean alterarUsuario(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		return(this.cadastroU.alterar(user));
	}
	public Usuario logar(Usuario user) throws InformacaoInvalidaException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		return(this.login.logar(user));
	}
	

	
	//TASKS
	public String showTasks(Usuario user){
		try {
			return(cadastroU.showTask(user));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String calendarioAtividades(Usuario user, int dayOfWeek){
		try {
			return(cadastroU.calendarioAtividade(user,dayOfWeek));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String calendarioTasks(Usuario user, LocalDate data){
		try {
			return(cadastroU.calendarioTask(user,data));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean cadastrarTask(Usuario user,Task task)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		return(this.cadastroU.cadastrarTask(user,task));
	}
	public Task buscarTask(Usuario user,String nome){
		try {
			return(this.cadastroU.buscarTasks(user,nome));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;

	}
	public boolean alterarTask(Usuario user,Task novaTask,Task nomeOriginal)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		return(cadastroU.alterarTask(user,novaTask,nomeOriginal));
	}
	public boolean deletarTask(Usuario user,String nome){
		try {
			return(this.cadastroU.descadastrarTask(user,nome));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return (Boolean) null;

	}
	public String showTask(Usuario user){
		try {
			return(cadastroU.showTask(user));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;

	}
	//DISCIPLINA
	
	public boolean cadastrarAtividade(Usuario user, Atividade atividade)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		return(this.cadastroU.cadastrarAtividade(user, atividade));
	}
	public Atividade buscarAtividade(Usuario user, String nome){
		try {
			return(this.cadastroU.buscarAtividade(user, nome));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean alterarAtividade(Usuario user,Atividade nova,Atividade original)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		return(cadastroU.alterarAtividade(user, nova,original));
	}
	public boolean deletarAtividade(Usuario user,String nome){
		try {
			return(this.cadastroU.descadastrarAtividade(user, nome));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return (Boolean) null;
	}
	public String showAtividades(Usuario user){
		try {
			return(cadastroU.showAtividade(user));
		} catch (InformacaoEmBrancoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
