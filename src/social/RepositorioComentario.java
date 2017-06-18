package social;

import br.ufrpe.negocio.beans.Usuario;

public class RepositorioComentario {
	private Comentario[] comments;
	private int proxima;
	private int totUser;
	
	public RepositorioComentario(){
		this.totUser=1000;
		this.comments= new Comentario[this.totUser];
		this.proxima=0;
				
	}

	public Comentario[] getComments() {
		return this.comments;
	}

	public int getProxima() {
		return this.proxima;
	}

	public int gettotUser() {
		return this.totUser;
	}
	public Comentario buscar(Usuario usuario){
		for(int i=0;i<this.proxima;i++){
			if(comments[i].getAutor().equals(usuario)){
				return comments[i];
			}
		}
		return null;
	}
	
	public boolean inserir(Post posgem){
		
		if(posgem!=null & this.buscar(posgem.getAutor())==null & this.proxima<=this.totUser){
			this.comments[this.proxima]=posgem;
			this.proxima++;
			return true;
		}
		return false;
		
	}
	private boolean remocao(Comentario comment){
		if(comment!=null){
			for(int i=0; i<this.proxima;i++){
				if(this.comments[i].equals(comment)){
					for(int j=i;j<this.proxima;j++){
						this.comments[j]=this.comments[j+1];
					}
					this.proxima--;
					return true;
				}
			}
		}
		return false;
	}
	public boolean remover(Comentario comment){
		Comentario busca=this.buscar(comment.getAutor());
		if(comment!=null & busca!=null & this.remocao(busca)==true){
			return true;
		}
		
		return false;
	}
	private int localizacao(Comentario comment){
		for(int i=0;i<this.proxima;i++){
			if(comments[i].getAutor().equals(comment.getAutor())){
				return i;
			}
		}
		return -1;
	}
	public boolean alterar(Comentario newcomments){
		Comentario busca=this.buscar(newcomments.getAutor());
		int local=this.localizacao(newcomments);
		if(newcomments!=null & busca!=null & local!=-1){
			comments[local]=newcomments;
			return true;
		}
		return false;
	}
	
}
