package br.ufrpe.my_pigeon_study.negocio;
import java.io.IOException;

import Exceptions.InformacaoInvalidaException;
import br.ufrpe.my_pigeon_study.dados.ManipuladorArquivo;
import br.ufrpe.my_pigeon_study.dados.RepositorioUsuario;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class Login {
	private RepositorioUsuario rep;
	private final  String PATH="file.dat";
	public Login(){
		this.iniciar();
	}
	//////////salvar e iniciar arquivos//////////
	public void iniciar(){
		try {
			if(ManipuladorArquivo.leitor(PATH) != null) {
				this.rep=(RepositorioUsuario) ManipuladorArquivo.leitor(PATH);

			}
			else {
				this.rep = RepositorioUsuario.getInstancia();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void salve() {
		try {
			ManipuladorArquivo.escritor(PATH, this.rep);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	////////////////////////////////////////////
	public Usuario logar(Usuario user) throws InformacaoInvalidaException{
		this.iniciar();
			if(user == null){
				throw new InformacaoInvalidaException();
			}
			Usuario usuario;
			usuario = (Usuario) this.rep.buscar(user.getUsuario());	
			if(usuario!=null){
				if(usuario.getSenha().equals(user.getSenha())){
					return(usuario);
				}
			}
			throw new InformacaoInvalidaException();
	}
	

}
