package social;

public class Post {
	private String[] comentario;
	private int proximoComentario;
	private int tamComentario;
	private int like;
	private int dislike;
	private String post;
	private Usuario autor;

	public Post(String post, Usuario autor ){
		this.comentario=null;
		this.like=0;
		this.dislike=0;
		this.comentario=null;
		this.post=post;
		this.proximoComentario=0;
		this.tamComentario=100;
		this.autor=autor;
		
	}
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String[] getComentario() {
		return comentario;
	}

	public boolean setComentario(String comentario) {
		if(comentario!=null && this.proximoComentario<=this.tamComentario)
		{
			this.comentario[this.proximoComentario] = comentario;
			this.proximoComentario++;
			return true;
		}
		return false;
	}

	public int getLike() {
		return like;
	}

	public void setLike(boolean respo) {
		if(respo==true){
			this.like = 1;
		}
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(boolean respo) {
		if(respo==true){
			this.like = 1;
		}
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public String toString(){
		return "Post[ "+this.autor+", Postagem: "+this.post+"]";
	}
	
}
