package br.ufrpe.negocio.beans;

public class Exame {
	private double nota;
	private String descricao;
	private String data;
	private String hora;
	private Disciplina disciplina;
	
	//initializer
	public Exame(double nota,String descricao,String data,String hora,Disciplina disciplina){
		this.nota=nota;
		this.descricao=descricao;
		this.data=data;
		this.hora=hora;
		this.disciplina=disciplina;
	}
	public Exame(){
		
	}
	
	//getters
	public double getNota(){
		return this.nota;
	}
	public String getDescricao(){
		return this.descricao;
	}
	public String getData(){
		return this.data;
	}
	public String getHora(){
		return this.hora;
	}
	public Disciplina getDisciplina(){
		return this.disciplina;
	}
	
	//seters
	public void setNota(double nota){
		this.nota=nota;
	}
	
	public void setDescricao(String descricao){
		this.descricao=descricao;
	}
	
	public void setData(String data){
		this.data=data;
	}
	
	public void setHora(String hora){
		this.hora=hora;
	}
	
	public void setDisciplina(Disciplina disciplina){
		this.disciplina=disciplina;
	}
	
	//metodos
	public double contagemRegressiva(){
		return 1.123;
	}
	
	//toString
	public String toString(){
		return "Disciplina:"+this.disciplina.getNome()+"[Exame[Nota: "+this.nota+", Data: "+this.data+", Horario: "+this.hora+"]]";
	}
	

}
