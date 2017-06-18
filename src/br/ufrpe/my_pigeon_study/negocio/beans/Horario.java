package br.ufrpe.my_pigeon_study.negocio.beans;

public class Horario {
	private int hora;
	private int minuto;
	
	public Horario(){
		
	}
	
	public Horario(int hora,int minuto){
		this.hora=hora;
		this.minuto=minuto;
	}
	
	public int getHora(){
		return this.hora;
	}
	
	public int getMinuto(){
		return this.minuto;
	}
	
	public void setHora(int hora){
		this.hora=hora;
	}
	
	public void setMinuto(int minuto){
		this.minuto=minuto;
	}
	
	public String toString(){
		return this.hora+":"+this.minuto;
	}

}
