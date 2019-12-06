package mvc.model;

import java.util.Date;

public class Membros {

	private Integer idprojeto;
	private Integer idpessoa;

	public Membros() {
		super();
	}

	public Membros(Integer idprojeto, Integer idpessoa) {
		super();
		this.idprojeto = idprojeto;
		this.idpessoa = idpessoa;
	}

	public Integer getIdprojeto() {
		return idprojeto;
	}

	public void setIdprojeto(Integer idprojeto) {
		this.idprojeto = idprojeto;
	}

	public Integer getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}

}