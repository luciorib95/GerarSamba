package br.com.logusinfo.consultas.model;

import java.util.ArrayList;
import java.util.List;

public class Filtro implements Exportavel {
	private String id = "";
	private Cubo cubo;
	private String idCubo = "";
	private String idConsulta = "";
	private String tituloFiltro = "";
	private String expressaoFiltro = "";
	private String descricaoFiltro = "";
	private String colunaNivel = "";
	private String colunaTitulo = "";
	private String colunasFato = "";
	private String mascara = "";
	private String esquema = "";

	public Cubo getCubo() {
		return cubo;
	}

	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		id = (id==null)?"":id;
		this.id = id;
	}

	public String getIdCubo() {
		return idCubo;
	}

	public void setIdCubo(String idCubo) {
		idCubo = (idCubo==null)?"":idCubo;
		this.idCubo = idCubo;
	}

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		idConsulta = (idConsulta==null)?"":idConsulta;
		this.idConsulta = idConsulta;
	}

	public String getTituloFiltro() {
		return tituloFiltro;
	}

	public void setTituloFiltro(String tituloFiltro) {
		tituloFiltro = (tituloFiltro==null)?"":tituloFiltro;
		this.tituloFiltro = tituloFiltro;
	}

	public String getExpressaoFiltro() {
		return expressaoFiltro;
	}

	public void setExpressaoFiltro(String expressaoFiltro) {
		expressaoFiltro = (expressaoFiltro==null)?"":expressaoFiltro;
		this.expressaoFiltro = expressaoFiltro;
	}

	public String getDescricaoFiltro() {
		return descricaoFiltro;
	}

	public void setDescricaoFiltro(String descricaoFiltro) {
		descricaoFiltro = (descricaoFiltro==null)?"":descricaoFiltro;
		this.descricaoFiltro = descricaoFiltro;
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

	public String getColunasFato() {
		return colunasFato;
	}

	public void setColunasFato(String colunasFato) {
		colunasFato = (colunasFato==null)?"":colunasFato;
		this.colunasFato = colunasFato;
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

	public String DML(String esquemaDestino) {
		return "INSERT INTO "+esquemaDestino+".filtro (\r\n"
				+ "    id_filtro,\r\n"
				+ "    id_cubo,\r\n"
				+ "    tit_filtro,\r\n"
				+ "    exp_filtro,\r\n"
				+ "    des_filtro\r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT LPAD(MAX(ID_FILTRO)+1,6,'0') FROM "+esquemaDestino+".FILTRO),\r\n"
				+ "    (SELECT ID_CUBO FROM \r\n"
				+ "		"+esquemaDestino+".CUBO \r\n"
				+ "		WHERE TIT_CUBO = '"+this.cubo.getTitulo()+"'), \r\n"
				+ "    '"+this.tituloFiltro+"',\r\n"
				+ "    '"+this.expressaoFiltro+"',\r\n"
				+ "    '"+this.descricaoFiltro+"'\r\n"
				+ " FROM DUAL \r\n"
				+ " WHERE NOT EXISTS \r\n"
				+ " (SELECT NULL FROM "+esquemaDestino+".filtro WHERE tit_filtro = '"+this.tituloFiltro+"');";
	}

  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }	
}

