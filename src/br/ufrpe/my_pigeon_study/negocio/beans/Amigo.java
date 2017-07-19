package br.ufrpe.my_pigeon_study.negocio.beans;

public class Amigo {
	private String nome;
	private Data dataNasc;
	private String usuario;
	private int sexo;//1-feminino, 2-masculino e 3-outro
	private String email;
	private int convite;//1 se o amigo q enviou o convite, 0 se o amigo q recebeu o convite 
	
	//CONSTRUTOR
	public Amigo(String user){
		this.usuario = user;
	}
	public Amigo(String nome, Data dataNasc, String usuario, int sexo, String email) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.sexo = sexo;
		this.email = email;
	}
	public Amigo(String nome, Data dataNasc, String usuario, int sexo, String email, int convite) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.sexo = sexo;
		this.email = email;
		this.convite=convite;
	}
	//GETTERS AND SETTERS
	
	public String getNome() {
		return nome;
	}
	public int getConvite() {
		return convite;
	}
	public void setConvite(int convite) {
		this.convite = convite;
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
		Amigo other = (Amigo) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	//TOSTRING
	@Override
	public String toString() {
		return "Amigo [nome: " + nome + 
				"\nDataNasc: " + dataNasc +
				"\nUsuario: " + usuario + 
				"\nSexo: " + sexo+ 
				"\nEmail="
				+ email + "]";
	}
}
