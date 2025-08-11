package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Filtro;
import br.com.logusinfo.consultas.model.Node;

public class FiltrosRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public FiltrosRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public Filtro getFiltro(String idFiltro) {
		Filtro filtro = new Filtro();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT\r\n"
					+ "    id_filtro,\r\n"
					+ "    id_cubo,\r\n"
					+ "    id_consulta,\r\n"
					+ "    tit_filtro,\r\n"
					+ "    exp_filtro,\r\n"
					+ "    des_filtro\r\n"
					+ " FROM\r\n"
					+ "    "+esquemaOrigem+".filtro"
					+ " WHERE id_filtro = ? ");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idFiltro);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				filtro.setId(rs.getString(1));
				filtro.setIdCubo(rs.getString(2));
				filtro.setIdConsulta(rs.getString(3));
				filtro.setTituloFiltro(rs.getString(4));
				filtro.setExpressaoFiltro(rs.getString(5));
				filtro.setDescricaoFiltro(rs.getString(6));
			}
		} catch (ConnectionException | SQLException e) {
			e.printStackTrace();
		}
		return filtro;
	}

}
