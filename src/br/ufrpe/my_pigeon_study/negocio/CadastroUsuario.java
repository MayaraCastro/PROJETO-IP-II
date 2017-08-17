package br.ufrpe.my_pigeon_study.negocio;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import Exceptions.InformacaoEmBrancoException;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.dados.*;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroUsuario {
	private RepositorioUsuario rep;
	private final  String PATH="file.dat";
	private LocalDate date;

	public CadastroUsuario() throws IOException{
		date = LocalDate.now();
		this.Iniciar();
	}
	//////////salvar e iniciar arquivos//////////
	public void Iniciar() throws IOException{
		if(ManipuladorArquivo.leitor(PATH) != null) {
			this.rep=(RepositorioUsuario) ManipuladorArquivo.leitor(PATH);

		}
		else {
			this.rep = RepositorioUsuario.getInstancia();
		}
		
	}
	public void salve() {
		try {
			ManipuladorArquivo.escritor(PATH, this.rep);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	////////////////////////////////////////////
	public boolean cadastrar(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
			if(user.getNome() != "" && user.getEmail() != "" && user.getUsuario() != ""
				&& user.getSenha() != "" ){
				if((user.getSexo()!= "" && user.getSexo() !=null)
					&& (user.getDataNasc().compareTo(this.date) < 0 && user.getDataNasc().getYear() > 1900)){
					
					if( this.rep.inserir(user)){
						this.salve();
						return(true);
						
					}
				}else{
					throw new InformacaoInvalidaException();
				}	
			}else{
				throw new InformacaoEmBrancoException();
			}
			throw new InformacaoInvalidaException();
			
	}
	public boolean alterar(Usuario user)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(user.getNome()!=""&&user.getEmail()!=""&&user.getUsuario()!=""
		&&user.getSenha()!=""){
			if((user.getSexo() != "" && user.getSexo() != null)
					&& user.getDataNasc().compareTo(this.date) < 0 && user.getDataNasc().getYear() > 1900){
				
					Usuario original=(Usuario) this.rep.buscar(user.getUsuario());
					original.setNome(user.getNome());
					original.setDataNasc(user.getDataNasc());
					original.setEmail(user.getEmail());
					original.setSenha(user.getSenha());
					original.setSexo(user.getSexo());
					if(this.rep.alterar(original)){
						this.salve();
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
		this.salve();
		return(this.rep.remover(usuario));
	}
	
	
	//Atividades
	
	public boolean cadastrarAtividade(Usuario user, Disciplina atividade)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		
		if(atividade.getNome() != "" ){
			if( atividade.getHorario() != null
					&& atividade.getObs() != null){
			
				if(this.rep.addAtividade(user, atividade)){
					this.salve();
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
	
	public boolean alterarAtividade(Usuario user, Disciplina atividade,Disciplina antiga)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(atividade.getNome() != ""){
			if(atividade.getHorario() != null
				 && atividade.getObs() != null){

				Disciplina original = this.rep.buscarAtiv(user, antiga.getNome());
				original.setNome(atividade.getNome());
				original.setDia_da_semana(atividade.getDia_da_semana());
				original.setHorario(atividade.getHorario());
				original.setObs(atividade.getObs());
				original.setHorario(atividade.getHorario());
				if(this.rep.alterarAtiv(user, original, antiga)){
					this.salve();
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
	
	public Disciplina buscarAtividade(Usuario user,String Atividade) throws InformacaoInvalidaException{
		if(user == null | Atividade == null){
			throw new InformacaoInvalidaException();
		}
		return(this.rep.buscarAtiv(user, Atividade));
	}
	
	public boolean descadastrarAtividade(Usuario user,String Atividade) throws InformacaoInvalidaException{
		if(user==null | Atividade==null){
			throw new InformacaoInvalidaException();
		}
		this.salve();
		return(this.rep.removerAtividade(user,Atividade));
	}
	
	public  ArrayList<String> showAtividade(Usuario user) throws InformacaoEmBrancoException{
		if(user==null){
			 throw new InformacaoEmBrancoException();
		}
		
		ArrayList<Disciplina> atividades = user.getAtividades();
		ArrayList<String> list = new ArrayList<String>();
		for(Disciplina a:atividades){
			if(a!=null){
				list.add(a.getNome());
			}		
		}
		return(list);
	}
	
	//tasks
	public boolean cadastrarTask(Usuario user, Task task)throws InformacaoInvalidaException, InformacaoEmBrancoException{
		if(task.getNome()!= null){
			if( task.getData()!=null && task!=null && user!=null
					&& task.getData().compareTo(this.date)>=0){
				
				if(this.rep.inserirTask(user,task)){
					this.salve();
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
		if(task.getNome() != null){
			if(task.getData()!=null&& task!=null && user!=null
					&& task.getData().compareTo(this.date)>=0){
				
					Task original = this.rep.buscarTask(user,antiga.getNome());
					original.setNome(task.getNome());
					original.setObs(task.getObs());
					original.setData(task.getData());
					original.setHorario(task.getHorario());
					if(this.rep.alterarTask(user,original,antiga)){
						this.salve();
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
		this.salve();
		return(this.rep.removerTask(user,Task));
	}
	
	public ArrayList<String> calendarioAtividade(Usuario user, int dayOfWeek) throws  InformacaoInvalidaException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Disciplina> atividades = user.getAtividades();
		Collections.sort(atividades, (d1, d2) -> {
			return d1.getHorario().compareTo(d2.getHorario());
		});
		ArrayList<String> list = new ArrayList<String>();
		
		for(Disciplina a:atividades){
			if(a!=null){
				if(a.getDia_da_semana()==dayOfWeek){
					list.add(a.getNome());
							
				}
			}
		}
		return(list);
	}
	
	public ArrayList<String> calendarioTask(Usuario user, LocalDate data) throws InformacaoInvalidaException{
		if(user==null | data==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Task> tasks = user.getTasks();
		Collections.sort(tasks, (t1, t2) -> {
			return t1.getHorario().compareTo(t2.getHorario());
		});
		ArrayList<String> list = new ArrayList<String>();
		
		for(Task a:tasks){
			if(a!=null){
				if(a.getData().equals(data)){
					list.add(a.getNome());
					
				}
			}
		}
		return(list);
	}
	public ArrayList<String> showTask(Usuario user) throws InformacaoInvalidaException{
		if(user==null){
			throw new InformacaoInvalidaException();
		}
		ArrayList<Task> tasks = user.getTasks();
		ArrayList<String> list = new ArrayList<String>();
		for(Task a:tasks){
			if(a!=null){
				list.add(a.getNome());
			}		
		}
		return(list);
	}
	

}
