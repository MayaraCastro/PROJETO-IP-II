package social;

import br.ufrpe.my_pigeon_study.negocio.beans.Data;

public class Amigo {
	private String nome;
	private Data dataNasc;
	private String usuario;
	private int sexo;//1-feminino, 2-masculino e 3-outro
	private String email;
	private int amizade;//if 0=nao amigo; if 1==amigo; if 2==pendentes
	
	public Amigo(String user){
		this.usuario=user;
	}

	public Amigo(String nome, Data dataNasc, String usuario, int sexo, String email, int amizade) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.usuario = usuario;
		this.sexo = sexo;
		this.email = email;
		this.amizade = amizade;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAmizade() {
		return this.amizade;
	}

	public void setAmizade(int amizade) {
		this.amizade = amizade;
	}

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

	public String toString(){
		return "Amigo[Nome: "+this.nome+", Email: "+this.email+"]";
	}
	
}
