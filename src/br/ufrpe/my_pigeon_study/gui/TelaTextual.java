package br.ufrpe.my_pigeon_study.gui;
import br.ufrpe.my_pigeon_study.negocio.beans.*;
import br.ufrpe.my_pigeon_study.negocio.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.InternationalFormatter;

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
		
		Usuario user = new Usuario(nome,usuario,senha,sexo,email,dataNasc);
		try{
			fachada.cadastrarUsuario(user);
		}catch(InformacaoEmBrancoException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch(InformacaoInvalidaException e1){
			
			System.out.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, e1.getMessage().toString() );
		}
		
		/*if(){
			System.out.println("Cadastro com sucesso!");
		}
		else{
			System.out.println("Erro ao efetuar cadastro!");
		}*/
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
		
		Usuario user = new Usuario(nome,usuario,senha,sexo,email,dataNasc);
		try{
			fachada.alterarUsuario(user);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		/*if(){
			System.out.println("Altera�ao com sucesso!");
		}
		else{
			System.out.println("Erro ao efetuar altera�ao!");
		}*/
	}
	public void telaInicial(Usuario user){//TODO fazer o comunidade
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
					this.menuAtividades(user);
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
				break;
			}
		}
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
			System.out.println(msg);
		}
		
		
	}
	
//ATIVIDADE
	//TELAS Atividades
	public void cadastroAtividade(Usuario user){
		String nome=new String();
		int dia_da_semana = 0;
		Horario horario = new Horario();
		String obs= new String();
	
		System.out.println("\tCADASTRAR DISCIPLINA");
		scanner.nextLine();
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.nextLine();
			
		System.out.println("Dia da semana:");
		dia_da_semana = scanner.nextInt();
		System.out.flush();
			
		System.out.println("Horario:");
		horario.setHora(scanner.nextInt());	
		System.out.flush();
		System.out.print(":");
		System.out.flush();
		horario.setMinuto(scanner.nextInt());
		
		scanner.nextLine();
		System.out.println("Observa��o:");
		obs=scanner.nextLine();
		System.out.flush();

		Atividade atividade = new Atividade(nome,dia_da_semana,horario,obs);
		try{
			fachada.cadastrarAtividade(user, atividade);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		/*if(){
			System.out.println("Cadastro com sucesso!");
		}
		else{
			System.out.println("Erro!");
		}*/
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
					this.cadastroAtividade(user);
					break;
				}
				case 2:{
					this.buscarAtividade(user);
					break;
				}
				case 3:{
					this.showAtividades(user);
					break;
				}
				case 4:{
					saida=true;
					break;
				}
				default:{
					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				}
			}
		}
	}	
	public void buscarAtividade(Usuario user){
		System.out.print("Nome: ");
		String nome=scanner.next();
		System.out.flush();
		Atividade ativi=fachada.buscarAtividade(user,nome);
		if(ativi==null){
			System.out.println("Erro ao Buscar");
		}
		else
		{
			System.out.println(ativi);
			System.out.println("\n[1]Alterar\n[2]Deletar\n[3]Voltar");
			int resp=scanner.nextInt();
			switch(resp){
			case 1:{
				this.alterarAtividade(user, ativi);
				break;
			}
			case 2:{
				this.deletarDisciplina(user,ativi.getNome());
				break;
			}
			case 3:{
				
			}
			}
		}
	}
	public void alterarAtividade(Usuario user,Atividade nomeOriginal){
		System.out.println("=====NovosDados=====");
		String nome;
		int dia_da_semana = 0;
		Horario horario = new Horario();
		String obs;
	
		System.out.println("Nome:");
		System.out.flush();
		nome=scanner.nextLine();
			
		System.out.println("Dia da semana:");
		dia_da_semana = scanner.nextInt();
		System.out.flush();
			
		System.out.println("Horario:");
		horario.setHora(scanner.nextInt());	
		System.out.flush();
		System.out.print(":");
		System.out.flush();
		horario.setMinuto(scanner.nextInt());
		
		System.out.println("Observa��o:");
		obs=scanner.nextLine();
			
			
		Atividade novaAtivi = new Atividade(nome,dia_da_semana,horario,obs);
		
		try{
			fachada.alterarAtividade(user,novaAtivi,nomeOriginal);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		/*if(){
		System.out.println("Alterado com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Alterar");
		}*/
	}
	public void deletarDisciplina(Usuario user, String nome){
		if(fachada.deletarAtividade(user, nome) == true){
			System.out.println("Deletado Com Sucesso");
		}
		else
		{
			System.out.println("Erro ao deletar");
		}
	}	
	
	public void showAtividades(Usuario user){
		String mensagem = fachada.showAtividades(user);
		System.out.println("====ATIVIDADES====");
		if(mensagem == null){
			System.out.println("Voce nao tem atividades");
		}else{
			System.out.println(mensagem);
		}
	}

	//TELAS TASK
	
	public void menuTask(Usuario user){
		boolean saida=false;
		while(!saida){
			System.out.println("=====TASK=====");
			System.out.println("[1]Inserir");
			System.out.println("[2]Buscar");
			System.out.println("[3]Listar");
			System.out.println("[4]voltar");
			System.out.println("=====TASK=====");
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
					break;
				}
				default:{
					System.out.println("ERROR! DIGITE UM NUMERO VALIDO");
				}
			}
		}
	}
	public void showTasks(Usuario user){	
		String msg=fachada.showTask(user);
		System.out.println("====ATIVIDADES====");
		if(msg==null){
			System.out.println("Voce nao tem tasks");
		}else{
			System.out.println(msg);
		}
	}	
	public void cadastroTask(Usuario user){
		System.out.print("Nome: ");
		String nome=scanner.nextLine();
		System.out.print("Tipo: ");
		int tipo=scanner.nextInt();
		
		scanner.nextLine();
		System.out.print("Data: ");
		Data data=new Data();
		System.out.println("DIA:");
		data.setDia(scanner.nextInt());
		System.out.println("MES:");
		data.setMes(scanner.nextInt());
		System.out.println("ANO:");
		data.setAno(scanner.nextInt());
		
	    System.out.println("Dia da semana:");
	    int dia_da_semana=scanner.nextInt();
	    System.out.println("Horario: ");
	    Horario horario= new Horario();
	    System.out.println("HORA");
	    horario.setHora(scanner.nextInt());
	    System.out.println("MUNUTO:");
	    horario.setMinuto(scanner.nextInt());
	    System.out.println("OBS: ");
	    String obs= scanner.nextLine();
	 
	    
		scanner.nextLine();
		System.out.print("Descricao: ");
		String descricao=scanner.nextLine();

		Task novaTask = new Task(data, nome, descricao, tipo, dia_da_semana, horario, obs );
		try{
			fachada.cadastrarTask(user,novaTask);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		/*if(){
			System.out.println("Inserido com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Inserir");
		}*/
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
				this.alterarTask(user,task);
				break;
			}
			case 2:{
				this.deletarTask(user,task.getNome());
				break;
			}
			case 3:{
				
			}
			}
		}
	}
	public void alterarTask(Usuario user,Task Original){
		System.out.println("=====NovosDados=====");
		System.out.print("Nome: ");
		scanner.nextLine();
		String nome=scanner.nextLine();
		
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
		
	    System.out.println("Dia da semana:");
	    int dia_da_semana=scanner.nextInt();
	    System.out.println("Horario: ");
	    Horario horario= new Horario();
	    System.out.println("HORA");
	    horario.setHora(scanner.nextInt());
	    System.out.println("MUNUTO:");
	    horario.setMinuto(scanner.nextInt());
	    System.out.println("OBS: ");
	    String obs= scanner.nextLine();
	    
		scanner.nextLine();
		System.out.print("Descricao: ");
		String descricao=scanner.nextLine();
		Task novaTask = new Task(data, nome, descricao, tipo, dia_da_semana, horario, obs);
		try{
			fachada.alterarTask(user,novaTask, Original);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		/*
		if(){
			System.out.println("Alterado com Sucesso");
		}
		else
		{
			System.out.println("Erro ao Alterar");
		}*/
	}
	public void deletarTask(Usuario user,String nome){
		if(fachada.deletarTask(user,nome)==true){
			System.out.println("Deletado Com Sucesso");
		}
		else
		{
			System.out.println("Erro ao deletar");
		}
	}
}