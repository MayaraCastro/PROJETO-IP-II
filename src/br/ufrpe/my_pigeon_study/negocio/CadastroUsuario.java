package br.ufrpe.my_pigeon_study.negocio;
import java.util.ArrayList;

import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroUsuario {
	private RepositorioUsuario rep;
	public CadastroUsuario(){
		this.rep = RepositorioUsuario.getInstancia();
	}
	public boolean cadastrar(Usuario user){
			if(user.getNome() != "" && user.getEmail() != "" && user.getUsuario() != ""
			&& user.getSenha() != "" && (user.getSexo()<4 && user.getSexo() > 0)
			&& (user.getDataNasc().getMes() < 13 && user.getDataNasc().getMes() > 0 
			&& user.getDataNasc().getDia() < 32 && user.getDataNasc().getDia() > 0
			&& user.getDataNasc().getAno() < 2017 && user.getDataNasc().getAno() > 1900)){
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
	
	//TODO implementar comunidades e depoimentos
	//Depoimentos
	public boolean postarDepoimento(Usuario user, Amigo amg, String depo){
		if(user.contemAmigo(amg)){
			//pega o indice referente ao usuario no amigo dele
			int i = rep.buscar(amg.getUsuario()).getAmigos().indexOf(new Amigo(user.getUsuario()));
			//cria o depoimento com o Amigo referente ao usuario
			Depoimento depos = new Depoimento(rep.buscar(amg.getUsuario()).getAmigos().get(i), depo);
			//add o depoimento ao amigo
			rep.buscar(amg.getUsuario()).getDepoimentos().add(depos);
			return true;
		}
		return false;
	}
	public String listarDepoimentos(Amigo amg){
		Usuario user = rep.buscar(amg.getUsuario());
		ArrayList<Depoimento> depos = user.getDepoimentos();
		String mensagem = user.getDepoimentos().size() +"  Depoimentos";
		for(Depoimento a : depos){
			if(a != null){
				mensagem +="\n-----------------\n"+ a.toString();
			}		
		}
		return(mensagem);
	}
	//Amigos
	public Amigo buscarAmigos(Usuario user, String userAmg){
		int i = user.getAmigos().indexOf(new Amigo(userAmg));
		if(i == -1){
			return(null);
		}
		else{
			return(user.getAmigos().get(i));
		}	
	}
	public String listarAmigos(Usuario user){
		ArrayList<Amigo> amigos = user.getAmigos();
		String mensagem = "Voce tem "+ user.getAmigos().size() +"  amigos";
		for(Amigo a : amigos){
			if(a != null){
				mensagem +="\n-----------------\n"+ a.toString();
			}		
		}
		return(mensagem);
	}
	public Amigo buscarAmigosPendentes(Usuario user, String userAmg){
		int i = user.getAmigosPendentes().indexOf(new Amigo(userAmg));
		if(i == -1){
			return(null);
		}
		else{
			return(user.getAmigosPendentes().get(i));
		}	
	}
	public String listarAmigosPendentes(Usuario user){
		ArrayList<Amigo> amigos = user.getAmigosPendentes();
		String mensagem = "Voce tem "+ user.getAmigosPendentes().size() +"  amigos pendentes";
		for(Amigo a : amigos){
			if(a != null){
				mensagem +="\n-----------------\n"+ a.toString();
			}		
		}
		return(mensagem);
	}
	public Amigo buscarGeral(Usuario user, String userAmg){
		Usuario u = rep.buscar(userAmg);
		if(u!= null && u.getUsuario()!= user.getUsuario()){
			return(new Amigo(u.getNome(),u.getDataNasc(),u.getUsuario(),
					u.getSexo(),u.getEmail()));
		}
		return null;
	}
	public boolean addAmigo(Usuario user, Amigo amg){
		if(user.addAmigo(amg)){
			rep.buscar(amg.getUsuario()).addAmigo(new Amigo(user.getNome(),user.getDataNasc(),user.getUsuario(),
						user.getSexo(),user.getEmail(),1));
			
			return(true);
		}
		return(false);
		
	}
	public boolean delAmigo(Usuario user, Amigo amg){
		if(user.delAmigo(amg)){
			rep.buscar(amg.getUsuario()).delAmigo(new Amigo(user.getNome(),user.getDataNasc(),user.getUsuario(),
					user.getSexo(),user.getEmail()));
			return(true);
		}
		return(false);
	}
	
	//Atividades
	
	public boolean cadastrarAtividade(Usuario user, Atividade atividade){
		
		if(atividade.getNome() != "" && atividade.getDia_da_semana() >0 &&atividade.getDia_da_semana() <=7 && atividade.getHorario() != null){
			
			if(this.rep.addAtividade(user, atividade)){
				return (true);
			}
		}
		return (false);
	}
	
	public boolean alterarAtividade(Usuario user, Atividade atividade,Atividade antiga){
		
		if(atividade.getNome() != "" && atividade.getDia_da_semana() >0 &&atividade.getDia_da_semana() <=7 && atividade.getHorario() != null
				 && atividade.getObs() != ""){
			
			Atividade original = this.rep.buscarAtiv(user, antiga.getNome());
			original.setNome(atividade.getNome());
			original.setDia_da_semana(atividade.getDia_da_semana());
			original.setHorario(atividade.getHorario());
			original.setObs(atividade.getObs());
			
			if(this.rep.alterarAtiv(user, original, antiga)){
				return (true);
			}
		}
		return (false);
	}
	
	public Atividade buscarAtividade(Usuario user,String Atividade){
		return(this.rep.buscarAtiv(user, Atividade));
	}
	
	public boolean descadastrarAtividade(Usuario user,String Atividade){
		return(this.rep.removerAtividade(user,Atividade));
	}
	
	public String showAtividade(Usuario user) {
		
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
	public boolean cadastrarTask(Usuario user, Task task){
		if(task.getNome()!=""&&task.getDescricao()!=""&&task.getData()!=null&&(task.getTipo()>0) && task!=null && user!=null
				&& (task.getData().getMes()<13 &&task.getData().getMes()>0 
				&&task.getData().getDia()<32 &&task.getData().getDia()>0
				&&task.getData().getAno()>=2017)){
			if(this.rep.inserirTask(user,task)){
				return(true);
			}
			
		}
		return(false);
	}
	public boolean alterarTask(Usuario user,Task task,Task antiga){
		if(task.getNome()!=""&&task.getDescricao()!=""&&task.getData()!=null&&(task.getTipo()>0)  && antiga!=null && user!=null
			&&(task.getData().getMes()<13 &&task.getData().getMes()>0 
			&&task.getData().getDia()<32 &&task.getData().getDia()>0
			&&task.getData().getAno()>=2017)){
				Task original=this.rep.buscarTask(user,antiga.getNome());
				original.setNome(task.getNome());
				original.setDescricao(task.getDescricao());
				original.setTipo(task.getTipo());
				original.setData(task.getData());
				if(this.rep.alterarTask(user,original,antiga)){
					return(true);
				}
		}
		return(false);
	}
	
	public Task buscarTasks(Usuario user,String Task){
		return(this.rep.buscarTask(user,Task));
	}
	public boolean descadastrarTask(Usuario user,String Task){
		return(this.rep.removerTask(user,Task));
	}
	
	public String calendarioAtividade(Usuario user, int dayOfWeek){
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
	
	public String calendarioTask(Usuario user, Data data){
		ArrayList<Task> tasks = user.getTasks();
		String msg=null;
		for(Task a:tasks){
			if(a!=null){
				if(a.getData().getDia()==data.getDia()
				&& a.getData().getMes()==data.getMes()
				&& a.getData().getAno()==data.getAno()){
					msg+="\n"+a;
				}
			}
		}
		return(msg);
	}
	public String showTask(Usuario user) {
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
