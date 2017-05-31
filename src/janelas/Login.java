package janelas;
import br.ufrpe.negocio.beans.*;
import java.util.Scanner;
import repositorios.RepositorioUsuario;
public class Login {
	public Login(RepositorioUsuario rep){
		this.log(rep);
	}
	public void log(RepositorioUsuario rep){
		Scanner ler=new Scanner(System.in);
		boolean sair=false;
		
		String usuario=new String();
		String senha=new String();
		Usuario user;
		do{
			System.out.println("\tLOGIN");
			System.out.println("Usuario");
			System.out.flush();
			usuario=ler.next();
			
			System.out.println("Senha");
			System.out.flush();
			senha=ler.next();
			user=rep.buscar(usuario);
			if(user!=null){
				if(user.getSenha().equals(senha)){
					sair=true;
					System.out.println("Login com sucesso!");
				}
				else{
					System.out.println("senha ou usuario incorreto");
				}
			}
			else{
				System.out.println("Usuario nao cadastrado no sistema");
				sair=true;
			}
			
		
		}while(!sair);
	}
	

}
