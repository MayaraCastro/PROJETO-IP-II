package br.ufrpe.my_pigeon_study.negocio.beans;

public class Pessoa {
	private String nome;
	private Data dataNasc;
	private int sexo;//1-feminino, 2-masculino e 3-outro
	
	//CONSTRUTOR
	public Pessoa(){
		
	}
	public Pessoa(String nome,  int sexo, Data dataNasc) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
	}
	//GETTERS AND SETTERS
	
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
	
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;		
		return true;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Amigo [nome: " + nome + 
				"\nSexo: " + sexo;}

}
