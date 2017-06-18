package janelas;
import br.ufrpe.negocio.beans.*;
import negocio.*;
import repositorios.*;
public class Fachada {
	
	Calendario calendario;
	Disciplina disciplina;
	Exame exame;
	Task task;
	Usuario usuario;
	
	public Fachada(Calendario calendario, Disciplina disciplina, Exame exame, Task task, Usuario usuario){
		this.calendario=calendario;
		this.disciplina=disciplina;
		this.exame=exame;
		this.task=task;
		this.usuario=usuario;
	}
	

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public void CadastrarUser(Usuario user){
		RepositorioUsuario rep= new RepositorioUsuario();
		CadastroUsuario cadastro=new CadastroUsuario(rep);	
	}
	
	public void CadastroTask(Task task){
		RepositorioTask rep= new RepositorioTask();
		CadastrarTask cadastro=new CadastrarTask(rep);	
	}
	
	public void CadastrarDisciplina(Disciplina disciplina){
		RepositorioDisciplina rep= new RepositorioDisciplina();
		CadastroDisciplina cadastro=new CadastroDisciplina();	
	}

}
