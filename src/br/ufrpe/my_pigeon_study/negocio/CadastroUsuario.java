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
	public Atividade addAtividade(Usuario user, Atividade ativi){
		return(user.addAtividade(ativi));
	}
	public String showDisciplinas(Usuario user){
		return(user.showDisciplinas());
	}
	public String showTasks(Usuario user){
		return(user.showTasks());
	}

	public String calendario(Usuario user, int dayOfWeek){
		Atividade[] atividades = user.getAtividades();
		String msg=null;
		for(Atividade a:atividades){
			if(a!=null){
				if(a.getDia_da_semana()==dayOfWeek){
					msg+="\n"+a;
				}
			}
		}
		return(msg);
	}
}