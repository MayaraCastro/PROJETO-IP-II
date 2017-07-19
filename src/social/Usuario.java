package social;

import java.util.ArrayList;

public class Usuario {
	
	private String password;
	private String email;
	private String user;
	private String telefone;
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String sexo;
	private ArrayList<Amigo> amigos;
	private ArrayList<Amigo> amigosPendentes;
	private RepositorioPost repPost;
	
	public Usuario(String user, String email,String password ,String telefone, String nome,
	String sobrenome, String dataNascimento, String sexo)
	{	this.user = user;
		//atributos basicos do usuario inicializados
		this.email=email;
		this.password=password;
		this.nome=nome;
		this.sobrenome=sobrenome;
		this.dataNascimento=dataNascimento;
		this.sexo=sexo;
		this.telefone=telefone;
		
		//repositorios de amigos inicializados
		
		this.amigos= new ArrayList<Amigo>();
		this.amigosPendentes= new ArrayList<Amigo>();
		
		//repositorio de posts inicializados
		this.repPost= new RepositorioPost();
		
		
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean addAmigo(Amigo amg){
		if( amg != null && !this.amigos.contains(amg)){
			if(this.amigosPendentes.contains(amg)){
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
	
	public ArrayList<Amigo> getRepAmigos() {
		return amigos;
	}

	public ArrayList<Amigo> getRepAmigosPendentes() {
		return amigosPendentes;
	}

	public String toString(){
		return "USUARIO:[ NOME: "+this.nome+", SOBRENOME: "+this.sobrenome+"]"; 
	}
	
}
