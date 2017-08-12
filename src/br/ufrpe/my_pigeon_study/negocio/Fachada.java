package br.ufrpe.my_pigeon_study.negocio;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
public class Fachada {
	
	private Login login;
	private CadastroUsuario cadastroU;
	private static Fachada instancia;
	
	private Fachada() throws IOException{
		this.login=new Login();
		this.cadastroU=new CadastroUsuario();
	}
	
	public static Fachada getInstancia() throws IOException{
		if(instancia==null){
			instancia= new Fachada();
		}
		return(instancia);
	}
	
	//USUARIO
	public boolean descadastrar(String usuario)throws InformacaoInvalidaException{
		if(usuario==null){
			throw new InformacaoInvalidaException();
		}
		return(this.cadastroU.descadastrar(usuario));
	}
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
	
	public Usuario buscar(String usuario)throws InformacaoInvalidaException{
		return(this.cadastroU.buscar(usuario));
	}
	
	//TASKS
	public ArrayList<String> showTasks(Usuario user){
		try {
			return(cadastroU.showTask(user));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> calendarioAtividades(Usuario user, int dayOfWeek){
		try {
			return(cadastroU.calendarioAtividade(user,dayOfWeek));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> calendarioTasks(Usuario user, LocalDate data){
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
	//DISCIPLINA
	
	public boolean cadastrarAtividade(Usuario user, Disciplina atividade)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		return(this.cadastroU.cadastrarAtividade(user, atividade));
	}
	public Disciplina buscarAtividade(Usuario user, String nome){
		try {
			return(this.cadastroU.buscarAtividade(user, nome));
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean alterarAtividade(Usuario user,Disciplina nova,Disciplina original)throws InformacaoInvalidaException, InformacaoEmBrancoException{
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
