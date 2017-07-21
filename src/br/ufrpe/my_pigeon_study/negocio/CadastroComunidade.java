package br.ufrpe.my_pigeon_study.negocio;
import java.util.ArrayList;


import br.ufrpe.my_pigeon_study.dados.*;
import br.ufrpe.my_pigeon_study.negocio.beans.*;


public class CadastroComunidade {
	RepositorioComunidade rep;
	
	public CadastroComunidade(){
		rep= RepositorioComunidade.getInstancia();
		
	}
	public Comunidade buscarComunidade(Usuario user, String nomecomunidade){
		int i = user.getComunidade().indexOf(new Comunidade(nomecomunidade,user.getUsuario()));
		if(i == -1){
			return null;
		}
		else{
			return(user.getComunidade().get(i));
		}	
	}
	public String listarComunidade(Usuario user){
		ArrayList<Comunidade> comunidades = user.getComunidade();
		String mensagem = "Voce tem "+ user.getComunidade().size() +"  comunidades";
		for(Comunidade a : comunidades){
			if(a != null){
				mensagem +="\n-----------------\n"+ a.toString();
			}		
		}
		return(mensagem);
	}
	
	public boolean addComunidade(Usuario user, Comunidade comunidade){
		if(user.addComunidade(comunidade)){
			Comunidade cm=rep.buscar(comunidade.getNome());
			user.addComunidade(cm);
			return(true);
		}
		return(false);
		
	}
	public boolean delComunidade(Usuario user, Comunidade comunidade){
		
		if(user.delComunidade(comunidade)){
			Comunidade cm=rep.buscar(comunidade.getNome());
			user.delComunidade(cm);
			return(true);
		}
		return(false);
	}
}
