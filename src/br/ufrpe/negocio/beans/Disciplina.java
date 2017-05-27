package br.ufrpe.negocio.beans;

public class Disciplina {
	//ATRIBUTOS
	private String nome;
	private String dia_da_semana;
	private String horario;//definir o tipo melhor para horario
	private String professor;
	private String obs;
	private String periodo;
	
	//CONSTRUTOR
	public Disciplina(String nome, String dia_da_semana, String horario, String professor, String obs, String periodo) {
		super();
		this.nome = nome;
		this.dia_da_semana = dia_da_semana;
		this.horario = horario;
		this.professor = professor;
		this.obs = obs;
		this.periodo = periodo;
	}
	//METODOS GET/SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getDia_da_semana() {
		return dia_da_semana;
	}
	public void setDia_da_semana(String dia_da_semana) {
		this.dia_da_semana = dia_da_semana;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", dia_da_semana=" + dia_da_semana + ", horario=" + horario + ", professor="
				+ professor + ", obs=" + obs + ", periodo=" + periodo + "]";
	}
	
	

}
