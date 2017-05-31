package br.ufrpe.negocio.beans;
import java.util.Scanner;
import janelas.CadastroUsuario;
import repositorios.RepositorioUsuario;
public class Main {

	public static void main(String[] args) {
		
		RepositorioUsuario rep= new RepositorioUsuario();
		int opcao=0;
		do{	
			CadastroUsuario cadastro=new CadastroUsuario(rep);

			opcao++;
		}while(opcao<2);

		
//		Disciplina[] disc = new Disciplina[2];
//		disc[0] = new Disciplina("Discreta","Segunda","14:00","Linda","Vamo","3");
//		disc[1] = new Disciplina("Calculo","Segunda","16:00","Carla","Nada","3");
//		
//		Data dataa=new Data();
//		Usuario usu = new Usuario("Yasmin",dataa,"yas","oioioi",1,"email");
//		
//		Disciplina[] disc1 = {disc[0]};
//		
//		usu.addDisc(disc1);
//		System.out.println(usu.toString());
//		Horario hora=new Horario(14,00);
//		Data data=new Data(28,5,2017);
//		Exame Va1 = new Exame(7.5,"bela professora", data, hora,disc[0]);
//		System.out.println(Va1);
//		System.out.println(Va1.contagemRegressiva());


	}

}
