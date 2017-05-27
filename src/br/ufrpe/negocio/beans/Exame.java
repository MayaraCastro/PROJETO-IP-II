package br.ufrpe.negocio.beans;

import java.util.GregorianCalendar;

public class Exame {
	private double nota;
	private String descricao;
	private Data data;
	private Horario hora;
	private Disciplina disciplina;
	
	//initializer
	public Exame(double nota,String descricao,Data data,Horario hora,Disciplina disciplina){
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
	public Data getData(){
		return this.data;
	}
	public Horario getHora(){
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
	
	public void setData(Data data){
		this.data=data;
	}
	
	public void setHora(Horario hora){
		this.hora=hora;
	}
	
	public void setDisciplina(Disciplina disciplina){
		this.disciplina=disciplina;
	}
	
	//metodos
	public void contagemRegressiva(){
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
	}
	
	//toString
	public String toString(){
		return "Disciplina:"+this.disciplina.getNome()+"[Exame[Nota: "+this.nota+", Data: "+this.data+", Horario: "+this.hora+"]]";
	}
	

}
