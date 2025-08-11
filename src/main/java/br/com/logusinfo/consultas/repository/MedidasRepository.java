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
import br.com.logusinfo.consultas.model.Medida;
import br.com.logusinfo.consultas.model.Node;

public class MedidasRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public MedidasRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public Medida getMedida(String idMedida) {
		Medida medida = new Medida();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT \r\n"
					+ "    id_medida, \r\n"
					+ "    id_cubo, \r\n"
					+ "    col_medida, \r\n"
					+ "    tit_medida, \r\n"
					+ "    exp_filtro, \r\n"
					+ "    e_padrao, \r\n"
					+ "    des_medida \r\n"
					+ " FROM \r\n"
					+ "    "+esquemaOrigem+".medida \r\n"
					+ " WHERE id_medida = ? ");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idMedida);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				medida.setId(rs.getString(1));
				medida.setIdCubo(rs.getString(2));
				medida.setColMedida(rs.getString(3));
				medida.setTituloMedida(rs.getString(4));
				medida.setExpressaoFiltro(rs.getString(5));
				medida.setEhPadrao(rs.getString(6));
				medida.setDescricaoMedida(rs.getString(7));
			}
		} catch (ConnectionException | SQLException e) {
			e.printStackTrace();
		}
		return medida;
	}
	
	/**
	 * @param idCubo
	 * @param idConsulta
	 * @return medidas do cubo que não estão na consulta
	 */
	public List<Medida> getMedidasCubo(String tituloCubo, String tituloConsulta) {
	    List<Medida> medidas = new ArrayList<>();
	    try {
	        connection = ConnUtil.init();
	        sql = new StringBuilder();
	        sql.append("SELECT \r\n")
	           .append("    m.id_medida, \r\n")
	           .append("    m.id_cubo, \r\n")
	           .append("    m.col_medida, \r\n")
	           .append("    m.tit_medida, \r\n")
	           .append("    m.exp_filtro, \r\n")
	           .append("    m.e_padrao, \r\n")
	           .append("    m.des_medida \r\n")
	           .append("FROM \r\n")
	           .append("    ").append(esquemaOrigem).append(".medida m \r\n")
	           .append("JOIN ").append(esquemaOrigem).append(".cubo c ON m.id_cubo = c.id_cubo \r\n")
	           .append("WHERE c.tit_cubo = ? \r\n")
	           .append("AND m.id_medida NOT IN ( \r\n")
	           .append("    SELECT DISTINCT fnc.id_medida \r\n")
	           .append("    FROM ").append(esquemaOrigem).append(".fv_no_consulta fnc \r\n")
	           .append("    JOIN ").append(esquemaOrigem).append(".fv_consulta fc ON fnc.id_consulta = fc.id_consulta \r\n")
	           .append("    WHERE fc.tit_consulta = ? \r\n")
	           .append("    AND fnc.id_medida IS NOT NULL \r\n")
	           .append(")");

	        pstmt = connection.prepareStatement(sql.toString());
	        pstmt.setString(1, tituloCubo);
	        pstmt.setString(2, tituloConsulta);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Medida medida = new Medida();
	            medida.setId(rs.getString(1));
	            medida.setIdCubo(rs.getString(2));
	            medida.setColMedida(rs.getString(3));
	            medida.setTituloMedida(rs.getString(4));
	            medida.setExpressaoFiltro(rs.getString(5));
	            medida.setEhPadrao(rs.getString(6));
	            medida.setDescricaoMedida(rs.getString(7));
	            medidas.add(medida);
	        }
	    } catch (ConnectionException | SQLException e) {
	        e.printStackTrace();
	    }
	    return medidas;
	}

}
