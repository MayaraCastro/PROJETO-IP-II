package br.Giuseppe.Luna.beans;

import repositorios.*;
public class Usuario {
	
	private String password;
	private String email;
	private String telefone;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String sexo;
	private RepositorioAmigos repAmigos;
	private RepositorioAmigosPendentes repAmigosPendentes;
	private RepositorioPost repPost;
	
	public Usuario(String email,String password ,String telefone, String nome,
	String sobrenome, String dataNascimento, String sexo)
	{
		//atributos basicos do usuario inicializados
		this.email=email;
		this.password=password;
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.dataNascimento=dataNascimento;
		this.sexo=sexo;
		this.telefone=telefone;
		
		//repositorios de amigos inicializados
		
		this.repAmigos= new RepositorioAmigos();
		this.repAmigosPendentes= new RepositorioAmigosPendentes();
		
		//repositorio de posts inicializados
		this.repPost= new RepositorioPost();
		
		
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public RepositorioPost getRepPost() {
		return repPost;
	}
	
	public RepositorioAmigos getRepAmigos() {
		return repAmigos;
	}

	public RepositorioAmigosPendentes getRepAmigosPendentes() {
		return repAmigosPendentes;
	}

	public String toString(){
		return "USUARIO:[ NOME: "+this.nome+", SOBRENOME: "+this.sobrenome+"]"; 
	}
	
}
