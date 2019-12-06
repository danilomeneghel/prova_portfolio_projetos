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

import mvc.model.Projeto;

@Repository
public class ProjetoDaoImpl implements ProjetoDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAllProjetos() {
		String sql = "SELECT * FROM projeto";

		List<Projeto> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Projeto projeto) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (projeto != null) {
			parameterSource.addValue("id", projeto.getId());
			parameterSource.addValue("nome", projeto.getNome());
			parameterSource.addValue("data_inicio", projeto.getData_inicio());
			parameterSource.addValue("data_previsao_fim", projeto.getData_previsao_fim());
			parameterSource.addValue("data_fim", projeto.getData_fim());
			parameterSource.addValue("descricao ", projeto.getDescricao ());
			parameterSource.addValue("status", projeto.getStatus());
			parameterSource.addValue("orcamento", projeto.getOrcamento());
			parameterSource.addValue("risco", projeto.getRisco());
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public Projeto mapRow(ResultSet rs, int rowNum) throws SQLException {
			Projeto projeto = new Projeto();
			projeto.setId(rs.getInt("id"));
			projeto.setNome(rs.getString("nome"));
			projeto.setData_inicio(rs.getDate("data_inicio"));
			projeto.setData_previsao_fim(rs.getDate("data_previsao_fim"));
			projeto.setData_fim(rs.getDate("data_fim"));
			projeto.setDescricao(rs.getString("descricao"));
			projeto.setStatus(rs.getString("status"));
			projeto.setOrcamento(rs.getFloat("orcamento"));
			projeto.setRisco(rs.getString("risco"));

			return projeto;
		}

	}

	public Projeto findProjetoById(int id) {
		String sql = "SELECT * FROM projeto WHERE id = :id";

		try {
			return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Projeto(id)), new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public Projeto findProjetoByNome(String nome) {
		String sql = "SELECT * FROM projeto WHERE nome = :nome";

		try {
			return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Projeto(nome)), new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public boolean projetoExists(String nome) {
		Projeto projeto = findProjetoByNome(nome);
		if (projeto != null && projeto.getNome() != null) {
			return true;
		}

		return false;
	}

	public void addProjeto(Projeto projeto) {
		String sql = "INSERT INTO projeto(nome, data_inicio, data_previsao_fim, data_fim, descricao, status, orcamento, risco) VALUES(:nome, :data_inicio, :data_previsao_fim, :data_fim, :descricao, :status, :orcamento, :risco)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(projeto));
	}

	public void updateProjeto(Projeto projeto) {
		String sql = "UPDATE projeto SET nome = :nome, data_inicio = :data_inicio, data_previsao_fim = :data_previsao_fim, data_fim = :data_fim, descricao = :descricao, status = :status, orcamento = :orcamento, risco = :risco WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(projeto));
	}

	public void deleteProjeto(int id) {
		String sql = "DELETE FROM projeto WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Projeto(id)));
	}

}