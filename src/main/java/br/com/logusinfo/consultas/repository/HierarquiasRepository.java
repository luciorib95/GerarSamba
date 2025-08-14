package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Hierarquia;

public class HierarquiasRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public HierarquiasRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Hierarquia> getHierarquias(String idDimensao) {
		List<Hierarquia> hierarquias = new ArrayList<>();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" select ID_HIERARQUIA, \r\n" 
					+ " h.ID_DIMENSAO, \r\n"
					+ " h.TIT_HIERARQUIA \r\n"
					+ " from "+esquemaOrigem+".hierarquia h "
					+ " where h.ID_DIMENSAO = ? ");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idDimensao);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			    Hierarquia hierarquia = new Hierarquia();
			    hierarquia.setId(rs.getString(1));
			    hierarquia.setTitulo(rs.getString(3));
			    hierarquias.add(hierarquia);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());			
			e.printStackTrace();
		}
		return hierarquias;
	}

}
