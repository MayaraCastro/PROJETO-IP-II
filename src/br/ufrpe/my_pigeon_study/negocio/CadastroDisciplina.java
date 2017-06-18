package negocio;
import java.util.Scanner;
import repositorios.RepositorioDisciplina;
import br.ufrpe.negocio.beans.*;



public class CadastroDisciplina {

	private RepositorioDisciplina repo;

	public CadastroDisciplina() {
		
		this.repo = new RepositorioDisciplina();
	}
	
	public void cadastrarDisc(RepositorioDisciplina rep){
		
		Scanner ler=new Scanner(System.in);
		boolean sair=false;
		
		String nome;
		int dia_da_semana = 0;
		Horario horario = null;
		String professor;
		String obs;
		String periodo = null;
		
		do{
			System.out.println("\tCADASTRAR DISCIPLINA");
			System.out.println("Nome:");
			System.out.flush();
			nome=ler.next();
			
			System.out.println("Dia da semana:");
			dia_da_semana = ler.nextInt();
			System.out.flush();
			
			System.out.println("Horario:");
			horario.setHora(ler.nextInt());	
			System.out.flush();
			System.out.print(":");
			System.out.flush();
			horario.setMinuto(ler.nextInt());
			
			System.out.println("Professor:");
			professor=ler.next();
			System.out.flush();
			
			System.out.println("Observação:");
			obs=ler.next();
			
			System.out.println("Periodo: ");
			obs=ler.next();
			System.out.flush();
			
			Disciplina disci = new Disciplina(nome,dia_da_semana,horario,professor,obs,periodo);
			
			if(nome!="" && dia_da_semana != 0 && horario != null && professor != "" && obs != "" && periodo != null )
			{
				if(!rep.inserirDisc(disci)){
					System.out.println("Disciplina ja cadastrada!");
					
				}
				else{
					System.out.println("Disciplina cadastrada com sucesso!");
				}
				sair=true;
			}
			else{
				System.out.println("Erro! Algumas Informacoes estao incorretas.Tente Novamente.");
			}
			
		}while(!sair);
		
		ler.close();
		
	}

	
	
}
