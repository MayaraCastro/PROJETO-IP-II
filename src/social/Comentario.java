package social;

import java.util.Calendar;
import java.util.Date;

public class Comentario {
	private String comentario;
	private Comentario[] coment;
	private Usuario autor;
	private Date data;
	private int like;
	private int dislike;
	Calendar c;

	  
	public Comentario(String comentario, Usuario autor){
		this.comentario=comentario;
		this.autor=autor;
		c = Calendar.getInstance();
		this.data=c.getTime();
		this.like=0;
		this.dislike=0;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	public int getDislike() {
		return dislike;
	}


	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Comentario[] getComent() {
		return coment;
	}


	public void setComent(Comentario[] coment) {
		this.coment = coment;
	}


	public Usuario getAutor() {
		return autor;
	}


	public void setAutor(Usuario autor) {
		this.autor = autor;
	}


	public Date getData() {
		return data;
	}	
	
	public String toString(){
		return "Comentario: [Autor: "+this.autor+", Data: "+this.data+", "
				+ "Comentario{ "+this.comentario+"}]";
		
	}
}
