package br.ufrpe.my_pigeon_study.dados;

public interface Repositorio {
	public boolean inserir(Object obj);
	public Object buscar(String obj);
	public boolean remover(String obj);
	public boolean alterar(Object novoObject);
}
