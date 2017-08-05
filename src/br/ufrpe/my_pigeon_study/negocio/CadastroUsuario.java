package br.ufrpe.my_pigeon_study.negocio;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.dados.*;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroUsuario {
	private RepositorioUsuario rep;
	private final  String PATH="file.txt";

	public CadastroUsuario() throws IOException{
		this.Iniciar();
	}
	//////////salvar e iniciar arquivos//////////
	public void Iniciar() throws IOException{
		if(ManipuladorArquivo.leitor(PATH)!=null) this.rep=(RepositorioUsuario) ManipuladorArquivo.leitor(PATH);
		else this.rep=RepositorioUsuario.getInstancia();
	}
	public void Salve() throws IOException{
		ManipuladorArquivo.escritor(PATH, this.rep);
	}
		
	////////////////////////////////////////////
	public boolean cadastrar(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
			if(user.getNome() != "" && user.getEmail() != "" && user.getUsuario() != ""
				&& user.getSenha() != "" ){
				if((user.getSexo()!= "" && user.getSexo() !=null)
					&& (user.getDataNasc().getMonthValue() < 13 && user.getDataNasc().getMonthValue() > 0 
					&& user.getDataNasc().getDayOfMonth() < 32 && user.getDataNasc().getDayOfMonth() > 0
					&& user.getDataNasc().getYear() < 2017 && user.getDataNasc().getYear() > 1900)){
					
					if(this.rep.inserir(user)){
						return(true);
					}
				}else{
					throw new InformacaoInvalidaException();
				}	
			}else{
				throw new InformacaoEmBrancoException();
			}
			return(false);
	}
	public boolean alterar(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(user.getNome()!=""&&user.getEmail()!=""&&user.getUsuario()!=""
		&&user.getSenha()!=""){
			if((user.getSexo() != "" && user.getSexo() != null)
					&& (user.getDataNasc().getMonthValue() < 13 && user.getDataNasc().getMonthValue() > 0 
					&& user.getDataNasc().getDayOfMonth() < 32 && user.getDataNasc().getDayOfMonth() > 0
					&& user.getDataNasc().getYear() < 2017 && user.getDataNasc().getYear() > 1900)){
					Usuario original=(Usuario) this.rep.buscar(user.getUsuario());
					original.setNome(user.getNome());
					original.setDataNasc(user.getDataNasc());
					original.setEmail(user.getEmail());
					original.setSenha(user.getSenha());
					original.setSexo(user.getSexo());
					if(this.rep.alterar(original)){
						return(true);
					}
				}else{
					throw new InformacaoInvalidaException();
				}
		}else{
			throw new InformacaoEmBrancoException();
		}
		return(false);
}
	public Usuario buscar(String usuario)throws InformacaoInvalidaException{
		if(usuario==null){
			throw new InformacaoInvalidaException();
		}
		return((Usuario) this.rep.buscar(usuario));
	}
	public boolean descadastrar(String usuario)throws InformacaoInvalidaException{
		if(usuario==null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.remover(usuario));
	}
	
	
	//Atividades
	
	public boolean cadastrarAtividade(Usuario user, Atividade atividade)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		
		if(atividade.getNome() != "" ){
			if(atividade.getDia_da_semana() >0 &&atividade.getDia_da_semana() <=7 && atividade.getHorario() != null){
			
				if(this.rep.addAtividade(user, atividade)){
					return (true);
				}
			}else{
				throw new InformacaoInvalidaException();
			}
		}else{
			throw new InformacaoEmBrancoException();
		}
		return (false);
	}
	
	public boolean alterarAtividade(Usuario user, Atividade atividade,Atividade antiga)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		
		if(atividade.getNome() != ""){
			if(atividade.getDia_da_semana() >0 &&atividade.getDia_da_semana() <=7 && atividade.getHorario() != null
				 && atividade.getObs() != ""){
			
				Atividade original = this.rep.buscarAtiv(user, antiga.getNome());
				original.setNome(atividade.getNome());
				original.setDia_da_semana(atividade.getDia_da_semana());
				original.setHorario(atividade.getHorario());
				original.setObs(atividade.getObs());
				
				if(this.rep.alterarAtiv(user, original, antiga)){
					return (true);
				}
			}else{
				throw new InformacaoInvalidaException();
			}
		}else{
			throw new InformacaoEmBrancoException();
		}
		return (false);
	}
	
	public Atividade buscarAtividade(Usuario user,String Atividade) throws InformacaoInvalidaException{
		if(user==null | Atividade==null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.buscarAtiv(user, Atividade));
	}
	
	public boolean descadastrarAtividade(Usuario user,String Atividade) throws InformacaoInvalidaException{
		if(user==null | Atividade==null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.removerAtividade(user,Atividade));
	}
	
	public String showAtividade(Usuario user) throws InformacaoEmBrancoException{
		if(user==null){
			 throw new InformacaoEmBrancoException();
		}
		
		ArrayList<Atividade> atividades = user.getAtividades();
		String mensagem = "Voce tem "+ user.getAtividades().size() +"  atividades";
		for(Atividade a : atividades){
			if(a != null){
				mensagem += "\n-----------------\n" + a.toString();
			}		
		}
		return(mensagem);
	}
	
	
	
	//tasks
	public boolean cadastrarTask(Usuario user, Task task)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(task.getNome()!=""){
			if(task.getData()!=null && task!=null && user!=null
				&& (task.getData().getMonthValue()<13 &&task.getData().getMonthValue()>0 
				&&task.getData().getDayOfMonth()<32 &&task.getData().getDayOfMonth()>0
				&&task.getData().getYear()>=2017)){
				if(this.rep.inserirTask(user,task)){
					return(true);
				}
			}else{
				throw new InformacaoInvalidaException();
			}
		}else{
			throw new InformacaoEmBrancoException();
		}
		return(false);
	}
	public boolean alterarTask(Usuario user,Task task,Task antiga)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(task.getNome()!=""){
			if(task.getData()!=null&& task!=null && user!=null
					&& (task.getData().getMonthValue()<13 &&task.getData().getMonthValue()>0 
					&&task.getData().getDayOfMonth()<32 &&task.getData().getDayOfMonth()>0
					&&task.getData().getYear()>=2017)){
					Task original=this.rep.buscarTask(user,antiga.getNome());
					original.setNome(task.getNome());
					original.setObs(task.getObs());
					original.setData(task.getData());
					if(this.rep.alterarTask(user,original,antiga)){
						return(true);
					}
			}else{
				throw new InformacaoInvalidaException();
			}
		}else{
			throw new InformacaoEmBrancoException();
		}
		return(false);
	}
	
	public Task buscarTasks(Usuario user,String Task) throws  InformacaoInvalidaException{
		if(user==null | Task==null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.buscarTask(user,Task));
	}
	public boolean descadastrarTask(Usuario user,String Task) throws  InformacaoInvalidaException{
		if(user==null | Task==null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.removerTask(user,Task));
	}
	
	public String calendarioAtividade(Usuario user, int dayOfWeek) throws  InformacaoInvalidaException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Atividade> atividades = user.getAtividades();
		String msg=null;
		for(Atividade a:atividades){
			if(a!=null){
				if(a.getDia_da_semana()==dayOfWeek){
					if(msg==null){
						msg=".";
					}
					msg+="\n"+a;		
				}
			}
		}
		return(msg);
	}
	
	public String calendarioTask(Usuario user, LocalDate data) throws InformacaoInvalidaException{
		if(user==null | data==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Task> tasks = user.getTasks();
		String msg=null;
		for(Task a:tasks){
			if(a!=null){
				if(a.getData().equals(data)){
					msg+="\n"+a;
				}
			}
		}
		return(msg);
	}
	public String showTask(Usuario user) throws InformacaoInvalidaException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Task> tasks = user.getTasks();
		String msg = "Voce tem "+ user.getTasks().size() +"  tasks";
		for(Task a:tasks){
			if(a!=null){
				msg += "\n-----------------\n" + a.toString();
			}		
		}
		return(msg);
	}
	

}
