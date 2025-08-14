package br.com.logusinfo.consultas.model;

import java.util.ArrayList;
import java.util.List;

public class Nivel implements Exportavel {
	private String idNivel = "";
	private String idCubo = "";
	private String idDimensao = "";
	private Dimensao dimensao;
	private String titulo = "";
	private String abreviacao = "";
	private String tabelaNivel = "";
	private String colunaNivel = "";
	private String colunaTitulo = "";
	private String colunasFato = "";
	private String mascara = "";
	private String esquema = "";
	private Boolean nivelCubo = true;
	
	private Cubo cubo = new Cubo();
	public Dimensao getDimensao() {
		return dimensao;
	}
	public void setDimensao(Dimensao dimensao) {
		this.dimensao = dimensao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		titulo = (titulo==null)?"":titulo;
		this.titulo = titulo;
	}
	public String getAbreviacao() {
		return abreviacao;
	}
	public void setAbreviacao(String abreviacao) {
		abreviacao = (abreviacao==null)?"":abreviacao;
		this.abreviacao = abreviacao;
	}
	public String getTabelaNivel() {
		return tabelaNivel;
	}
	public void setTabelaNivel(String tabelaNivel) {
		tabelaNivel = (tabelaNivel==null)?"":tabelaNivel;				
		this.tabelaNivel = tabelaNivel;
	}
	public String getColunaNivel() {
		return colunaNivel;
	}
	public void setColunaNivel(String colunaNivel) {
		colunaNivel = (colunaNivel==null)?"":colunaNivel;
		this.colunaNivel = colunaNivel;
	}
	public String getColunaTitulo() {
		return colunaTitulo;
	}
	public void setColunaTitulo(String colunaTitulo) {
		colunaTitulo = (colunaTitulo==null)?"":colunaTitulo;
		this.colunaTitulo = colunaTitulo;
	}
	public String getMascara() {
		return mascara;
	}
	public void setMascara(String mascara) {
		mascara = (mascara==null)?"":mascara;
		this.mascara = mascara;
	}
	public String getEsquema() {
		return esquema;
	}
	public void setEsquema(String esquema) {
		esquema = (esquema==null)?"":esquema;
		this.esquema = esquema;
	}
	public String getColunasFato() {
		return colunasFato;
	}
	public void setColunasFato(String colunasFato) {
		colunasFato = (colunasFato==null)?"":colunasFato;
		this.colunasFato = colunasFato;
	}
	public Cubo getCubo() {
		return cubo;
	}
	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
	}
	public String getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(String idNivel) {
		idNivel = (idNivel==null)?"":idNivel;
		this.idNivel = idNivel;
	}
	public String getIdCubo() {
		return idCubo;
	}
	public void setIdCubo(String idCubo) {
		idCubo = (idCubo==null)?"":idCubo;
		this.idCubo = idCubo;
	}
	public String getIdDimensao() {
		return idDimensao;
	}
	public void setIdDimensao(String idDimensao) {
		idDimensao = (idDimensao==null)?"":idDimensao;
		this.idDimensao = idDimensao;
	}
	
	public Boolean getNivelCubo() {
	    return nivelCubo;
	}

	public void setNivelCubo(Boolean nivelCubo) {
	    this.nivelCubo = nivelCubo;
	}

	public String DML(String esquemaDestino) { // Linguagem de Manipulação de Dados (INSERT, UPDATE, DELETE)
		// Criar script para Nivel_Cubo e Nivel.
		return "INSERT INTO "+esquemaDestino+".nivel ( \r\n"
				+ "    id_nivel, \r\n"
				+ "    id_dimensao, \r\n"
				+ "    tit_nivel, \r\n"
				+ "    tit_abreviado, \r\n"
				+ "    tab_nivel, \r\n"
				+ "    col_nivel, \r\n"
				+ "    col_titulo, \r\n"
				+ "    des_mascara, \r\n"
				+ "    esquema \r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT LPAD(MAX(ID_NIVEL)+1,6,'0') FROM "+esquemaDestino+".NIVEL),\r\n"
				+ "    (SELECT ID_DIMENSAO FROM \r\n"
				+ "		"+esquemaDestino+".DIMENSAO \r\n"
				+ "		WHERE TIT_DIMENSAO = '"+this.dimensao.getTitulo()+"'), \r\n"
				+ "    '"+this.titulo+"', \r\n"
				+ "    '"+this.abreviacao+"', \r\n"
				+ "    '"+this.tabelaNivel+"', \r\n"
				+ "    '"+this.colunaNivel+"', \r\n"
				+ "    '"+this.colunaTitulo+"', \r\n"
				+ "    '"+this.mascara+"', \r\n"
				+ "    '"+this.esquema+"' \r\n"
				+ " FROM DUAL WHERE NOT EXISTS"
				+ " (SELECT NULL FROM "+esquemaDestino+".NIVEL " 
				+ " WHERE TIT_NIVEL = '"+this.titulo+"'); ";
	}
  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
}

