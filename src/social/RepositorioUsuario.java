package repositorios;

import br.Giuseppe.Luna.beans.Usuario;

public class RepositorioUsuario {
	private Usuario[] users;
	private int proxima;
	private int totUser;
	
	public RepositorioUsuario(){
		this.totUser=1000;
		this.users= new Usuario[this.totUser];
		this.proxima=0;
				
	}

	public Usuario[] getUsers() {
		return this.users;
	}

	public int getProxima() {
		return this.proxima;
	}

	public int gettotUser() {
		return this.totUser;
	}
	public Usuario buscar(String email){
		for(int i=0;i<this.proxima;i++){
			if(users[i].getEmail().equals(email)){
				return users[i];
			}
		}
		return null;
	}
	
	public boolean inserir(Usuario user){
		
		if(user!=null & this.buscar(user.getEmail())==null & this.proxima<=this.totUser){
			this.users[this.proxima]=user;
			this.proxima++;
			return true;
		}
		return false;
		
	}
	private boolean remocao(Usuario user){
		if(user!=null){
			for(int i=0; i<this.proxima;i++){
				if(this.users[i].equals(user)){
					for(int j=i;j<this.proxima;j++){
						this.users[j]=this.users[j+1];
					}
					this.proxima--;
					return true;
				}
			}
		}
		return false;
	}
	public boolean remover(String email){
		Usuario busca=this.buscar(email);
		if(email!=null & busca!=null & this.remocao(busca)==true){
			return true;
		}
		
		return false;
	}
	private int localizacao(Usuario user){
		for(int i=0;i<this.proxima;i++){
			if(users[i].getEmail().equals(user.getEmail())){
				return i;
			}
		}
		return -1;
	}
	public boolean alterar(Usuario newuser){
		Usuario busca=this.buscar(newuser.getEmail());
		int local=this.localizacao(newuser);
		if(newuser!=null & busca!=null & local!=-1){
			users[local]=newuser;
			return true;
		}
		return false;
	}
	
	
}
