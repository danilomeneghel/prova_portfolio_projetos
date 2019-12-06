package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.ProjetoDao;
import mvc.model.Projeto;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	ProjetoDao projetoDao;

	@Autowired
	public void setProjetoDao(ProjetoDao projetoDao) {
		this.projetoDao = projetoDao;
	}

	public List listAllProjetos() {
		return projetoDao.listAllProjetos();
	}

	public void addProjeto(Projeto projeto) {
		projetoDao.addProjeto(projeto);
	}

	public void updateProjeto(Projeto projeto) {
		projetoDao.updateProjeto(projeto);
	}

	public void deleteProjeto(int id) {
		projetoDao.deleteProjeto(id);
	}

	public Projeto findProjetoById(int id) {
		return projetoDao.findProjetoById(id);
	}

	public boolean projetoExists(String nome) {
		return projetoDao.projetoExists(nome);
	}
	
	public Projeto findProjetoByNome(String nome) {
		return projetoDao.findProjetoByNome(nome);
	}

}