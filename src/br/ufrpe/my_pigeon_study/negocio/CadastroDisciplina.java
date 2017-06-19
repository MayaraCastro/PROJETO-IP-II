package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class CadastroDisciplina {

	public CadastroDisciplina() {
	}
	public boolean cadastrar(Usuario user,Disciplina disci){

			public boolean cadastrar(Usuario user,Disciplina disci){

			if(disci.getNome()!="" ){
				
				if(rep.inserir(disci)){
					return(true);	
				}
			}
			return(false);
		
	}
		
	}
	public Disciplina buscar(Usuario user, String nome){
		return();
	}
	public boolean alterar(Usuario user,Disciplina disci, String original){
		if(disci.getNome() != "" && disci.getDia_da_semana() != 0 && disci.getHorario() != null && disci.getProfessor() != "" 
				&& disci.getObs() != "" & disci.getPeriodo() != ""){
						Disciplina novo = this.rep.buscar(); //TODO bug
						novo.setNome(disci.getNome());
						novo.setDia_da_semana(disci.getDia_da_semana());
						novo.setHorario(disci.getHorario());
						novo.setProfessor(disci.getProfessor());
						novo.setObs(disci.getObs());
						novo.setPeriodo(disci.getPeriodo());
						
						if(this.rep.alterar(novo)){
							return(true);
						}
				}
				return(false);
	
		
	}
	public boolean remover(Usuario user, String disci){
		return()); 
	}
}
