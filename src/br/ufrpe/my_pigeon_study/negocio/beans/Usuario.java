package br.ufrpe.my_pigeon_study.negocio.beans;

import java.util.ArrayList;

public class Usuario extends Pessoa{
	private String usuario;
	private String senha;
	private String email;
	private ArrayList<Atividade> atividades;
	private ArrayList<Task> tasks;
	private ArrayList<Amigo> amigos;
	private ArrayList<Amigo> amigosPendentes;
	private ArrayList<Depoimento> depoimentos;
	private ArrayList<Comunidade> comunidade;
	private ArrayList<Post> postagem;
	
	public Usuario(){

	}
	public Usuario(String usuario, String senha){
		this.usuario=usuario;
		this.senha=senha;
	}

	public Usuario(String nome, String usuario, String senha, int sexo, String email, Data dataNasc) {
		super(nome,sexo,dataNasc);
		
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
		
		this.atividades = new ArrayList<Atividade>();
		this.tasks = new ArrayList<Task>();
		this.amigos= new ArrayList<Amigo>();
		this.amigosPendentes= new ArrayList<Amigo>();

	}
	
	//METODO PARA ADICIONAR AMIGO
	public boolean addAmigo(Amigo amg){
		if(!this.amigos.contains(amg)){
			if(this.amigosPendentes.contains(amg) && amg.getConvite() == 1){ 
				this.amigos.add(amg);
				this.amigosPendentes.remove(amg);	
			}
			else{
				this.amigosPendentes.add(amg);
			}
			return true;
		}
		return false;
	}
	public boolean delAmigo(Amigo amg){
		if(!this.amigos.contains(amg)){
			if(this.amigosPendentes.contains(amg)){
				this.amigosPendentes.remove(amg);
				return true;	
			}
		}
		else{
			this.amigos.remove(amg);
			return(true);
		}
		return false;
	}
	
	public boolean contemAmigo(Amigo amg){
		if(this.amigos.contains(amg)){
				return true;		
		}
		return false;
	}
	//MANUPULAÇÃO da Comunidade
	public boolean addComunidade(Comunidade cmd){
		if(!this.comunidade.contains(cmd)){
			this.comunidade.add(cmd);
			return true;
		}
		return false;
	}
	public boolean delComunidade(Comunidade cmd){
		if(this.comunidade.contains(cmd)){
			this.comunidade.remove(cmd);
			return(true);
		}
		return false;
	}
	//MANIPULAÇÃO DE POST
	public boolean addpOST(Post post){
		if(!this.postagem.contains(post)){
			this.postagem.add(post);
			return true;
		}
		return false;
	}
	public boolean delPost(Post post){
		if(!this.postagem.contains(post)){
			this.postagem.remove(post);
			return(true);
		}
		return false;
	}
	
	//GETTERS AND SETTERS
	public ArrayList<Depoimento> getDepoimentos() {
		return depoimentos;
	}
	public void setDepoimentos(ArrayList<Depoimento> depoimentos) {
		this.depoimentos = depoimentos;
	}
	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;

	}

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public ArrayList<Amigo> getAmigos() {
		return amigos;
	}
	public void setAmigos(ArrayList<Amigo> amigos) {
		this.amigos = amigos;
	}
	public ArrayList<Amigo> getAmigosPendentes() {
		return amigosPendentes;
	}
	public void setAmigosPendentes(ArrayList<Amigo> amigosPendentes) {
		this.amigosPendentes = amigosPendentes;
	}
	public ArrayList<Comunidade> getComunidade() {
		return comunidade;
	}

	public void setComunidade(ArrayList<Comunidade> comunidade) {
		this.comunidade = comunidade;
	}
	
	public ArrayList<Post> getPostagem() {
		return postagem;
	}

	public void setPostagem(ArrayList<Post> postagem) {
		this.postagem = postagem;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + this.getNome() + ", dataNasc=" + this.getDataNasc() + ", usuario=" + usuario + ", senha=" + senha
				+ ", sexo=" + this.getSexo() + ", email=" + email + ", atividades=" + atividades.toString() + ", tasks="
				+ tasks.toString() + "]";
	}


	
}
