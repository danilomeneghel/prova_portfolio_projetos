package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MembrosDao;
import mvc.model.Membros;

@Service
public class MembrosServiceImpl implements MembrosService {

	MembrosDao membrosDao;

	@Autowired
	public void setMembrosDao(MembrosDao membrosDao) {
		this.membrosDao = membrosDao;
	}

	public List listAllMembros() {
		return membrosDao.listAllMembros();
	}

	public void addMembros(Membros membros) {
		System.out.println(membros);
		
		membrosDao.addMembros(membros);
	}

	public void updateMembros(Membros membros) {
		membrosDao.updateMembros(membros);
	}

	public void deleteMembros(int idprojeto, int idpessoa) {
		membrosDao.deleteMembros(idprojeto, idpessoa);
	}

	public Membros findMembrosById(int idprojeto, int idpessoa) {
		return membrosDao.findMembrosById(idprojeto, idpessoa);
	}
}