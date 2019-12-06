package mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import mvc.model.Membros;

@Repository
public class MembrosDaoImpl implements MembrosDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAllMembros() {
		String sql = "SELECT * FROM membros";

		List<Membros> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Membros membros) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (membros != null) {
			parameterSource.addValue("idprojeto", membros.getIdprojeto());
			parameterSource.addValue("idpessoa", membros.getIdpessoa());
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public Membros mapRow(ResultSet rs, int rowNum) throws SQLException {
			Membros membros = new Membros();
			membros.setIdprojeto(rs.getInt("idprojeto"));
			membros.setIdpessoa(rs.getInt("idpessoa"));
			
			return membros;
		}

	}

	public Membros findMembrosById(int idprojeto, int idpessoa) {
		String sql = "SELECT * FROM membros WHERE idprojeto = :idprojeto AND idpessoa = :idpessoa";

		try {
			return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Membros(idprojeto, idpessoa)), new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}
	
	public void addMembros(Membros membros) {
		String sql = "INSERT INTO membros(idprojeto, idpessoa) VALUES(:idprojeto, :idpessoa)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(membros));
	}

	public void updateMembros(Membros membros) {
		String sql = "UPDATE membros SET idprojeto = :idprojeto, idpessoa = :idpessoa WHERE idprojeto = :idprojeto AND idpessoa = :idpessoa";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(membros));
	}

	public void deleteMembros(int idprojeto, int idpessoa) {
		String sql = "DELETE FROM membros WHERE idprojeto = :idprojeto AND idpessoa = :idpessoa";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Membros(idprojeto, idpessoa)));
	}

}