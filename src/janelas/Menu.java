package janelas;

import java.util.Scanner;

import br.ufrpe.negocio.beans.Task;

public class Menu{
	public void Menu() {
		int saida=0;
		Fachada fachada=new Fachada();
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
				
				
				
			}
			else if(resposta==2){
				
			}
			else if(resposta==3){
				
				
				
			}
			else if(resposta==4){
				
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
