package br.com.logusinfo.consultas.model;

public class Node implements Exportavel {
	private String idConsulta;
	private String idEixo;
	private String seqNo;
	private String seqNoSup;
	private String idNivel;
	private String idFiltro;
	private String idMedida;
	private String idEstiloCab;
	private String idEstiloCel;
	private String codClassificador;
	private String titNo;
	private String numDecimais;
	private String separadorMilhar;
	private String unidMonetaria;
	private String expFiltro;
	private String funcAgregacao;
	private String prioAgregacao;
	private String prioFormatacao;
	private String dispFilhos;
	private String iniciarPagina;
	private String ocultar;
	private String tipoCorte;
	private String tamCorte;
	private String expCorte;
	private Nivel nivel;
	private Filtro filtro;
	private Medida medida;
	private Consulta consulta;

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
		idConsulta = (idConsulta==null)?"":idConsulta;
		this.idConsulta = idConsulta;
	}

	public String getIdEixo() {
		return idEixo;
	}

	public void setIdEixo(String idEixo) {
		idEixo = (idEixo==null)?"":idEixo;
		this.idEixo = idEixo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		seqNo = (seqNo==null)?"":seqNo;
		this.seqNo = seqNo;
	}

	public String getSeqNoSup() {
		return seqNoSup;
	}

	public void setSeqNoSup(String seqNoSup) {
		seqNoSup = (seqNoSup==null)?"":seqNoSup;
		this.seqNoSup = seqNoSup;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(String idNivel) {
		idNivel = (idNivel==null)?"":idNivel;
		this.idNivel = idNivel;
	}

	public String getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		idFiltro = (idFiltro==null)?"":idFiltro;
		this.idFiltro = idFiltro;
	}

	public String getIdMedida() {
		return idMedida;
	}

	public void setIdMedida(String idMedida) {
		idMedida = (idMedida==null)?"":idMedida;
		this.idMedida = idMedida;
	}

	public String getIdEstiloCab() {
		return idEstiloCab;
	}

	public void setIdEstiloCab(String idEstiloCab) {
		idEstiloCab = (idEstiloCab==null)?"":idEstiloCab;
		this.idEstiloCab = idEstiloCab;
	}

	public String getIdEstiloCel() {
		return idEstiloCel;
	}

	public void setIdEstiloCel(String idEstiloCel) {
		idEstiloCel = (idEstiloCel==null)?"":idEstiloCel;
		this.idEstiloCel = idEstiloCel;
	}

	public String getCodClassificador() {
		return codClassificador;
	}

	public void setCodClassificador(String codClassificador) {
		codClassificador = (codClassificador==null)?"":codClassificador;
		this.codClassificador = codClassificador;
	}

	public String getTitNo() {
		return titNo;
	}

	public void setTitNo(String titNo) {
		titNo = (titNo==null)?"":titNo;
		this.titNo = titNo;
	}

	public String getNumDecimais() {
		return numDecimais;
	}

	public void setNumDecimais(String numDecimais) {
		numDecimais = (numDecimais==null)?"":numDecimais;
		this.numDecimais = numDecimais;
	}

	public String getSeparadorMilhar() {
		return separadorMilhar;
	}

	public void setSeparadorMilhar(String separadorMilhar) {
		separadorMilhar = (separadorMilhar==null)?"":separadorMilhar;
		this.separadorMilhar = separadorMilhar;
	}

	public String getUnidMonetaria() {
		return unidMonetaria;
	}

	public void setUnidMonetaria(String unidMonetaria) {
		unidMonetaria = (unidMonetaria==null)?"":unidMonetaria;
		this.unidMonetaria = unidMonetaria;
	}

	public String getExpFiltro() {
		return expFiltro;
	}

	public void setExpFiltro(String expFiltro) {
		expFiltro = (expFiltro==null)?"":expFiltro;
		this.expFiltro = expFiltro;
	}

	public String getFuncAgregacao() {
		return funcAgregacao;
	}

	public void setFuncAgregacao(String funcAgregacao) {
		funcAgregacao = (funcAgregacao==null)?"":funcAgregacao;
		this.funcAgregacao = funcAgregacao;
	}

	public String getPrioAgregacao() {
		return prioAgregacao;
	}

	public void setPrioAgregacao(String prioAgregacao) {
		prioAgregacao = (prioAgregacao==null)?"":prioAgregacao;
		this.prioAgregacao = prioAgregacao;
	}

	public String getPrioFormatacao() {
		return prioFormatacao;
	}

	public void setPrioFormatacao(String prioFormatacao) {
		prioFormatacao = (prioFormatacao==null)?"":prioFormatacao;
		this.prioFormatacao = prioFormatacao;
	}

	public String getDispFilhos() {
		return dispFilhos;
	}

	public void setDispFilhos(String dispFilhos) {
		dispFilhos = (dispFilhos==null)?"":dispFilhos;
		this.dispFilhos = dispFilhos;
	}

	public String getIniciarPagina() {
		return iniciarPagina;
	}

	public void setIniciarPagina(String iniciarPagina) {
		iniciarPagina = (iniciarPagina==null)?"":iniciarPagina;
		this.iniciarPagina = iniciarPagina;
	}


	public String getOcultar() {
		return ocultar;
	}

	public void setOcultar(String ocultar) {
		ocultar = (ocultar==null)?"":ocultar;
		this.ocultar = ocultar;
	}

	public String getTipoCorte() {
		return tipoCorte;
	}

	public void setTipoCorte(String tipoCorte) {
		tipoCorte = (tipoCorte==null)?"":tipoCorte;
		this.tipoCorte = tipoCorte;
	}

	public String getTamCorte() {
		return tamCorte;
	}

	public void setTamCorte(String tamCorte) {
		tamCorte = (tamCorte==null)?"":tamCorte;
		this.tamCorte = tamCorte;
	}

	public String getExpCorte() {
		return expCorte;
	}

	public void setExpCorte(String expCorte) {
		expCorte = (expCorte==null)?"":expCorte;
		this.expCorte = expCorte;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;		
	}
	
	public Nivel getNivel() {
		return nivel;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Medida getMedida() {
		return medida;
	}
	
	private String sqlSafe(String valor) {
	    return valor == null ? null : valor.replace("'", "''");
	}
	
	@Override
	public String DML(String esquemaDestino) {
		String sql ="INSERT INTO "+esquemaDestino+".fv_no_consulta (\r\n"
				+ "    id_consulta,\r\n"
				+ "    id_eixo,\r\n"
				+ "    seq_no,\r\n"
				+ "    seq_no_sup,\r\n"
				+ "    id_nivel,\r\n"
				+ "    id_filtro,\r\n"
				+ "    id_medida,\r\n"
				+ "    id_estilo_cab,\r\n"
				+ "    id_estilo_cel,\r\n"
				+ "    cod_classificador,\r\n"
				+ "    tit_no,\r\n"
				+ "    num_decimais,\r\n"
				+ "    separador_milhar,\r\n"
				+ "    unid_monetaria,\r\n"
				+ "    exp_filtro,\r\n"
				+ "    func_agregacao,\r\n"
				+ "    prio_agregacao,\r\n"
				+ "    prio_formatacao,\r\n"
				+ "    disp_filhos,\r\n"
				+ "    iniciar_pagina,\r\n"
				+ "    ocultar,\r\n"
				+ "    tipo_corte,\r\n"
				+ "    tam_corte,\r\n"
				+ "    exp_corte\r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT ID_CONSULTA FROM "+esquemaDestino+".fv_consulta WHERE TIT_CONSULTA = '"+this.consulta.getTituloConsulta()+"') ,\r\n"
				+ "    '"+this.idEixo+"',\r\n"
				+ "    '"+this.seqNo+"',\r\n"
				+ "    '"+this.seqNoSup+"',\r\n"
				+ "    (SELECT ID_NIVEL FROM " + esquemaDestino + ".nivel " 
				+ "     WHERE TIT_NIVEL = '" + this.nivel.getTitulo() + "' " 
				+ "       AND ID_DIMENSAO = (SELECT ID_DIMENSAO FROM " + esquemaDestino + ".DIMENSAO " 
				+ "                       WHERE TIT_DIMENSAO = '" + this.getNivel().getDimensao().getTitulo() + "')) ,\r\n"

				+ "    (SELECT ID_FILTRO FROM "+esquemaDestino+".filtro WHERE TIT_FILTRO = '"+this.filtro.getTituloFiltro()+"') ,\r\n"
				
				+ "    (SELECT ID_MEDIDA FROM " + esquemaDestino + ".medida " 
				+ "     WHERE TIT_MEDIDA = '" + this.medida.getTituloMedida() + "' " 
				+ "       AND ID_CUBO = (SELECT ID_CUBO FROM " + esquemaDestino + ".cubo " 
				+ "                       WHERE TIT_CUBO = '" + this.medida.getCubo().getTitulo() + "')),\r\n"
				+ "    NULL,\r\n"
				+ "    NULL,\r\n"
				+ "    '"+this.codClassificador+"', \r\n"
				+ "    '"+this.titNo+"', \r\n"
				+ "    '"+this.numDecimais+"', \r\n"
				+ "    '"+this.separadorMilhar+"', \r\n"
				+ "    '"+this.unidMonetaria+"', \r\n"
				+ "    '" + sqlSafe(this.expFiltro) + "', \r\n"
				+ "    '"+this.funcAgregacao+"', \r\n"
				+ "    '"+this.prioAgregacao+"', \r\n"
				+ "    '"+this.prioFormatacao+"', \r\n"
				+ "    '"+this.dispFilhos+"', \r\n"
				+ "    '"+this.iniciarPagina+"', \r\n"
				+ "    '"+this.ocultar+"', \r\n"
				+ "    '"+this.tipoCorte+"', \r\n"
				+ "    '"+this.tamCorte+"', \r\n"
				+ "    '"+this.expCorte+"' \r\n"
				+ " FROM DUAL \r\n"
				+ " WHERE NOT EXISTS \r\n"
				+ " (SELECT NULL FROM "+esquemaDestino+".FV_NO_CONSULTA "
				+ " WHERE ID_CONSULTA = (SELECT A.ID_CONSULTA FROM "+esquemaDestino+".fv_consulta A WHERE A.TIT_CONSULTA = '"
				+ this.consulta.getTituloConsulta()+"') AND "
				+ " TIT_NO = '"+this.titNo+"' AND "
				+ " SEQ_NO = '"+this.seqNo+""+ "');";
		
		return sql;
	}

  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
	
}
