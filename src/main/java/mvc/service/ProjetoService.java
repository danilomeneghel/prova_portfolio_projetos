package mvc.service;

import java.util.List;

import mvc.model.Projeto;

public interface ProjetoService {

	public List<Projeto> listAllProjetos();

	public Projeto findProjetoById(int id);

	public Projeto findProjetoByNome(String nome);
	
	public boolean projetoExists(String nome);

	public void addProjeto(Projeto projeto);

	public void updateProjeto(Projeto projeto);

	public void deleteProjeto(int id);
}