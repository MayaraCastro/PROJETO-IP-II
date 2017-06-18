package br.ufrpe.my_pigeon_study.negocio.beans;

public class Disciplina {
	//ATRIBUTOS
	private String nome;
	private int dia_da_semana;
	private Horario horario;//definir o tipo melhor para horario
	private String professor;
	private String obs;

	
	//CONSTRUTOR
	public Disciplina(String nome, int dia_da_semana, Horario horario, String professor, String obs) {
		super();
		this.nome = nome;
		this.dia_da_semana = dia_da_semana;
		this.horario = horario;
		this.professor = professor;
		this.obs = obs;
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
	public int getDia_da_semana() {
		return dia_da_semana;
	}
	public void setDia_da_semana(int dia_da_semana) {
		this.dia_da_semana = dia_da_semana;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	
	//TOSTRING
	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", dia_da_semana=" + dia_da_semana + ", horario=" + horario + ", professor="
				+ professor + ", obs=" + obs + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (dia_da_semana != other.dia_da_semana)
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}
	

	
	
	

}
