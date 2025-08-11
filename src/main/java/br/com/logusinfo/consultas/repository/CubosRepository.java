package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Cubo;

public class CubosRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public CubosRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public Cubo getCubo(String idConsulta) {
		Cubo cubo = new Cubo();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT B.ID_CUBO, B.TIT_CUBO, B.TAB_FATO, B.ESQUEMA, B.VALIDO , B.DES_CUBO ");
			sql.append(" FROM "+esquemaOrigem+".FV_CONSULTA A ");
			sql.append(" LEFT JOIN "+esquemaOrigem+".CUBO B ON A.ID_CUBO = B.ID_CUBO ");
			sql.append(" WHERE A.ID_CONSULTA = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idConsulta);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cubo.setId(rs.getString(1));
				cubo.setTitulo(rs.getString(2));
				cubo.setTabelaFato(rs.getString(3));
				cubo.setEsquema(rs.getString(4));
				cubo.setValido(rs.getString(5));
				cubo.setDescricao(rs.getString(6));
			}
		} catch (ConnectionException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return cubo;
	}
	
}
