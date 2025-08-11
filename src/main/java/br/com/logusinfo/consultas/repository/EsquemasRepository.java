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
import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Esquema;

public class EsquemasRepository {

	private Connection connection;

	private Statement statement;

	private StringBuilder sql;

	public List<Esquema> getEsquemas() {
		List<Esquema> esquemas = new ArrayList<Esquema>();
		try {
			connection = ConnUtil.init();
			statement = connection.createStatement();
			sql = new StringBuilder();
			sql.append(" SELECT USERNAME FROM all_users\r\n"
					+ " WHERE UPPER(username) LIKE UPPER('FLEX%') \r\n"
					+ " AND UPPER(username) NOT LIKE UPPER('flexloader%')\r\n"
					+ " ORDER BY 1");
			ResultSet rs = statement.executeQuery(sql.toString());
			while (rs.next()) {
				Esquema esquema = new Esquema();			
				esquema.setNome(rs.getString(1));
				esquemas.add(esquema);
			}
		} catch (ConnectionException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return esquemas;
	}
	
}
