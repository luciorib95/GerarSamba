package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Visibilidade;

public class VisibilidadesRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public VisibilidadesRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Visibilidade> getVisibilidades(String idCubo) {
		List<Visibilidade> visibilidades = new ArrayList<Visibilidade>();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT\r\n"
					+ "    id_visibilidade,\r\n"
					+ "    id_cubo,\r\n"
					+ "    cod_usuario,\r\n"
					+ "    cod_perfil,\r\n"
					+ "    exp_filtro\r\n"
					+ " FROM\r\n"
					+ "    "+esquemaOrigem+".visibilidade"
					+ " WHERE id_cubo = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idCubo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Visibilidade visibilidade = new Visibilidade(); 
				visibilidade.setId(rs.getString(1));
				visibilidade.setIdCubo(rs.getString(2));
				visibilidade.setCodigoUsuario(rs.getString(3));
				visibilidade.setCodigoPerfil(rs.getString(4));
				visibilidade.setExpressaoFiltro(rs.getString(5));				
				visibilidades.add(visibilidade);
			}
		} catch (ConnectionException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return visibilidades;
	}
	
}
