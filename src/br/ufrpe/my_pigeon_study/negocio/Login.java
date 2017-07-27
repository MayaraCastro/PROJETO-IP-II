package br.ufrpe.my_pigeon_study.negocio;
import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class Login {
	private RepositorioUsuario rep;
	public Login(){
		this.rep= RepositorioUsuario.getInstancia();
	}
	public Usuario logar(Usuario user) throws InformacaoInvalidaException{
			if(user==null){
				throw new InformacaoInvalidaException();
			}
			Usuario usuario= new Usuario();
			usuario=this.rep.buscar(user.getUsuario());	
			if(usuario!=null){
				if(usuario.getSenha().equals(user.getSenha())){
					return(usuario);
				}
			}
			throw new InformacaoInvalidaException();
	}
	

}
