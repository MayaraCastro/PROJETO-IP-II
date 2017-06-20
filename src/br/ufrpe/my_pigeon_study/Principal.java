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
		Data dataNasc1= new Data(2,2,1998);
		Usuario user= new Usuario("Maria",dataNasc, "maria", "maria", 1, "maria@maria");
		Usuario user1= new Usuario("Yas",dataNasc1, "yas", "yas", 1, "yas@yas");
		fachada.cadastrarUsuario(user1);
		fachada.cadastrarUsuario(user);
		
		tela.menuInicial();
	}
}
