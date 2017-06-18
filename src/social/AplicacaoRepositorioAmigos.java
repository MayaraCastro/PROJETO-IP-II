package aplicacoes;

import br.Giuseppe.Luna.beans.*;
import repositorios.*;

public class AplicacaoRepositorioAmigos {
	public static void main(String[] args) {
		RepositorioAmigosPendentes repositorio= new RepositorioAmigosPendentes();
		Usuario novo = new Usuario("netogiuseppe@hotmail.com","recife97","81 9 87704889",
				"Giuseppe","Fiorentino Neto","26/01/1997","Masculino");
		Amigos novoAmigo= new Amigos();
		novoAmigo.setNome(novo.getNome());
		novoAmigo.setEmail(novo.getEmail());
		Amigos novoAmigoPatch= new Amigos();
		novoAmigoPatch.setNome("Creudison");
		novoAmigoPatch.setEmail(novo.getEmail());
		
		System.out.println("Inserir: "+repositorio.inserir(novoAmigo));
		System.out.println("Busca: "+repositorio.buscar(novoAmigo));
		System.out.println("Alterar: "+repositorio.alterar(novoAmigoPatch));
		System.out.println("Busca: "+repositorio.buscar(novoAmigo));
		System.out.println("Remover: "+repositorio.remover(novoAmigo));
		System.out.println("Busca: "+repositorio.buscar(novoAmigo));
		
	}
}
