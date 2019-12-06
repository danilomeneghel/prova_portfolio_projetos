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

import mvc.model.Pessoa;

@Repository
public class PessoaDaoImpl implements PessoaDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAllPessoas() {
		String sql = "SELECT * FROM pessoa";

		List<Pessoa> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Pessoa pessoa) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (pessoa != null) {
			parameterSource.addValue("id", pessoa.getId());
			parameterSource.addValue("nome", pessoa.getNome());
			parameterSource.addValue("datanascimento", pessoa.getDatanascimento());
			parameterSource.addValue("cpf", pessoa.getCpf());
			parameterSource.addValue("funcionario", pessoa.getFuncionario());
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setDatanascimento(rs.getDate("datanascimento"));
			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setFuncionario(rs.getBoolean("funcionario"));

			return pessoa;
		}

	}

	public Pessoa findPessoaById(int id) {
		String sql = "SELECT * FROM pessoa WHERE id = :id";

		try {
			return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Pessoa(id)), new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public Pessoa findPessoaByNome(String nome) {
		String sql = "SELECT * FROM pessoa WHERE nome = :nome";

		try {
			return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Pessoa(nome)), new UserMapper());
		} catch (Exception e) {
			return null;
		}
	}

	public boolean pessoaExists(String nome) {
		Pessoa pessoa = findPessoaByNome(nome);
		if (pessoa != null && pessoa.getNome() != null) {
			return true;
		}

		return false;
	}

	public void addPessoa(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa(nome, datanascimento, cpf, funcionario) VALUES(:nome, :datanascimento, :cpf, :funcionario)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(pessoa));
	}

	public void updatePessoa(Pessoa pessoa) {
		String sql = "UPDATE pessoa SET nome = :nome, datanascimento = :datanascimento, cpf = :cpf, funcionario = :funcionario WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(pessoa));
	}

	public void deletePessoa(int id) {
		String sql = "DELETE FROM pessoa WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Pessoa(id)));
	}

}