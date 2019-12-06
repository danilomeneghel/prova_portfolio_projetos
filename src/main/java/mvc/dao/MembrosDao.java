package mvc.dao;

import java.util.List;

import mvc.model.Membros;

public interface MembrosDao {

	public List<Membros> listAllMembros();

	public Membros findMembrosById(int projeto, int idpessoa);
	
	public void addMembros(Membros membros);

	public void updateMembros(Membros membros);

	public void deleteMembros(int idprojeto, int idpessoa);
}