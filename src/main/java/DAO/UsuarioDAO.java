package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import DTO.UsuarioDTO;

public class UsuarioDAO {

	Connection conn;
	PreparedStatement pstm;
	Statement stm;

	public void cadastrarUsuario(UsuarioDTO objusuarioDTO) throws SQLException {
		// Cadastro de usuario
		String insertUsuario = "INSERT INTO Usuario (nome_usuario) values (?)";
		try (Connection conn = new ConexaoDAO().conectaBD();
				PreparedStatement stm = conn.prepareStatement(insertUsuario);) {

			stm.setString(1, objusuarioDTO.getNomeUsuario());
			stm.execute();
			stm.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		// Cadastro de tarefas
		String insertTarefa = "INSERT INTO Tarefas (nome_tarefas) values (?)";
		try (Connection conn = new ConexaoDAO().conectaBD();
				PreparedStatement stm = conn.prepareStatement(insertTarefa);) {

			stm.setString(1, objusuarioDTO.getNomeTarefas());
			stm.execute();
			stm.close();

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
		// Cadastro na tabela de relacionamento
		public void cadastrarTabela(UsuarioDTO objusuarioDTO) throws SQLException {

		String sql_id_usuario = "SELECT TOP 1 * FROM Usuario ORDER BY id_usuario DESC;";
		Connection conn1 = new ConexaoDAO().conectaBD();
		Statement stm1 = conn1.createStatement();
		ResultSet result_id_usuario = stm1.executeQuery(sql_id_usuario);

		String sql_id_tarefa = "SELECT TOP 1 * FROM Tarefas ORDER BY id_tarefas DESC;";
		Connection conn2 = new ConexaoDAO().conectaBD();
		Statement stm2 = conn2.createStatement();
		ResultSet result_id_tarefa = stm2.executeQuery(sql_id_tarefa);

		while (result_id_usuario.next() && result_id_tarefa.next()) {
			int id_usuario = result_id_usuario.getInt("id_usuario");
			int id_tarefas = result_id_tarefa.getInt("id_tarefas");

			String sql = "INSERT INTO Usuario_Tarefas (uf_id_usuario, uf_id_tarefas) values (" + id_usuario + ","
					+ id_tarefas + ")";
			try (Connection conn = new ConexaoDAO().conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql);) {
				pstm.execute();
				pstm.close();

			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
		}
	}
}
