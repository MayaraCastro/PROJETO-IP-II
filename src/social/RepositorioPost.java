package social;

public class RepositorioPost {
	private Post[] postagem;
	private int proxima;
	private int totPost;
	
	public RepositorioPost(){
		this.totPost=1000;
		this.postagem= new Post[this.totPost];
		this.proxima=0;
				
	}

	public Post getPostagem(int valor) {//obter a posição da postagem
		return this.postagem[valor];
	}

	public int getProxima() {
		return this.proxima;
	}

	public int gettotPost() {
		return this.totPost;
	}
	public Post buscar(Usuario usuario){
		for(int i=0;i<this.proxima;i++){
			if(postagem[i].getAutor().equals(usuario)){
				return postagem[i];
			}
		}
		return null;
	}
	
	public boolean inserir(Post postag){
		
		if(postag!=null & this.buscar(postag.getAutor())==null & this.proxima<=this.totPost){
			this.postagem[this.proxima]=postag;
			this.proxima++;
			return true;
		}
		return false;
		
	}
	private boolean remocao(Post postag){
		if(postag!=null){
			for(int i=0; i<this.proxima;i++){
				if(this.postagem[i].equals(postag)){
					for(int j=i;j<this.proxima;j++){
						this.postagem[j]=this.postagem[j+1];
					}
					this.proxima--;
					return true;
				}
			}
		}
		return false;
	}
	public boolean remover(Post postag){
		Post busca=this.buscar(postag.getAutor());
		if(postag!=null & busca!=null & this.remocao(busca)==true){
			return true;
		}
		
		return false;
	}
	private int localizacao(Post postag){
		for(int i=0;i<this.proxima;i++){
			if(postagem[i].getAutor().equals(postag.getAutor())){
				return i;
			}
		}
		return -1;
	}
	public boolean alterar(Post newpost){
		Post busca=this.buscar(newpost.getAutor());
		int local=this.localizacao(newpost);
		if(newpost!=null & busca!=null & local!=-1){
			postagem[local]=newpost;
			return true;
		}
		return false;
	}
}
