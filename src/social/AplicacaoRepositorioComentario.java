package social;


public class AplicacaoRepositorioComentario {
	public static void main(String[] args) {
		RepositorioComentario repositorio= new RepositorioComentario();
		Usuario novo = new Usuario("user","netogiuseppe@hotmail.com","recife97","81 9 87704889",
				"Giuseppe","Fiorentino Neto","26/01/1997","Masculino");

		Comentario comenta= new Comentario("Quero saber quem transa. Quem transa nessa porra",novo);
		Comentario newcomenta= new Comentario("Quero saber quem transa. Quem transa nessaaaa porra",novo);
		System.out.println("Inserir: "+repositorio.inserir(comenta));
		System.out.println("Busca: "+repositorio.buscar(novo));
		System.out.println("Alterar: "+repositorio.alterar(newcomenta));
		System.out.println("Busca: "+repositorio.buscar(novo));
		System.out.println("Remover: "+repositorio.remover(comenta));
		System.out.println("Busca: "+repositorio.buscar(novo));
		
	}
}
