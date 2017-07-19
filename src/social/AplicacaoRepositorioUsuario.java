package social;


public class AplicacaoRepositorioUsuario {
	public static void main(String[] args) {
		RepositorioUsuario repositorio= new RepositorioUsuario();
		Usuario novo = new Usuario("netogiuseppe@hotmail.com","recife97","(81) 9 8770-4889",
				"Giuseppe","Fiorentino Neto","26/01/1997","Masculino");
		Usuario novonovo = new Usuario("morteaosmachistas@hotmail.com","morteaosmachistas","(11) 9 86690-6660",
				"Catrina","Zouza","26/01/1997","Feminazi");
		
		Post posgatem= new Post("Bando de burgues safado",novo);
		//testar usuario
		System.out.println("Inserir: "+repositorio.inserir(novo));
		System.out.println("Busca: "+repositorio.buscar(novo.getEmail()));
		
		//testePostagem
		
		System.out.println(novo.getRepPost().inserir(posgatem));
		System.out.println(novo.getRepPost().getPostagem(0));
		
		//testeamigos
		Amigo novoamigo= new Amigo();
		novoamigo.setNome(novonovo.getNome());
		novoamigo.setEmail(novonovo.getEmail());
		
		System.out.println(novo.getRepAmigos().inserir(novoamigo));
		System.out.println(novo.getRepAmigos().remover(novoamigo));
		System.out.println(novoamigo.getAmizade());
		
	}
	
}
