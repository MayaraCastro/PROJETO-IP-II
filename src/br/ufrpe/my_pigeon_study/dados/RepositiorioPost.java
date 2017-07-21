package br.ufrpe.my_pigeon_study.dados;
import java.util.ArrayList;
import br.ufrpe.my_pigeon_study.negocio.beans.*;

public class RepositiorioPost implements Repositorio{
	private ArrayList<Post> comments;
	
	private static RepositiorioPost instancia;

	public RepositiorioPost() {
		this.comments = new ArrayList<Post>();
	}
	public static RepositiorioPost getInstancia(){
		if(instancia==null){
			instancia=new RepositiorioPost();
		}
		return(instancia);
	}
	

	public ArrayList<Post> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Post> comments) {
		this.comments = comments;
	}
	@Override
	public boolean inserir(Object insert) {
		Post coment=(Post) insert;
		if(coment!=null){
			if(this.buscar(coment.getTitulo())==null){
				this.comments.add(coment);
				return(true);
			}			
		}
		return(false);
	}

	@Override
	public Object buscar(String shearch) {

		for(Post srch:this.comments){
			if(srch!=null&&srch.getTitulo().equals(shearch)){
				return(srch);
			}
		}
		return(null);
	}

	@Override
	public boolean remover(String delete) {

		if(buscar(delete)==null){
			return(false);
		}
		boolean entra=false;
		for(int i=0; i < this.comments.size(); i++){
			if(this.comments.get(i) != null){
				if(entra){
					this.comments.set(i-1, this.comments.get(i));
					this.comments.set(i, null);
				}
				else
				{
					if(this.comments.get(i).getTitulo().equals(delete)){
						entra=true;
						this.comments.set(i, null);
					}
				}
			}
		}
		return(entra);
	}

	@Override
	public boolean alterar(Object novoObject) {

		Comentarios coment=(Comentarios) novoObject;
		if(novoObject!=null){
			for(int i=0; i < this.comments.size(); i++){
				if(this.comments.get(i) != null && this.comments.get(i).getTitulo().equals(coment.getTitulo())){
					this.comments.set(i, coment);
					return(true);
				}
			}
		}
		return(false);
	}
	
}
