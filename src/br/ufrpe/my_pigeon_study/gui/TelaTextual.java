package br.ufrpe.my_pigeon_study.gui;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
import br.ufrpe.my_pigeon_study.negocio.*;
import java.util.Scanner;

public class TelaTextual {
	Scanner scanner=new Scanner(System.in);
	Fachada fachada= new Fachada();
	public static void main(String[] args){
		TelaTextual tela= new TelaTextual();
		tela.menuInicial();
	}

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
		
		if(this.fachada.logar(user)){
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
			System.out.println("Alteraçao com sucesso!");
		}
		else{
			System.out.println("Erro ao efetuar alteraçao!");
		}
	}
	public void telaInicial(Usuario user){//TODO finalizar
		boolean saida=false;
		while(!saida){
			System.out.println("=====BEMVINDO=====");
			System.out.println("[1]Perfil");
			System.out.println("[2]Calendario");
			System.out.println("[3]Tasks");
			System.out.println("[4]Exames");
			System.out.println("[5]Atividades");
			System.out.println("[6]Sair");
			System.out.println("=====BEMVINDO=====");
			System.out.print("RESPOSTA: ");
			int resposta=scanner.nextInt();
			switch(resposta){
				case 1:{
					this.perfil(user);
					break;
				}
				case 2:{

					break;
				}
				case 3:{
					this.menuTask(user);
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
	public void showDisciplinas(Usuario user){
		fachada.showDisciplinas(user);
	}
	public void showTasks(Usuario user){
		fachada.showTasks(user);
	}
	//TELAS DISCIPLINAS
	public void cadastroDisciplina(Usuario user){
		String nome;
		int dia_da_semana = 0;
		Horario horario = new Horario();
		String professor;
		String obs;
		String periodo = null;
	
		System.out.println("\tCADASTRAR DISCIPLINA");
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.next();
			
		System.out.println("Dia da semana:");
		dia_da_semana = scanner.nextInt();
		System.out.flush();
			
		System.out.println("Horario:");
		horario.setHora(scanner.nextInt());	
		System.out.flush();
		System.out.print(":");
		System.out.flush();
		horario.setMinuto(scanner.nextInt());
			
		System.out.println("Professor:");
		professor=scanner.next();
		System.out.flush();
			
		System.out.println("Observação:");
		obs=scanner.next();
			
		System.out.println("Periodo: ");
		obs=scanner.next();
		System.out.flush();
			
		Disciplina disci = new Disciplina(nome,dia_da_semana,horario,professor,obs,periodo);
		if(fachada.cadastrarDisciplina(user,disci)){
			System.out.println("Cadastro com sucesso!");
		}
		else{
			System.out.println("Erro!");
		}
	}
	public void menuAtividades(Usuario user){
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
			switch(resposta){
				case 1:{
					this.cadastroDisciplina(user);
					break;
				}
				case 2:{
					this.buscarDisciplina(user);
					break;
				}
				case 3:{
					this.showDisciplinas(user);
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
	public void buscarDisciplina(Usuario user){
		System.out.print("Nome: ");
		String nome=scanner.nextLine();
		Disciplina disci=fachada.buscarDisciplina(user,nome);
		if(disci==null){
			System.out.println("Erro ao Buscar");
		}
		else
		{
			System.out.println(disci);
			System.out.println("\n[1]Alterar\n[2]Deletar\n[3]Voltar");
			int resp=scanner.nextInt();
			switch(resp){
			case 1:{
				this.alterarDisciplina(user,disci.getNome());
				break;
			}
			case 2:{
				this.deletarDisciplina(user,disci.getNome());
				break;
			}
			case 3:{
				
			}
			}
		}
	}
	public void alterarDisciplina(Usuario user,String nomeOriginal){
		System.out.println("=====NovosDados=====");
		String nome;
		int dia_da_semana = 0;
		Horario horario = new Horario();
		String professor;
		String obs;
		String periodo = null;
	
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.next();
			
		System.out.println("Dia da semana:");
		dia_da_semana = scanner.nextInt();
		System.out.flush();
			
		System.out.println("Horario:");
		horario.setHora(scanner.nextInt());	
		System.out.flush();
		System.out.print(":");
		System.out.flush();
		horario.setMinuto(scanner.nextInt());
			
		System.out.println("Professor:");
		professor=scanner.next();
		System.out.flush();
			
		System.out.println("Observação:");
		obs=scanner.next();
			
		System.out.println("Periodo: ");
		obs=scanner.next();
		System.out.flush();
			
		Disciplina disci = new Disciplina(nome,dia_da_semana,horario,professor,obs,periodo);
		if(fachada.alterarDisciplina(user,disci,nomeOriginal)){
			System.out.println("Alterado com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Alterar");
		}
	}
	public void deletarDisciplina(Usuario user, String nome){
		if(fachada.deletarDisciplina(user,nome)==true){
			System.out.println("Deletado Com Sucesso");
		}
		else
		{
			System.out.println("Erro ao deletar");
		}
	}
	
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
			switch(resposta){
				case 1:{
					this.cadastroTask();
					break;
				}
				case 2:{
					this.buscarTask();
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
	public void cadastroTask(){
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
		if(fachada.cadastrarTask(novaTask)){
			System.out.println("Inserido com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Inserir");
		}
	}
	public void buscarTask(){
		System.out.print("Nome: ");
		String nome=scanner.nextLine();
		Task task=fachada.buscarTask(nome);
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
		String nome=scanner.nextLine();
		System.out.print("Tipo: ");
		String tipo=scanner.nextLine();
		System.out.print("Disciplina: ");//TODO precisa modificar o tipo de disciplina de task, pra o tipo DIsciplina
		String disciplina=scanner.nextLine();
		System.out.print("Data: ");
		String data=scanner.nextLine();
		System.out.print("Descricao: ");
		String descricao=scanner.nextLine();
		Task novaTask = new Task(data,nome,descricao,tipo,disciplina);
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