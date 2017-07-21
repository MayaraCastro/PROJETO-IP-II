package br.ufrpe.my_pigeon_study.negocio.beans;

public class Amigo extends Pessoa{
	private int convite;
	private String email;
	private String usuario;
	private Data dataNasc;

	public Amigo(String usuario){
		this.usuario=usuario;
	}
	public Amigo(){
		
	}
	public Amigo(String nome, String usuario,  int sexo, String email, Data dataNasc){
		super(nome, sexo, dataNasc);
		this.email=email;
		this.usuario=usuario;
		this.dataNasc=dataNasc;
	}
	public Amigo(String nome, String usuario, int sexo, int convite, String email, Data dataNasc){
		super(nome, sexo, dataNasc);
		this.email=email;
		this.usuario=usuario;
		this.dataNasc=dataNasc;
	}
	public int getConvite() {
		return convite;
	}
	public void setConvite(int convite) {
		this.convite = convite;
	}
	public Data getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Data dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		return "Amigo [nome: " + this.getNome() + 
				"\nDataNasc: " + dataNasc +
				"\nUsuario: " + usuario + 
				"\nSexo: " + this.getSexo()+ 
				"\nEmail="
				+ email + "]";
	}
}
