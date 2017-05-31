package janelas;
import br.ufrpe.negocio.beans.*;
import java.util.Scanner;
import repositorios.RepositorioUsuario;

public class CadastroUsuario {
	public CadastroUsuario(RepositorioUsuario rep){
		this.cadastrar(rep);
	}
	public void cadastrar(RepositorioUsuario rep){
		Scanner ler=new Scanner(System.in);
		boolean sair=false;
		
		String nome=new String();
		Data dataNasc=new Data();
		String usuario=new String();
		String senha=new String();
		int sexo;
		String email=new String();
		do{
			System.out.println("\tCADASTRAR USUARIO");
			System.out.println("Nome:");
			System.out.flush();
			nome=ler.next();
			
			System.out.println("Data de Nascimento:");
			dataNasc.setDia(ler.nextInt());
			System.out.flush();
			System.out.print("/");
			System.out.flush();
			dataNasc.setMes(ler.nextInt());
			System.out.print("/");
			dataNasc.setAno(ler.nextInt());
			
			System.out.println("Usuario:");
			usuario=ler.next();
			
			System.out.println("Senha:");
			senha=ler.next();
			
			System.out.println("E-mail:");
			email=ler.next();
			
			System.out.println("Sexo:\n1-Feminino |2-Masculino |3-Outro");
			sexo=ler.nextInt();
			System.out.flush();
			
			Usuario user = new Usuario(nome,dataNasc,usuario,senha,sexo,email);
			
			if(nome!=""&&email!=""&&usuario!=""&&senha!=""&&(sexo<4 && sexo>0)
					&&(dataNasc.getMes()<13 &&dataNasc.getMes()>0 && dataNasc.getDia()<32 &&dataNasc.getDia()>0
							&&dataNasc.getAno()<2017 &&dataNasc.getAno()>1900)){
				if(!rep.inserir(user)){
					System.out.println("Usuario ja cadastrado!");
					
				}
				else{
					System.out.println("Cadastro realizado com sucesso!");
				}
				sair=true;
			}
			else{
				System.out.println("Erro! Algumas Informacoes estao incorretas.Tente Novamente.");
			}
			
		}while(!sair);
		//ler.close();
	}

}
