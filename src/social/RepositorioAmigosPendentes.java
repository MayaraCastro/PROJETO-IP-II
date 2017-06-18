package repositorios;

import br.Giuseppe.Luna.beans.Amigos;

public class RepositorioAmigosPendentes {
	private Amigos[] amizadePendente;
	private int proxima;
	private int totAmigosPendentes;
	
	public RepositorioAmigosPendentes(){
		this.totAmigosPendentes=1000;
		this.amizadePendente= new Amigos[this.totAmigosPendentes];
		this.proxima=0;
				
	}

	public Amigos[] getamizadePendente() {
		return this.amizadePendente;
	}

	public int getProxima() {
		return this.proxima;
	}

	public int totAmigosPendentes() {
		return this.totAmigosPendentes;
	}
	public Amigos buscar(Amigos amigo){
		for(int i=0;i<this.proxima;i++){
			if(amizadePendente[i].getEmail().equals(amigo.getEmail())){
				return amizadePendente[i];
			}
		}
		return null;
	}
	
	public boolean inserir(Amigos amigo){
		
		if(amigo!=null & this.buscar(amigo)==null & this.proxima<=this.totAmigosPendentes){
			amigo.setAmizade(2);
			this.amizadePendente[this.proxima]=amigo;
			this.proxima++;
			return true;
		}
		return false;
		
	}
	private boolean remocao(Amigos amigo){
		if(amigo!=null){
			for(int i=0; i<this.proxima;i++){
				if(this.amizadePendente[i].equals(amigo)){//TODO modificar todos os if do remoção. para  amizadePendente[i].getEmail().equals(amigo.getEmail())
					for(int j=i;j<this.proxima;j++){
						this.amizadePendente[j]=this.amizadePendente[j+1];
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
			if(amizadePendente[i].getEmail().equals(amigo.getEmail())){
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
			amizadePendente[local]=newamigo;
			return true;
		}
		return false;
	}
}
