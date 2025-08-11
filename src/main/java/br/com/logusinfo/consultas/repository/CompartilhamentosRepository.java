package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Compartilhamento;
import br.com.logusinfo.consultas.model.Nivel;

public class CompartilhamentosRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public CompartilhamentosRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Compartilhamento> getCompartilhamentos(String idConsulta) {
		List<Compartilhamento> compartilhamentos  = new ArrayList<Compartilhamento>();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT\r\n"
					+ "    id_compartilhamento,\r\n"
					+ "    id_cubo,\r\n"
					+ "    id_consulta,\r\n"
					+ "    cod_usuario,\r\n"
					+ "    cod_perfil,\r\n"
					+ "    id_dashboard\r\n"
					+ " FROM\r\n"
					+ "    "+esquemaOrigem+".compartilhamento"
					+ " WHERE id_consulta = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idConsulta);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Compartilhamento compartilhamento = new Compartilhamento();
				compartilhamento.setId(rs.getString(1));
				compartilhamento.setIdCubo(rs.getString(2));
				compartilhamento.setIdConsulta(rs.getString(3));
				compartilhamento.setCodigoUsuario(rs.getString(4));
				compartilhamento.setCodigoPerfil(rs.getString(5));
				compartilhamento.setIdDashboard(rs.getString(6));
				compartilhamentos.add(compartilhamento);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return compartilhamentos;
	}

}
