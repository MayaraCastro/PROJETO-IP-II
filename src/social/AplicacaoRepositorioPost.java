package social;

public class AplicacaoRepositorioPost {
	public static void main(String[] args) {
		RepositorioPost repositorio= new RepositorioPost();
		Usuario novo = new Usuario("user","netogiuseppe@hotmail.com","recife97","81 9 87704889",
				"Giuseppe","Fiorentino Neto","26/01/1997","Masculino");
		//Usuario newnovo= new Usuario("u","netogiuseppe@hotmail.com","recife1997","81 9 87704889",
		//		"Giuseppe","Fiorentino","26/01/1997","Masculino");
		Post posgem= new Post("Bom dia galerinha do zap zap.",novo);
		Post newposgem= new Post("Quero saber quem transa. Quem transa nessaaaa porra",novo);
		
		
		System.out.println("Inserir: "+repositorio.inserir(posgem));
		System.out.println("Busca: "+repositorio.buscar(novo));
		System.out.println("Alterar: "+repositorio.alterar(newposgem));
		System.out.println("Busca: "+repositorio.buscar(novo));
		System.out.println("Remover: "+repositorio.remover(posgem));
		System.out.println("Busca: "+repositorio.buscar(novo));
		
	}
	
}
