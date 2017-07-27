package br.ufrpe.my_pigeon_study;

import javax.swing.JOptionPane;

import Exceptions.*;
import br.ufrpe.my_pigeon_study.gui.TelaTextual;
import br.ufrpe.my_pigeon_study.negocio.Fachada;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class Principal {

	public static void main(String[] args){
		TelaTextual tela= TelaTextual.getInstancia();
		Fachada fachada= Fachada.getInstancia();
		
		//USUARIO JA PRONTO PRA TESTES
		Data dataNasc= new Data(2,2,1999);
		Usuario user= new Usuario("Maria", "maria", "maria", 1, "maria@maria",dataNasc);
		Usuario usera= new Usuario("mayara", "mayara", "mayara", 1, "mayara@mayara",dataNasc);
		Usuario usr=null;
		try{
			fachada.cadastrarUsuario(user);
			fachada.cadastrarUsuario(usera);
			fachada.cadastrarUsuario(usr);
		}catch(InformacaoEmBrancoException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch (InformacaoInvalidaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		try {
			tela.menuInicial();
		} catch (InformacaoInvalidaException e) {
			e.printStackTrace();
		}
	}
}
