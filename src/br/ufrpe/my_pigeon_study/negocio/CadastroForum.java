package br.ufrpe.my_pigeon_study.negocio;
import java.util.ArrayList;

import br.ufrpe.my_pigeon_study.dados.*;
import br.ufrpe.my_pigeon_study.negocio.beans.*;


public class CadastroForum {//fazer tudo apenas copiei do cadastrocomunidade

	RepositorioComunidade rep;
	
	public CadastroForum(){
		rep= RepositorioComunidade.getInstancia();
		
	}
	public Comunidade buscarForum(Usuario user, String nomecomunidade){
		int i = user.getComunidade().indexOf(new Comunidade(nomecomunidade,user.getUsuario()));
		if(i == -1){
			return null;
		}
		else{
			return(user.getComunidade().get(i));
		}	
	}
	public String listarForum(Usuario user){
		ArrayList<Comunidade> comunidades = user.getComunidade();
		String mensagem = "Voce tem "+ user.getComunidade().size() +"  comunidades";
		for(Comunidade a : comunidades){
			if(a != null){
				mensagem +="\n-----------------\n"+ a.toString();
			}		
		}
		return(mensagem);
	}
	
	public boolean addForum(Usuario user, Comunidade comunidade){
		if(user.addComunidade(comunidade)){
			Comunidade cm=rep.buscar(comunidade.getNome());//TODO em duvida
			user.addComunidade(cm);//TODO em duvida
			return(true);
		}
		return(false);
		
	}
	public boolean delForum(Usuario user, Comunidade comunidade){
		
		if(user.delComunidade(comunidade)){
			Comunidade cm=rep.buscar(comunidade.getNome());//TODO em duvida
			user.delComunidade(cm);//TODO em duvida
			return(true);
		}
		return(false);
	}

}
