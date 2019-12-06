package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.PessoaDao;
import mvc.model.Pessoa;

@Service
public class PessoaServiceImpl implements PessoaService {

	PessoaDao pessoaDao;

	@Autowired
	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public List listAllPessoas() {
		return pessoaDao.listAllPessoas();
	}

	public void addPessoa(Pessoa pessoa) {
		pessoaDao.addPessoa(pessoa);
	}

	public void updatePessoa(Pessoa pessoa) {
		pessoaDao.updatePessoa(pessoa);
	}

	public void deletePessoa(int id) {
		pessoaDao.deletePessoa(id);
	}

	public Pessoa findPessoaById(int id) {
		return pessoaDao.findPessoaById(id);
	}

	public boolean pessoaExists(String nome) {
		return pessoaDao.pessoaExists(nome);
	}
	
	public Pessoa findPessoaByNome(String nome) {
		return pessoaDao.findPessoaByNome(nome);
	}

}