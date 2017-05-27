package br.ufrpe.negocio.beans;

public class Main {

	public static void main(String[] args) {
		Disciplina[] disc = new Disciplina[2];
		disc[0] = new Disciplina("Discreta","Segunda","14:00","Linda","Vamo","3");
		disc[1] = new Disciplina("Calculo","Segunda","16:00","Carla","Nada","3");
		
		Usuario usu = new Usuario("Yasmin","28/08/1998","yas","oioioi","fem","email");
		
		Disciplina[] disc1 = {disc[0]};
		
		usu.addDisc(disc1);
		System.out.println(usu.toString());
		Horario hora=new Horario(14,00);
		Data data=new Data(26,5,2017);
		Exame Va1 = new Exame(7.5,"bela professora", data, hora,disc[0]);
		System.out.println(Va1);
		Va1.contagemRegressiva();

	}

}
