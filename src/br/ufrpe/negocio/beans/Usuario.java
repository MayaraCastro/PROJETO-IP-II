package br.ufrpe.negocio.beans;

import java.util.Arrays;

public class Usuario {
	private String nome;
	private Data dataNasc;
	private String usuario;
	private String senha;
	private int sexo;//1-feminino, 2-masculino e 3-outro
	private String email;
	private Disciplina[] disciplina;
	private Task lembrar;
	
	
	public Usuario() {
		super();
	}



	public Usuario(String nome, Data dataNasc, String usuario, String senha, int sexo, String email,
			Task lembrar) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.senha = senha;
		this.sexo = sexo;
		this.email = email;
		this.lembrar = lembrar;
	}


	
	public Usuario(String nome, Data dataNasc, String usuario, String senha, int sexo, String email) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.senha = senha;
		this.sexo = sexo;
		this.email = email;
	}



	public Disciplina[] getDisciplina() {
		return disciplina;
	}



	public void setDisciplina(Disciplina[] disciplina) {
		this.disciplina = disciplina;
	}



	public Task getLembrar() {
		return lembrar;
	}


	public void setLembrar(Task lembrar) {
		this.lembrar = lembrar;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Data getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(Data dataNasc) {
		this.dataNasc = dataNasc;
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


	public int getSexo() {
		return sexo;
	}


	public void setSexo(int sexo) {
		this.sexo = sexo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	};
	
	
	public void addDisc(Disciplina[] disciplina){
		if(disciplina != null){
			this.setDisciplina(disciplina);
		}
		else{
			System.out.println("Disciplina não existe!");
		}
		
	}
	
	public void removerDisc(){
		this.setDisciplina(null);
	}
	
	/*public boolean addUsuario(){
		//editar
	}
	
	public boolean removerUsuario(){
		//editar
	}*/
	
	public void addExame(){
		//editar
	}
	
	public void removerExame(){
		//editar
	}



	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", dataNasc=" + dataNasc + ", usuario=" + usuario + ", senha=" + senha
				+ ", sexo=" + sexo + ", email=" + email + ", disciplina=" + Arrays.toString(disciplina) + "]";
	}


	
}
