package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Dimensao;

public class DimensoesRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public DimensoesRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public Dimensao getDimensao(String idDimensao) {
		Dimensao dimensao = new Dimensao();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" select id_dimensao, "
					+ " tit_dimensao, "
					+ " des_dimensao, "
					+ " flg_valido "
					+ " from "+esquemaOrigem+".dimensao "
					+ " where id_dimensao = ? ");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idDimensao);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dimensao.setId(rs.getString(1));
				dimensao.setTitulo(rs.getString(2));
				dimensao.setDescricao(rs.getString(3));
				dimensao.setValido(rs.getString(4));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());			
			e.printStackTrace();
		}
		return dimensao;
	}

}
