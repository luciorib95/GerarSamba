package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.model.Nivel;

public class NiveisRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public NiveisRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<Nivel> getNiveisCubo(String idCubo) {
		List<Nivel> niveis = new ArrayList<Nivel>();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT \r\n" 
					+ "    b.id_cubo, \r\n" 
					+ "    b.id_nivel, \r\n" 
					+ "    b.col_fato, \r\n"
					+ "    a.id_dimensao, \r\n" 
					+ "    a.tit_nivel, \r\n" 
					+ "    a.tit_abreviado, \r\n"
					+ "    a.tab_nivel, \r\n" 
					+ "    a.col_nivel, \r\n" 
					+ "    a.col_titulo, \r\n"
					+ "    a.des_mascara, \r\n" 
					+ "    a.esquema \r\n" 
					+ " FROM \r\n"
					+ "         "+esquemaOrigem+".nivel a \r\n"
					+ "    LEFT JOIN "+esquemaOrigem+".nivel_cubo b ON a.id_nivel = b.id_nivel \r\n"
					+ " WHERE \r\n"
					+ "    b.id_cubo = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idCubo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Nivel nivel = new Nivel();
				nivel.setIdCubo(rs.getString(1));
				nivel.setIdNivel(rs.getString(2));
				nivel.setColunasFato(rs.getString(3));
				nivel.setIdDimensao(rs.getString(4));
				nivel.setTitulo(rs.getString(5));
				nivel.setAbreviacao(rs.getString(6));
				nivel.setTabelaNivel(rs.getString(7));
				nivel.setColunaNivel(rs.getString(8));
				nivel.setColunaTitulo(rs.getString(9));
				nivel.setMascara(rs.getString(10));
				nivel.setEsquema(rs.getString(11));
				nivel.setNivelCubo(true);
				niveis.add(nivel);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return niveis;
	}

	public Nivel getNivel(String idNivel) {
		Nivel nivel = new Nivel();
		try {
			connection = ConnUtil.init();
			sql = new StringBuilder();
			sql.append(" SELECT\r\n"
					+ "    id_nivel,\r\n"
					+ "    id_dimensao,\r\n"
					+ "    tit_nivel,\r\n"
					+ "    tit_abreviado,\r\n"
					+ "    tab_nivel,\r\n"
					+ "    col_nivel,\r\n"
					+ "    col_titulo,\r\n"
					+ "    des_mascara,\r\n"
					+ "    esquema\r\n"
					+ " FROM\r\n"
					+ "    "+esquemaOrigem+".nivel"
					+ " WHERE id_nivel = ?");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, idNivel);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {				
				nivel.setIdNivel(rs.getString(1));
				nivel.setIdDimensao(rs.getString(2));
				nivel.setTitulo(rs.getString(3));
				nivel.setAbreviacao(rs.getString(4));
				nivel.setTabelaNivel(rs.getString(5));
				nivel.setColunaNivel(rs.getString(6));
				nivel.setColunaTitulo(rs.getString(7));
				nivel.setMascara(rs.getString(8));
				nivel.setEsquema(rs.getString(9));
				nivel.setNivelCubo(true);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return nivel;
	}
	
	/**
	 * @param idCubo
	 * @return niveis que fazem parte de dimensões do cubo mas que não estão ligados diretamente
	 * ao cubo
	 */
	public List<Nivel> getNiveisDimensao(String idCubo) {
	    List<Nivel> niveis = new ArrayList<Nivel>();
	    try {
	        connection = ConnUtil.init();
	        sql = new StringBuilder();
	        sql.append(" SELECT \r\n" 
	                + "    n.id_nivel, \r\n" 
	                + "    n.id_dimensao, \r\n" 
	                + "    n.tit_nivel, \r\n"
	                + "    n.tit_abreviado, \r\n" 
	                + "    n.tab_nivel, \r\n" 
	                + "    n.col_nivel, \r\n"
	                + "    n.col_titulo, \r\n" 
	                + "    n.des_mascara, \r\n" 
	                + "    n.esquema \r\n"
	                + " FROM " + esquemaOrigem + ".nivel n \r\n"
	                + " WHERE n.id_dimensao IN ( \r\n"
	                + "     SELECT DISTINCT n2.id_dimensao \r\n"
	                + "     FROM " + esquemaOrigem + ".nivel n2 \r\n"
	                + "     JOIN " + esquemaOrigem + ".nivel_cubo nc2 \r\n"
	                + "         ON n2.id_nivel = nc2.id_nivel \r\n"
	                + "     WHERE nc2.id_cubo = ? \r\n"
	                + " ) \r\n"
	                + " AND n.id_nivel NOT IN ( \r\n"
	                + "     SELECT nc3.id_nivel \r\n"
	                + "     FROM " + esquemaOrigem + ".nivel_cubo nc3 \r\n"
	                + "     WHERE nc3.id_cubo = ? \r\n"
	                + " )");

	        pstmt = connection.prepareStatement(sql.toString());
	        pstmt.setString(1, idCubo);
	        pstmt.setString(2, idCubo);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Nivel nivel = new Nivel();
	            nivel.setIdNivel(rs.getString(1));
	            nivel.setIdDimensao(rs.getString(2));
	            nivel.setTitulo(rs.getString(3));
	            nivel.setAbreviacao(rs.getString(4));
	            nivel.setTabelaNivel(rs.getString(5));
	            nivel.setColunaNivel(rs.getString(6));
	            nivel.setColunaTitulo(rs.getString(7));
	            nivel.setMascara(rs.getString(8));
	            nivel.setEsquema(rs.getString(9));
	            nivel.setNivelCubo(false);
	            niveis.add(nivel);
	        }
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
	    }
	    return niveis;
	}


}
