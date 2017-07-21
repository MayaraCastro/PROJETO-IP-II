package br.ufrpe.my_pigeon_study.negocio.beans;
import java.util.ArrayList;

public class Forum {
	private String PrincipalComent;
	private ArrayList<Post> coments;
	public Forum(){
		coments= new ArrayList<Post>();
		
	}
	public ArrayList<Post> getComents() {
		return coments;
	}
	public void setComents(ArrayList<Post> coments) {
		this.coments = coments;
	}
	public String getPrincipalComent() {
		return PrincipalComent;
	}
	public void setPrincipalComent(String principalComent) {
		PrincipalComent = principalComent;
	}
	public boolean addComentario(Post postagem){
		if(!this.coments.contains(postagem)){
				this.coments.add(postagem);
			return true;
		}
		return false;
	}
	public boolean delAmigo(Post postagem){
		if(!this.coments.contains(postagem)){
			this.coments.remove(postagem);
			return(true);
		}
		return false;
	}
	
}
