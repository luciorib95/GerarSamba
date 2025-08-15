package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.Nivel;

public class HierarquiasRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public HierarquiasRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Hierarquia> getHierarquias(Dimensao dimensao) {
	    List<Hierarquia> hierarquias = new ArrayList<>();
	    try {
	        connection = ConnUtil.init();
	        sql = new StringBuilder();
	        sql.append("SELECT h.ID_HIERARQUIA, ")
	           .append("h.ID_DIMENSAO, ")
	           .append("h.TIT_HIERARQUIA ")
	           .append("FROM ").append(esquemaOrigem).append(".HIERARQUIA h ")
	           .append("WHERE h.ID_DIMENSAO = ? ");

	        pstmt = connection.prepareStatement(sql.toString());
	        pstmt.setString(1, dimensao.getId());

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Hierarquia hierarquia = new Hierarquia();
	            hierarquia.setDimensao(dimensao);
	            hierarquia.setId(rs.getString("ID_HIERARQUIA"));
	            hierarquia.setTitulo(rs.getString("TIT_HIERARQUIA"));
	            hierarquias.add(hierarquia);
	        }
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	    return hierarquias;
	}

}
