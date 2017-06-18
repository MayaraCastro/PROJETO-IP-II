package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.dados.*;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroTask {
	private RepositorioTask rep;

	public CadastroTask() {
		this.rep=new RepositorioTask();
	}
	public boolean cadastrar(Task task){
		//TODO ajeitar e por o negocio da task 
		if(this.rep.inserir(task)){
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public Task buscar(String nome){
		return(this.rep.buscar(nome));
	}
	public boolean alterar(Task novaTask,String nomeOriginal){
		return(this.rep.alterar(novaTask,nomeOriginal));
	}
	public boolean deletar(String nome){
		return(this.rep.remover(nome));
	}
}
