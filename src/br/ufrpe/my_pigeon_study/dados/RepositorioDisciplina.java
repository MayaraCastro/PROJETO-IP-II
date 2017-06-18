package repositorios;

import br.ufrpe.negocio.beans.Disciplina;

public class RepositorioDisciplina {
	
	private Disciplina[] disciplinas;
	private int qtdDisc;
	
	
	public RepositorioDisciplina() {
		this.disciplinas = new Disciplina[100];
		this.qtdDisc = 0;
	}
	
	
	
	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}



	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}



	public int getQtdDisc() {
		return qtdDisc;
	}





	public boolean inserirDisc(Disciplina disc){
		if(disc != null && qtdDisc < 20){
			this.disciplinas[qtdDisc] = disc;
			this.qtdDisc++;
			return true;
		}
		return false;
	}
	
	public Disciplina buscarDisc(Disciplina disc){
		for(Disciplina d:this.disciplinas){
			if(d!=null && d.getNome().equals(disc)){
				return (d);
			}
		}
		return null;
	}
	
	public boolean alterarDisc(Disciplina newDisc){
		if(newDisc != null){
			for(int i=0;i<20;i++){
				if(this.disciplinas[i] != null && this.disciplinas[i].getNome().equals(newDisc) == true){
					this.disciplinas[i] = newDisc;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean removerDisc(Disciplina disc){
		if(this.buscarDisc(disc) == null){
			return false;
		}
		boolean s = false;
		for(int i=0;i<20;i++){
			if(this.disciplinas != null){
				if(s){
					this.disciplinas[i-1] = this.disciplinas[i];
					this.disciplinas[i] = null;
				}else{
					if(this.disciplinas[i].getNome().equals(disc) == true){
						s = true;
						this.qtdDisc--;
				}
			}
			
		}
					
	}
	return true;

	

}
}
