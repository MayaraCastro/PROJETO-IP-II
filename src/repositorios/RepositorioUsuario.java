package repositorios;
import br.ufrpe.negocio.beans.*;
public class RepositorioUsuario {
	private Usuario[] usuarios;
	private int quantUsuarios;
	
	//CONSTRUTOR
	public RepositorioUsuario(){
		this.usuarios=new Usuario[100];
		this.quantUsuarios=0;
	}
	
	//METODOS GET
	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public int getQuantUsuarios() {
		return quantUsuarios;
	}
	
	//OUTROS METODOS
	public boolean inserir(Usuario user){
		if(user!=null&&this.quantUsuarios<100){
			if(this.buscar(user.getUsuario())==null){
				this.usuarios[this.quantUsuarios]=user;
				this.quantUsuarios++;
				return(true);
			}			
		}
		return(false);
	}
	
	public Usuario buscar(String usuario){
		for(Usuario user:this.usuarios){
			if(user!=null&&user.getUsuario().equals(usuario)){
				return(user);
			}
		}
		return(null);
	}
	
	public boolean remover(String user){
		if(buscar(user)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0;i<100;i++){
			if(this.usuarios[i]!=null){
				if(entra){
					this.usuarios[i-1]=this.usuarios[i];
					this.usuarios[i]=null;
				}
				else
				{
					if(this.usuarios[i].getUsuario().equals(user)){
						entra=true;
						this.quantUsuarios--;
						if(this.quantUsuarios<0){
							this.quantUsuarios=0;
						}
					}
				}
			}
		}
		return(true);
	}

	public boolean alterar(Usuario novoUser){
		if(novoUser!=null){
			for(int i=0;i<100;i++){
				if(this.usuarios[i]!=null&&this.usuarios[i].getUsuario().equals(novoUser.getUsuario())){
					this.usuarios[i]=novoUser;
					return(true);
				}
			}
		}
		return(false);
	}

}
