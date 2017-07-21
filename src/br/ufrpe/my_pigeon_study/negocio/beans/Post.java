package br.ufrpe.my_pigeon_study.negocio.beans;

public class Post {
	private String Titulo;
	private String post;
	private Comentarios comments;
	private Usuario user;
	
	
	public Post(Usuario user) {
		this.post = null;
		this.comments=null;
		this.user=user;
		this.Titulo=null;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String postagem) {
		this.post = postagem;
	}

	public Comentarios getComments() {
		return comments;
	}

	public void setComments(Comentarios comments) {
		this.comments = comments;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	@Override
	public String toString() {
		return "Post [Titulo=" + Titulo + ", user=" + user + "]";
	}
	
}
