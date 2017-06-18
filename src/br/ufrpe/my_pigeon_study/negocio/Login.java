package br.ufrpe.my_pigeon_study.negocio;
import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class Login {
	private RepositorioUsuario rep;
	public Login(){
		this.rep= RepositorioUsuario.getInstancia();
	}
	public boolean logar(Usuario user){
			Usuario usuario= new Usuario();
			usuario=this.rep.buscar(user.getUsuario());	
			if(usuario!=null){
				if(usuario.getSenha().equals(user.getSenha())){
					return(true);
				}
			}
			return(false);
	}
	

}
