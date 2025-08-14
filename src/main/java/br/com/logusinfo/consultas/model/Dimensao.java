package br.com.logusinfo.consultas.model;

import java.util.ArrayList;
import java.util.List;

public class Dimensao implements Exportavel {
	// ID_DIMENSAO, TIT_DIMENSAO, DES_DIMENSAO, FLG_VALIDO
	private String id = "";
	private String titulo = "";
	private String descricao = "";
	private String ehValido = "";
	private List<Hierarquia> hierarquias = new ArrayList();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getValido() {
		return ehValido;
	}
	public void setValido(String valido) {
		this.ehValido = valido;
	}

    /**
     * @return {@link #hierarquias}
     */
    public List<Hierarquia> getHierarquias() {
      return hierarquias;
    }

    /**
     * @param hierarquias atualiza {@link #hierarquias}.
     */
    public void setHierarquias(List<Hierarquia> hierarquias) {
      this.hierarquias = hierarquias;
    }
    
  public String DML(String esquemaDestino) {
		return "INSERT INTO "+esquemaDestino+".dimensao (\r\n"
				+ "    id_dimensao,\r\n"
				+ "    tit_dimensao,\r\n"
				+ "    des_dimensao,\r\n"
				+ "    flg_valido\r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT LPAD(MAX(ID_DIMENSAO)+1,6,'0') FROM "+esquemaDestino+".DIMENSAO),\r\n"
				+ "    '"+this.titulo+"',\r\n"
				+ "    '"+this.descricao+"',\r\n"
				+ "    '"+this.ehValido+"'\r\n"
				+ "		FROM DUAL\r\n"
				+ "    	WHERE NOT EXISTS ( "
				+ "		SELECT NULL FROM "
				+ "		"+esquemaDestino+".DIMENSAO "
				+ "		WHERE TIT_DIMENSAO = '"+this.titulo+"');";
	}
  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
	
}
