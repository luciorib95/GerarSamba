package br.com.logusinfo.consultas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import br.com.logusinfo.consultas.ConnUtil;

public class Propriedade implements Exportavel {
	private String id;
	private String idNivel;
	private Nivel nivel;
	private String nomeColuna;
	private String titPropriedade;
	private String chave;
	private String descricaoPadrao;
	private String tipoPropriedade;
	private String ehOculta;
	private String geoRef;
	private Consulta consulta;
	private String idConsulta;
	private String idEstilo;
	private String idEixo;
	private String seqNo;
	private String seqPropriedadeNo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdNivel() {
		return idNivel;
	}
	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public String getNomeColuna() {
		return nomeColuna;
	}
	public void setNomeColuna(String nomeColuna) {
		this.nomeColuna = nomeColuna;
	}
	public String getTitPropriedade() {
		return titPropriedade;
	}
	public void setTitPropriedade(String titPropriedade) {
		this.titPropriedade = titPropriedade;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getDescricaoPadrao() {
		return descricaoPadrao;
	}
	public void setDescricaoPadrao(String descricaoPadrao) {
		this.descricaoPadrao = descricaoPadrao;
	}
	public String getTipoPropriedade() {
		return tipoPropriedade;
	}
	public void setTipoPropriedade(String tipoPropriedade) {
		this.tipoPropriedade = tipoPropriedade;
	}
	public String getEhOculta() {
		return ehOculta;
	}
	public void setEhOculta(String ehOculta) {
		this.ehOculta = ehOculta;
	}
	public String getGeoRef() {
		return geoRef;
	}
	public void setGeoRef(String geoRef) {
		this.geoRef = geoRef;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getIdEixo() {
		return idEixo;
	}
	public void setIdEixo(String idEixo) {
		this.idEixo = idEixo;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getSeqPropriedadeNo() {
		return seqPropriedadeNo;
	}
	public void setSeqPropriedadeNo(String seqPropriedadeNo) {
		this.seqPropriedadeNo = seqPropriedadeNo;
	}
	public String getIdEstilo() {
		return idEstilo;
	}
	public void setIdEstilo(String idEstilo) {
		this.idEstilo = idEstilo;
	}
	
	@Override
	public String DML(String esquemaDestino, String idPropriedade) {
	    String sql = "INSERT INTO "+esquemaDestino+".propriedade (\r\n"
	            + "    id_propriedade,\r\n"
	            + "    id_nivel,\r\n"
	            + "    nom_coluna,\r\n"
	            + "    tit_propriedade,\r\n"
	            + "    chave,\r\n"
	            + "    desc_padrao,\r\n"
	            + "    tip_propriedade,\r\n"
	            + "    oculta,\r\n"
	            + "    georef\r\n"
	            + ") SELECT \r\n"
	            + "    '"+idPropriedade+"',\r\n"
	            + "    (SELECT ID_NIVEL FROM \r\n"
	            + "     "+esquemaDestino+".NIVEL \r\n"
	            + "     WHERE TIT_NIVEL = '"+this.nivel.getTitulo()+"'), \r\n"
	            + "    '"+this.nomeColuna+"',\r\n"
	            + "    '"+this.titPropriedade+"',\r\n"
	            + "    '"+this.chave+"',\r\n"
	            + "    '"+this.descricaoPadrao+"',\r\n"
	            + "    '"+this.tipoPropriedade+"',\r\n"
	            + "    '"+this.ehOculta+"',\r\n"
	            + "    '"+this.geoRef+"'\r\n"
	            + " FROM DUAL "
	            + " WHERE NOT EXISTS "
	            + " (SELECT NULL FROM "+esquemaDestino+".PROPRIEDADE "
	            + " WHERE "
	            + "    ID_NIVEL = (SELECT ID_NIVEL FROM \r\n"
	            + "     "+esquemaDestino+".NIVEL \r\n"
	            + "     WHERE TIT_NIVEL = '"+this.nivel.getTitulo()+"') AND \r\n"
	            + "    TIT_PROPRIEDADE = '"+this.titPropriedade+"'\r\n"
	            + " ); \r\n";

	    if (this.seqNo != null && this.seqPropriedadeNo != null) {
	        sql += "INSERT INTO "+esquemaDestino+".fv_propriedade_no (\r\n"
	                + "    id_consulta,\r\n"
	                + "    id_eixo,\r\n"
	                + "    seq_no,\r\n"
	                + "    id_propriedade,\r\n"
	                + "    seq_propriedade_no \r\n"
	                + ") SELECT \r\n"
	                + "    (SELECT ID_CONSULTA FROM \r\n"
	                + "     "+esquemaDestino+".FV_CONSULTA \r\n"
	                + "     WHERE TIT_CONSULTA = '"+this.consulta.getTituloConsulta()+"'), \r\n"
	                + "    '"+this.idEixo+"',\r\n"
	                + "    '"+this.seqNo+"',\r\n"
	                + " (SELECT ID_PROPRIEDADE FROM "+esquemaDestino+".PROPRIEDADE "
	                + "     WHERE "
	                + "     ID_NIVEL = (SELECT ID_NIVEL FROM \r\n"
	                + "     "+esquemaDestino+".NIVEL \r\n"
	                + "     WHERE TIT_NIVEL = '"+this.nivel.getTitulo()+"' AND \r\n"
	                + "     TIT_PROPRIEDADE = '"+this.titPropriedade+"')\r\n"
	                + " ), "
	                + "    '"+this.seqPropriedadeNo+"'\r\n"
	                + " FROM DUAL "
	                + " WHERE NOT EXISTS "
	                + " (SELECT NULL FROM "+esquemaDestino+".fv_propriedade_no "
	                + " WHERE "
	                + "    ID_PROPRIEDADE = (SELECT ID_PROPRIEDADE FROM \r\n"
	                + "     "+esquemaDestino+".PROPRIEDADE \r\n"
	                + "     WHERE ID_NIVEL = '"+this.getIdNivel()+"' AND \r\n"
	                + "    TIT_PROPRIEDADE = '"+this.titPropriedade+"')\r\n"
	                + " ); \r\n";
	    }

	    return sql;
	}
  @Override
  public String DML(String esquemaDestino) {
    // TODO Auto-generated method stub
    return null;
  }	

}
