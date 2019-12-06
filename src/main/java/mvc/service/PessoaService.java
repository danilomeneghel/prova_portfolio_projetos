package mvc.service;

import java.util.List;

import mvc.model.Pessoa;

public interface PessoaService {

	public List<Pessoa> listAllPessoas();

	public Pessoa findPessoaById(int id);

	public Pessoa findPessoaByNome(String nome);
	
	public boolean pessoaExists(String nome);

	public void addPessoa(Pessoa pessoa);

	public void updatePessoa(Pessoa pessoa);

	public void deletePessoa(int id);
}