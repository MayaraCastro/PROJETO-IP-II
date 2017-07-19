package social;

public class Principal {
	public static void main(String[] args){
		Usuario novo = new Usuario("giu","netogiuseppe@hotmail.com","recife97","(81) 9 8770-4889",
				"Giuseppe","Fiorentino Neto","26/01/1997","Masculino");
		Usuario novonovo = new Usuario("pepe","morteaosmachistas@hotmail.com","morteaosmachistas","(11) 9 86690-6660",
				"Catrina","Zouza","26/01/1997","Feminazi");
		Amigo a = new Amigo("pepe");
		if(novo.addAmigo(a)){
			novonovo.addAmigo(new Amigo(novo.getUser()));
			System.out.println("a");
		}
		
		
	}

}
