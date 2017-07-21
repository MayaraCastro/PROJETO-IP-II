package br.ufrpe.my_pigeon_study;

import br.ufrpe.my_pigeon_study.gui.TelaTextual;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.Data;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class Principal {

	public static void main(String[] args){
		TelaTextual tela= TelaTextual.getInstancia();
		Fachada fachada= Fachada.getInstancia();
		
		//USUARIO JA PRONTO PRA TESTES
		Data dataNasc= new Data(2,2,1999);
		Usuario user= new Usuario("Maria", "maria", "maria", 1, "maria@maria",dataNasc);
		Usuario usera= new Usuario("mayara", "mayara", "mayara", 1, "mayara@mayara",dataNasc);
		fachada.cadastrarUsuario(user);
		fachada.cadastrarUsuario(usera);
		Amigo amg = new Amigo(user.getNome(),user.getUsuario() , 0,user.getEmail(),user.getDataNasc());
		fachada.addAmigo(usera, amg);

		tela.menuInicial();
	}
}
