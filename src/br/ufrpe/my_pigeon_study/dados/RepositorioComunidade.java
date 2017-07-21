package br.ufrpe.my_pigeon_study.dados;
import java.util.ArrayList;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class RepositorioComunidade implements Repositorio{
	private ArrayList<Comunidade> comunidade;
	
	private static RepositorioComunidade instancia;
	
	//CONSTRUTOR
	public RepositorioComunidade(){
		this.comunidade=new ArrayList<Comunidade>();
	}
	public static RepositorioComunidade getInstancia(){
		if(instancia==null){
			instancia=new RepositorioComunidade();
		}
		return(instancia);
	}
	
	//METODOS GET
	public ArrayList<Comunidade> getcomunidade() {
		return comunidade;
	}
	@Override 
	//OUTROS METODOS
	public boolean inserir(Object ccmd){
		Comunidade cmd=(Comunidade) ccmd;
		if(cmd!=null){
			if(this.buscar(cmd.getNome())==null){
				this.comunidade.add(cmd);
				return(true);
			}			
		}
		return(false);
	}
	@Override
	public Comunidade buscar(String cmundd){
		for(Comunidade cmd:this.comunidade){
			if(cmd!=null&&cmd.getNome().equals(cmundd)){
				return(cmd);
			}
		}
		return(null);
	}
	@Override
	public boolean remover(String cmd){
		if(buscar(cmd)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0; i < this.comunidade.size(); i++){
			if(this.comunidade.get(i) != null){
				if(entra){
					this.comunidade.set(i-1, this.comunidade.get(i));
					this.comunidade.set(i, null);
				}
				else
				{
					if(this.comunidade.get(i).getNome().equals(cmd)){
						entra=true;
						this.comunidade.set(i, null);
					}
				}
			}
		}
		return(entra);
	}
	@Override
	public boolean alterar(Object novocmd){
		Comunidade comum=(Comunidade) novocmd;
		if(novocmd!=null){
			for(int i=0; i < this.comunidade.size(); i++){
				if(this.comunidade.get(i) != null && this.comunidade.get(i).getNome().equals(comum.getUsuario())){
					this.comunidade.set(i, comum);
					return(true);
				}
			}
		}
		return(false);
	}

}
