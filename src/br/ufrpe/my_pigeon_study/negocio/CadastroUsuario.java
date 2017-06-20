package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroUsuario {
	private RepositorioUsuario rep;
	public CadastroUsuario(){
		this.rep=RepositorioUsuario.getInstancia();
	}
	public boolean cadastrar(Usuario user){
			if(user.getNome()!=""&&user.getEmail()!=""&&user.getUsuario()!=""
			&&user.getSenha()!=""&&(user.getSexo()<4 && user.getSexo()>0)
			&&(user.getDataNasc().getMes()<13 &&user.getDataNasc().getMes()>0 
			&& user.getDataNasc().getDia()<32 &&user.getDataNasc().getDia()>0
			&&user.getDataNasc().getAno()<2017 &&user.getDataNasc().getAno()>1900)){
				if(this.rep.inserir(user)){
					return(true);
				}
				
			}
			return(false);
	}
	public boolean alterar(Usuario user){
		if(user.getNome()!=""&&user.getEmail()!=""&&user.getUsuario()!=""
		&&user.getSenha()!=""&&(user.getSexo()<4 && user.getSexo()>0)
		&&(user.getDataNasc().getMes()<13 &&user.getDataNasc().getMes()>0 
		&& user.getDataNasc().getDia()<32 &&user.getDataNasc().getDia()>0
		&&user.getDataNasc().getAno()<2017 &&user.getDataNasc().getAno()>1900)){
				Usuario original=this.rep.buscar(user.getUsuario());
				original.setNome(user.getNome());
				original.setDataNasc(user.getDataNasc());
				original.setEmail(user.getEmail());
				original.setSenha(user.getSenha());
				original.setSexo(user.getSexo());
				if(this.rep.alterar(original)){
					return(true);
				}
		}
		return(false);
}
	public Usuario buscar(String usuario){
		return(this.rep.buscar(usuario));
	}
	public boolean descadastrar(String usuario){
		return(this.rep.remover(usuario));
	}
	public boolean addAtividade(Usuario user, Atividade ativi){
		return(user.addAtividade(ativi));
	}
	public String showDisciplinas(Usuario user){
		return(user.showDisciplinas());
	}
	
	//tasks
	public boolean cadastrarTask(Task task){
		if(task.getNome()!=""&&task.getDescricao()!=""&&task.getDisciplina()!=""
				&&task.getData()!=""&&(task.getTipo()>0)){
			if(this.rep.inserirTask(task)){
				return(true);
			}
			
		}
		return(false);
}
	public boolean alterarBask(Task task){
	if(task.getNome()!=""&&task.getDescricao()!=""&&task.getDisciplina()!=""
	&&task.getData()!=""&&(task.getTipo()>0)){
			Task original=this.rep.buscarTask(task.getNome());
			original.setNome(task.getNome());
			original.setDescricao(task.getDescricao());
			original.setDisciplina(task.getDisciplina());
			original.setTipo(task.getTipo());
			original.setData(task.getData());
			if(this.rep.alterarTask(original)){
				return(true);
			}
	}
	return(false);
}
	public String showTasks(Usuario user){
		return(user.showTasks());
	}
	public Task buscarTasks(String Task){
		return(this.rep.buscarTask(Task));
	}
	public boolean descadastrarTask(String Task){
		return(this.rep.removerTask(Task));
	}
}
