package mvc.service;

import java.util.List;

import mvc.model.Membros;

public interface MembrosService {

	public List<Membros> listAllMembros();
	
	public Membros findMembrosById(int idprojeto, int idpessoa);

	public void addMembros(Membros membros);

	public void updateMembros(Membros membros);

	public void deleteMembros(int idprojeto, int idpessoa);
}