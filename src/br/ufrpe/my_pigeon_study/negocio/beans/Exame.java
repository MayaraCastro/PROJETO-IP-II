package br.ufrpe.my_pigeon_study.negocio.beans;

import java.util.GregorianCalendar;

public class Exame {
	private double nota;
	private String descricao;
	private Data data;
	private Horario hora;
	private Atividade atividade;
	
	//initializer
	public Exame(double nota,String descricao,Data data,Horario hora,Atividade atividade){
		this.nota=nota;
		this.descricao=descricao;
		this.data=data;
		this.hora=hora;
		this.atividade=atividade;
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
	public Atividade getAtividade(){
		return this.atividade;
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
	
	public void setDisciplina(Atividade atividade){
		this.atividade=atividade;
	}
	
	//metodos
	public String contagemRegressiva(){
		GregorianCalendar gc = new GregorianCalendar();
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = gc.get(GregorianCalendar.MONTH);
		int ano=gc.get(GregorianCalendar.YEAR);
		
		int hora=gc.get(GregorianCalendar.HOUR);
		int minuto=gc.get(GregorianCalendar.MINUTE);
		
		int contagemDia=this.data.getDia()-dia;
		if(contagemDia<0){
			contagemDia=0;
		}
		int contagemMes=this.data.getMes()-mes;
		if(contagemMes<0){
			contagemMes=0;
		}
		int contagemAno=this.data.getAno()-ano;
		if(contagemAno<0){
			contagemAno=0;
		}
		int contagemHora=this.hora.getHora()-hora;
		if(contagemHora<0){
			contagemHora=0;
		}
		int contagemMinuto=this.hora.getMinuto()-minuto;
		if(contagemMinuto<0){
			contagemMinuto=0;
		}
		
		return ("Faltam: "+contagemAno+" Ano(s) "+contagemMes+" Mes(es) "+
		contagemDia +" Dia(s) "+ contagemHora +" Hora(s)"+ 
		contagemMinuto+" Minuto(s) Para a realização do Exame"); 
		
	}
	
	//toString
	public String toString(){
		return "Disciplina:"+this.atividade.getNome()+"[Exame[Nota: "+this.nota+", Data: "+this.data+", Horario: "+this.hora+"]]";
	}
	

}
