package janelas;
import repositorios.*;
import java.util.Scanner;
import br.ufrpe.negocio.beans.*;

public class CadastrarTask {
	public void Cadastro() {
		int saida=0;
		RepositorioTask repositorio=new RepositorioTask();
		while(saida==0){
			System.out.println("=====BEMVINDO=====");
			System.out.println("[1]Inserir");
			System.out.println("[2]Alterar");
			System.out.println("[3]Deletar");
			System.out.println("[4]Buscar");
			System.out.println("[5]Sair");
			System.out.println("=====BEMVINDO=====");
			System.out.print("RESPOSTA: ");
			Scanner scanner = new Scanner(System.in);
			int resposta=scanner.nextInt();
			String salto=scanner.nextLine();
			if(resposta==1){
				
				
				System.out.print("Nome: ");
				String nome=scanner.nextLine();
				System.out.print("Tipo: ");
				String tipo=scanner.nextLine();
				System.out.print("Disciplina: ");//precisa modificar o tipo de disciplina de task, pra o tipo DIsciplina
				String disciplina=scanner.nextLine();
				System.out.print("Data: ");
				String data=scanner.nextLine();
				System.out.print("Descricao: ");
				String descricao=scanner.nextLine();
				
				Task novaTask = new Task(data,nome,descricao,tipo,disciplina);
				boolean resp=repositorio.Inserir(novaTask);
				if(resp==true){
					System.out.println("Inserido com Sucesso");
				}
				else
				{
					System.out.println("Erro ao Inserir");
				}
			}
			else if(resposta==2){
				System.out.print("Nome que quer alterar: ");
				String nomeOriginal=scanner.nextLine();
				System.out.println("=====NovosDados=====");
				System.out.print("Nome: ");
				String nome=scanner.nextLine();
				System.out.print("Tipo: ");
				String tipo=scanner.nextLine();
				System.out.print("Disciplina: ");//precisa modificar o tipo de disciplina de task, pra o tipo DIsciplina
				String disciplina=scanner.nextLine();
				System.out.print("Data: ");
				String data=scanner.nextLine();
				System.out.print("Descricao: ");
				String descricao=scanner.nextLine();
				Task novaTask = new Task(data,nome,descricao,tipo,disciplina);
				boolean resp=repositorio.Alterar(novaTask,nomeOriginal);
				if(resp==true){
					System.out.println("Alterado com Sucesso");
				}
				else
				{
					System.out.println("Erro ao Alterar");
				}
			}
			else if(resposta==3){
				System.out.print("Nome: ");
				String nome=scanner.nextLine();
				boolean resp=repositorio.Remover(nome);
				if(resp==true){
					System.out.println("Deletado Com Sucesso");
				}
				else
				{
					System.out.println("Erro ao deletar");
				}
				
				
			}
			else if(resposta==4){
				System.out.print("Nome: ");
				String nome=scanner.nextLine();
				Task resp=repositorio.Buscar(nome);
				if(resp==null){
					System.out.println("Erro ao Buscar");
				}
				else
				{
					System.out.println(repositorio.Buscar(nome));
				}			
				
			}
			else if(resposta==5){
				saida=5;
			}
			else{
				System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				saida=0;
			}
		}
		
		
	}
}
