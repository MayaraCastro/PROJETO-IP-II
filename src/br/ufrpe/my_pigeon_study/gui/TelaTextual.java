package br.ufrpe.my_pigeon_study.gui;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
import br.ufrpe.my_pigeon_study.negocio.*;
import java.util.Scanner;
import java.util.Calendar;

public class TelaTextual {
	Scanner scanner;
	Calendar calendario;
	private Fachada fachada;
	private static TelaTextual instancia;
	
	public TelaTextual(){
		this.scanner=new Scanner(System.in);
		this.calendario= Calendar.getInstance();
		this.fachada=Fachada.getInstancia();
	}
	
	public static TelaTextual getInstancia(){
		if(instancia==null){
			instancia=new TelaTextual();
		}
		return(instancia);
	}
	
	
	//TELAS
	public void menuInicial(){
		boolean saida=false;
		while(!saida){
			System.out.println("=====BEMVINDO=====");
			System.out.println("[1]Cadastrar novo usuario");
			System.out.println("[2]Logar");
			System.out.println("[3]Sair");
			System.out.println("=====BEMVINDO=====");
			System.out.print("RESPOSTA: ");
			int resposta=scanner.nextInt();
			switch(resposta){
				case 1:{
					this.cadastroUsuario();
					break;
				}
				case 2:{
					this.login();
					break;
				}
				case 3:{
					saida=true;
					break;
				}
				default:{
					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				}
			}
		}
	}	
	public void login(){
		
		System.out.println("\tLOGIN");
		System.out.println("Usuario");
		System.out.flush();
		String usuario=scanner.next();
		
		System.out.println("Senha");
		System.out.flush();
		String senha=scanner.next();
		Usuario user= new Usuario(usuario,senha);
		user=this.fachada.logar(user);
		if(user!=null){
			System.out.println("Login com sucesso!");
			this.telaInicial(user);
		}
		else{
			System.out.println("senha ou usuario incorreto");
		}
	}
	
	//TELAS USUARIO
	public void cadastroUsuario(){
		String nome=new String();
		Data dataNasc=new Data();
		String usuario=new String();
		String senha=new String();
		int sexo;
		String email=new String();
		System.out.println("\tCADASTRAR USUARIO");
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.next();
		
		System.out.println("Data de Nascimento:");
		dataNasc.setDia(scanner.nextInt());
		System.out.flush();
		System.out.print("/");
		System.out.flush();
		dataNasc.setMes(scanner.nextInt());
		System.out.print("/");
		dataNasc.setAno(scanner.nextInt());
		
		System.out.println("Usuario:");
		usuario=scanner.next();
		
		System.out.println("Senha:");
		senha=scanner.next();
		
		System.out.println("E-mail:");
		email=scanner.next();
		
		System.out.println("Sexo:\n1-Feminino |2-Masculino |3-Outro");
		sexo=scanner.nextInt();
		System.out.flush();
		
		Usuario user = new Usuario(nome,dataNasc,usuario,senha,sexo,email);
		if(fachada.cadastrarUsuario(user)){
			System.out.println("Cadastro com sucesso!");
		}
		else{
			System.out.println("Erro ao efetuar cadastro!");
		}
	}
	public void alterarUsuario(String usuario){
		String nome=new String();
		Data dataNasc=new Data();
		String senha=new String();
		int sexo;
		String email=new String();
		System.out.println("\nALTERAR USUARIO");
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.next();
		
		System.out.println("Data de Nascimento:");
		dataNasc.setDia(scanner.nextInt());
		System.out.flush();
		System.out.print("/");
		System.out.flush();
		dataNasc.setMes(scanner.nextInt());
		System.out.print("/");
		dataNasc.setAno(scanner.nextInt());
		
		System.out.println("Senha:");
		senha=scanner.next();
		
		System.out.println("E-mail:");
		email=scanner.next();
		
		System.out.println("Sexo:\n1-Feminino |2-Masculino |3-Outro");
		sexo=scanner.nextInt();
		System.out.flush();
		
		Usuario user = new Usuario(nome,dataNasc,usuario,senha,sexo,email);
		if(fachada.alterarUsuario(user)){
			System.out.println("Altera�ao com sucesso!");
		}
		else{
			System.out.println("Erro ao efetuar altera�ao!");
		}
	}
	public void telaInicial(Usuario user){//TODO finalizar
		boolean saida=false;
		while(!saida){
			System.out.println("=====BEMVINDO=====");
			System.out.println("[1]Perfil");
			System.out.println("[2]Calendario");
			System.out.println("[3]Tasks");
			System.out.println("[4]Atividades");
			System.out.println("[5]Sair");
			System.out.println("=====BEMVINDO=====");
			System.out.print("RESPOSTA: ");
			int resposta=scanner.nextInt();
			switch(resposta){
				case 1:{
					this.perfil(user);
					break;
				}
				case 2:{
					this.calendario(user);
					break;
				}
				case 3:{
					this.menuTask(user);
					break;
				}
				case 4: {
					break;
				}
				case 5:{
					saida=true;
					break;
				}
				default:{
					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				}
			}
		}
	}
	public void perfil(Usuario user){
		System.out.println("=====BEMVINDO=====");
		System.out.println("Nome :"+user.getNome());
		System.out.println("Usuario: "+ user.getUsuario());
		System.out.println("Data de Nascimento: "+ user.getDataNasc());
		System.out.println("\n[1]Alterar\n[2]Voltar");
		int resp=scanner.nextInt();
			switch(resp){
			case 1:{
				this.alterarUsuario(user.getUsuario());
				break;
			}
			case 2:{
			}
		}
	}
	public void showAtividades(Usuario user){
		fachada.showAtividades(user);
	}
	public void calendario(Usuario user){
		System.out.println("DIA:");
		Data data= new Data();
		data.setDia(scanner.nextInt());
		System.out.println("MES:");
		data.setMes(scanner.nextInt());
		System.out.println("ANO:");
		data.setAno(scanner.nextInt());
		
		this.calendario.set(data.getAno(), data.getMes(), data.getDia());
		int dayOfWeek = calendario.get(Calendar.DAY_OF_WEEK);
		
		String msg=this.fachada.calendarioAtividades(user, dayOfWeek);
		System.out.println("====ATIVIDADES====");
		if(msg==null){
			System.out.println("Voce nao tem atividades para este dia");
		}else{
			System.out.println("a"+msg);
		}
		
		msg=this.fachada.calendarioTasks(user, data);
		System.out.println("====TASKS====");
		if(msg==null){
			System.out.println("Voce nao tem tasks para este dia");
		}else{
			System.out.println("a"+msg);
		}
		
		
	}
//	//TELAS DISCIPLINAS
//	public void cadastroDisciplina(Usuario user){
//		String nome;
//		int dia_da_semana = 0;
//		Horario horario = new Horario();
//		String professor;
//		String obs;
//	
//		System.out.println("\tCADASTRAR DISCIPLINA");
//		System.out.println("Nome:");
//		System.out.flush();
//		nome=scanner.next();
//			
//		System.out.println("Dia da semana:");
//		dia_da_semana = scanner.nextInt();
//		System.out.flush();
//			
//		System.out.println("Horario:");
//		horario.setHora(scanner.nextInt());	
//		System.out.flush();
//		System.out.print(":");
//		System.out.flush();
//		horario.setMinuto(scanner.nextInt());
//			
//		System.out.println("Professor:");
//		professor=scanner.next();
//		System.out.flush();
//			
//		System.out.println("Observa��o:");
//		obs=scanner.next();
//
//		Disciplina disci = new Disciplina(nome,dia_da_semana,horario,professor,obs);
//		if(fachada.cadastrarDisciplina(user,disci)){
//			System.out.println("Cadastro com sucesso!");
//		}
//		else{
//			System.out.println("Erro!");
//		}
//	}
//	public void menuAtividades(Usuario user){
//		boolean saida=false;
//		while(!saida){
//			System.out.println("=====BEMVINDO=====");
//			System.out.println("[1]Inserir");
//			System.out.println("[2]Buscar");
//			System.out.println("[3]Listar");
//			System.out.println("[4]voltar");
//			System.out.println("=====BEMVINDO=====");
//			System.out.print("RESPOSTA: ");
//			int resposta=scanner.nextInt();
//			switch(resposta){
//				case 1:{
//					this.cadastroDisciplina(user);
//					break;
//				}
//				case 2:{
//					this.buscarDisciplina(user);
//					break;
//				}
//				case 3:{
//					this.showDisciplinas(user);
//					break;
//				}
//				case 4:{
//					saida=true;
//				}
//				default:{
//					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
//				}
//			}
//		}
//	}	
//	public void buscarDisciplina(Usuario user){
//		System.out.print("Nome: ");
//		String nome=scanner.nextLine();
//		Disciplina disci=fachada.buscarDisciplina(user,nome);
//		if(disci==null){
//			System.out.println("Erro ao Buscar");
//		}
//		else
//		{
//			System.out.println(disci);
//			System.out.println("\n[1]Alterar\n[2]Deletar\n[3]Voltar");
//			int resp=scanner.nextInt();
//			switch(resp){
//			case 1:{
//				this.alterarDisciplina(user,disci.getNome());
//				break;
//			}
//			case 2:{
//				this.deletarDisciplina(user,disci.getNome());
//				break;
//			}
//			case 3:{
//				
//			}
//			}
//		}
//	}
//	public void alterarDisciplina(Usuario user,String nomeOriginal){
//		System.out.println("=====NovosDados=====");
//		String nome;
//		int dia_da_semana = 0;
//		Horario horario = new Horario();
//		String professor;
//		String obs;
//	
//		System.out.println("Nome:");
//		System.out.flush();
//		nome=scanner.next();
//			
//		System.out.println("Dia da semana:");
//		dia_da_semana = scanner.nextInt();
//		System.out.flush();
//			
//		System.out.println("Horario:");
//		horario.setHora(scanner.nextInt());	
//		System.out.flush();
//		System.out.print(":");
//		System.out.flush();
//		horario.setMinuto(scanner.nextInt());
//			
//		System.out.println("Professor:");
//		professor=scanner.next();
//		System.out.flush();
//			
//		System.out.println("Observa��o:");
//		obs=scanner.next();
//			
//			
//		Disciplina disci = new Disciplina(nome,dia_da_semana,horario,professor,obs);
//		if(fachada.alterarDisciplina(user,disci,nomeOriginal)){
//			System.out.println("Alterado com Sucesso");
//		}
//		else
//		{
//			System.out.println("Erro ao Alterar");
//		}
//	}
//	public void deletarDisciplina(Usuario user, String nome){
//		if(fachada.deletarDisciplina(user,nome)==true){
//			System.out.println("Deletado Com Sucesso");
//		}
//		else
//		{
//			System.out.println("Erro ao deletar");
//		}
//	}
//	
	//TELAS TASK
	
	public void menuTask(Usuario user){
		boolean saida=false;
		while(!saida){
			System.out.println("=====BEMVINDO=====");
			System.out.println("[1]Inserir");
			System.out.println("[2]Buscar");
			System.out.println("[3]Listar");
			System.out.println("[4]voltar");
			System.out.println("=====BEMVINDO=====");
			System.out.print("RESPOSTA: ");
			int resposta=scanner.nextInt();
			scanner.nextLine();
			switch(resposta){
				case 1:{
					this.cadastroTask(user);
					break;
				}
				case 2:{
					this.buscarTask(user);
					break;
				}
				case 3:{
					this.showTasks(user);
					break;
				}
				case 4:{
					saida=true;
				}
				default:{
					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				}
			}
		}
	}
	public void showTasks(Usuario user){
		fachada.showTask(user);
	}	
	public void cadastroTask(Usuario user){
		System.out.print("Nome: ");
		String nome=scanner.nextLine();
		System.out.print("Tipo: ");
		int tipo=scanner.nextInt();
		
		scanner.nextLine();
		System.out.print("Data: ");//TODO modificar pra data
		Data data=new Data();
		System.out.println("DIA:");
		data.setDia(scanner.nextInt());
		System.out.println("MES:");
		data.setMes(scanner.nextInt());
		System.out.println("ANO:");
		data.setAno(scanner.nextInt());
		
		scanner.nextLine();
		System.out.print("Descricao: ");
		String descricao=scanner.nextLine();

		Task novaTask = new Task(data,nome,descricao,tipo);
		if(fachada.cadastrarTask(user,novaTask)){
			System.out.println("Inserido com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Inserir");
		}
	}
	public void buscarTask(Usuario user){
		System.out.print("Nome: ");
		String nome=scanner.nextLine();
		//scanner.nextLine();
		Task task=fachada.buscarTask(user,nome);
		if(task==null){
			System.out.println("Erro ao Buscar");
		}
		else
		{
			System.out.println(task);
			System.out.println("\n[1]Alterar\n[2]Deletar\n[3]Voltar");
			int resp=scanner.nextInt();
			switch(resp){
			case 1:{
				this.alterarTask(task.getNome());
				break;
			}
			case 2:{
				this.deletarTask(task.getNome());
				break;
			}
			case 3:{
				
			}
			}
		}
	}
	public void alterarTask(String nomeOriginal){
		System.out.println("=====NovosDados=====");
		System.out.print("Nome: ");
		scanner.nextLine();
		String nome=scanner.nextLine();
		scanner.nextLine();
		System.out.print("Tipo: ");
		int tipo=scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.print("Data: ");
		System.out.println("DIA:");
		Data data= new Data();
		data.setDia(scanner.nextInt());
		System.out.println("MES:");
		data.setMes(scanner.nextInt());
		System.out.println("ANO:");
		data.setAno(scanner.nextInt());
		
		scanner.nextLine();
		System.out.print("Descricao: ");
		String descricao=scanner.nextLine();
		Task novaTask = new Task(data,nome,descricao,tipo);
		if(fachada.alterarTask(novaTask, nomeOriginal)){
			System.out.println("Alterado com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Alterar");
		}
	}
	public void deletarTask(String nome){
		if(fachada.deletarTask(nome)==true){
			System.out.println("Deletado Com Sucesso");
		}
		else
		{
			System.out.println("Erro ao deletar");
		}
	}
}