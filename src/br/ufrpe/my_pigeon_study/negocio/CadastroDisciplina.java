package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroDisciplina {

	public CadastroDisciplina() {
	}
	public boolean cadastrar(Usuario user,Disciplina disci){

			if(disci.getNome()!="" && disci.getDia_da_semana()!= 0 
			&& disci.getHorario()!= null && disci.getProfessor()!= ""
			&& disci.getObs()!= "" && disci.getPeriodo()!= null )
			{
				if(user.addDisciplina(disci)){
					return(true);	
				}
			}
			return(false);
		
	}
	public Disciplina buscar(Usuario user, String nome){
		return(user.getCalendario().getDisciplinas().buscar(nome));
	}
	public boolean alterar(Usuario user,Disciplina disci, String original){
		return(user.getCalendario().getDisciplinas().alterar(disci,original));
	}
	public boolean remover(Usuario user, String disci){
		return(user.getCalendario().getDisciplinas().remover(disci));
	}
}
