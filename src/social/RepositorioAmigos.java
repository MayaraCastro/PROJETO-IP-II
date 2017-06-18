package repositorios;

import br.Giuseppe.Luna.beans.*;

public class RepositorioAmigos {
	private Amigos[] amizade;
	private int proxima;
	private int totAmigos;
	
	public RepositorioAmigos(){
		this.totAmigos=1000;
		this.amizade= new Amigos[this.totAmigos];
		this.proxima=0;
				
	}

	public Amigos[] getAmizade() {
		return this.amizade;
	}

	public int getProxima() {
		return this.proxima;
	}

	public int totAmigos() {
		return this.totAmigos;
	}
	public Amigos buscar(Amigos amigo){
		for(int i=0;i<this.proxima;i++){
			if(amizade[i].getEmail().equals(amigo.getEmail())){
				return amizade[i];
			}
		}
		return null;
	}
	
	public boolean inserir(Amigos amigo){
		
		if(amigo!=null & this.buscar(amigo)==null & this.proxima<=this.totAmigos){
			amigo.setAmizade(1);
			this.amizade[this.proxima]=amigo;
			this.proxima++;
			return true;
		}
		return false;
		
	}
	private boolean remocao(Amigos amigo){
		if(amigo!=null){
			for(int i=0; i<this.proxima;i++){
				if(this.amizade[i].equals(amigo)){//TODO modificar todos os if do remoção. para  amizade[i].getEmail().equals(amigo.getEmail())
					this.amizade[i].setAmizade(0);
					for(int j=i;j<this.proxima;j++){
						this.amizade[j]=this.amizade[j+1];
					}
					this.proxima--;
					return true;
				}
			}
		}
		return false;
	}
	public boolean remover(Amigos amigo){
		Amigos busca=this.buscar(amigo);
		if(amigo!=null & busca!=null & this.remocao(busca)==true){
			return true;
		}
		
		return false;
	}
	private int localizacao(Amigos amigo){
		for(int i=0;i<this.proxima;i++){
			if(amizade[i].getEmail().equals(amigo.getEmail())){
				return i;
			}
		}
		return -1;
	}
	public boolean alterar(Amigos newamigo){
		Amigos busca=this.buscar(newamigo);
		System.out.println(busca);
		int local=this.localizacao(newamigo);
		if(newamigo!=null & busca!=null & local!=-1){
			amizade[local]=newamigo;
			return true;
		}
		return false;
	}

}
