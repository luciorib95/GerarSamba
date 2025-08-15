package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.model.NivelHierarquia;

public class NiveisHierarquiasRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public NiveisHierarquiasRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<NivelHierarquia> getNiveisHierarquias(Hierarquia hierarquia, Nivel nivel) {
	    List<NivelHierarquia> niveisHierarquia = new ArrayList<>();
	    try {
	        connection = ConnUtil.init();
	        sql = new StringBuilder();
	        sql.append("SELECT h.ID_HIERARQUIA, ")
	           .append("h.ID_NIVEL, ")
	           .append("h.COL_JOIN, ")
	           .append("h.SEQ_NIVEL ")
	           .append("FROM ").append(esquemaOrigem).append(".NIVEL_HIERARQUIA h ")
	           .append("WHERE h.ID_HIERARQUIA = ? AND h.ID_NIVEL = ?");

	        pstmt = connection.prepareStatement(sql.toString());
	        pstmt.setString(1, hierarquia.getId());
	        pstmt.setString(2, nivel.getIdNivel());

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            NivelHierarquia nivelHierarquia = new NivelHierarquia();
	            nivelHierarquia.setHierarquia(hierarquia);
	            nivelHierarquia.setNivel(nivel);
	            nivelHierarquia.setColunaJuncao(rs.getString("COL_JOIN"));
	            nivelHierarquia.setSeqNivel(rs.getString("SEQ_NIVEL"));
	            niveisHierarquia.add(nivelHierarquia);
	        }
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	    return niveisHierarquia;
	}

}
