package br.com.logusinfo.consultas.model;

import java.util.List;

public class Consulta implements Exportavel{

	private String idConsulta;
	private String idCubo;
	private Cubo cubo;
	private String tituloConsulta;
	private String desConsulta;
	private String tipVisualizacao;
	private String expFiltro;
	private String codUsuario;
	private String tipoFiltroDados;
	private String idCategory;

	private String indicadorQuebraHierarquiaLinhas;
	private String indicadorQuebraHierarquiaColunas;
	private String tipoCorteLinhas;
	private String tamanhoCorteLinhas;
	private String expressaoCorteLinhas;
	private String tipoCorteColunas;
	private String tamanhoCorteColunas;
	private String expressaoCorteColunas;
	private String tipoOrientacao;

	private String tamanhoLarguraGrafico;
	private String tamanhoAlturaGrafico;
	private String tipoGrafico;
	private String tipoGrafico3D;
	private String merclarCelEixoY;
	private String usarTitCustomEixoY;
	private String tituloCustomEixoY;
	private String vazioLugarZero;
	private String repetirHeaderPag;
	private String codHeader;
	private String codFooter;
	private String indicadorForcaOnline;
	private String congelarCelularEixoY;
	private String indicadorPermiteOnline;
	private String indicadorSQLANSI;
	private List<Compartilhamento> compartilhamentos;
	private List<Node> nodes;
	private List<Nivel> niveis;
	private List<Propriedade> propriedades;
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		idConsulta = (idConsulta==null)?"":idConsulta;
		this.idConsulta = idConsulta;
	}
	public String getIdCubo() {
		return idCubo;
	}
	public void setIdCubo(String idCubo) {
		idCubo = (idCubo==null)?"":idCubo;
		this.idCubo = idCubo;
	}
	public String getDesConsulta() {
		return desConsulta;
	}
	public void setDesConsulta(String desConsulta) {
		desConsulta = (desConsulta==null)?"":desConsulta;
		this.desConsulta = desConsulta;
	}
	public String getTipVisualizacao() {
		return tipVisualizacao;
	}
	public void setTipVisualizacao(String tipVisualizacao) {
		tipVisualizacao = (tipVisualizacao==null)?"":tipVisualizacao;
		this.tipVisualizacao = tipVisualizacao;
	}
	public String getExpFiltro() {
		return expFiltro;
	}
	public void setExpFiltro(String expFiltro) {
		expFiltro = (expFiltro==null)?"":expFiltro;
		this.expFiltro = expFiltro;
	}
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		codUsuario = (codUsuario==null)?"":codUsuario;
		this.codUsuario = codUsuario;
	}
	public String getTipoFiltroDados() {
		return tipoFiltroDados;
	}
	public void setTipoFiltroDados(String tipoFiltroDados) {
		tipoFiltroDados = (tipoFiltroDados==null)?"":tipoFiltroDados;
		this.tipoFiltroDados = tipoFiltroDados;
	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		idCategory = (idCategory==null)?"":idCategory;
		this.idCategory = idCategory;
	}
	public String getIndicadorQuebraHierarquiaLinhas() {
		return indicadorQuebraHierarquiaLinhas;
	}
	public void setIndicadorQuebraHierarquiaLinhas(String indicadorQuebraHierarquiaLinhas) {
		indicadorQuebraHierarquiaLinhas = (indicadorQuebraHierarquiaLinhas==null)?"":indicadorQuebraHierarquiaLinhas;
		this.indicadorQuebraHierarquiaLinhas = indicadorQuebraHierarquiaLinhas;
	}
	public String getIndicadorQuebraHierarquiaColunas() {
		return indicadorQuebraHierarquiaColunas;
	}
	public void setIndicadorQuebraHierarquiaColunas(String indicadorQuebraHierarquiaColunas) {
		indicadorQuebraHierarquiaColunas = (indicadorQuebraHierarquiaColunas==null)?"":indicadorQuebraHierarquiaColunas;
		this.indicadorQuebraHierarquiaColunas = indicadorQuebraHierarquiaColunas;
	}
	public String getTipoCorteLinhas() {
		return tipoCorteLinhas;
	}
	public void setTipoCorteLinhas(String tipoCorteLinhas) {
		tipoCorteLinhas = (tipoCorteLinhas==null)?"":tipoCorteLinhas;
		this.tipoCorteLinhas = tipoCorteLinhas;
	}
	public String getTamanhoCorteLinhas() {
		return tamanhoCorteLinhas;
	}
	public void setTamanhoCorteLinhas(String tamanhoCorteLinhas) {
		tamanhoCorteLinhas = (tamanhoCorteLinhas==null)?"":tamanhoCorteLinhas;
		this.tamanhoCorteLinhas = tamanhoCorteLinhas;
	}
	public String getExpressaoCorteLinhas() {
		return expressaoCorteLinhas;
	}
	public void setExpressaoCorteLinhas(String expressaoCorteLinhas) {
		expressaoCorteLinhas = (expressaoCorteLinhas==null)?"":expressaoCorteLinhas;
		this.expressaoCorteLinhas = expressaoCorteLinhas;
	}
	public String getTipoCorteColunas() {
		return tipoCorteColunas;
	}
	public void setTipoCorteColunas(String tipoCorteColunas) {
		tipoCorteColunas = (tipoCorteColunas==null)?"":tipoCorteColunas;
		this.tipoCorteColunas = tipoCorteColunas;
	}
	public String getTamanhoCorteColunas() {
		return tamanhoCorteColunas;
	}
	public void setTamanhoCorteColunas(String tamanhoCorteColunas) {
		tamanhoCorteColunas = (tamanhoCorteColunas==null)?"":tamanhoCorteColunas;
		this.tamanhoCorteColunas = tamanhoCorteColunas;
	}
	public String getExpressaoCorteColunas() {
		return expressaoCorteColunas;
	}
	public void setExpressaoCorteColunas(String expressaoCorteColunas) {
		expressaoCorteColunas = (expressaoCorteColunas==null)?"":expressaoCorteColunas;
		this.expressaoCorteColunas = expressaoCorteColunas;
	}
	public String getTipoOrientacao() {
		return tipoOrientacao;
	}
	public void setTipoOrientacao(String tipoOrientacao) {
		tipoOrientacao = (tipoOrientacao==null)?"":tipoOrientacao;
		this.tipoOrientacao = tipoOrientacao;
	}
	public String getTamanhoLarguraGrafico() {
		return tamanhoLarguraGrafico;
	}
	public void setTamanhoLarguraGrafico(String tamanhoLarguraGrafico) {
		tamanhoLarguraGrafico = (tamanhoLarguraGrafico==null)?"":tamanhoLarguraGrafico;
		this.tamanhoLarguraGrafico = tamanhoLarguraGrafico;
	}
	public String getTamanhoAlturaGrafico() {
		return tamanhoAlturaGrafico;
	}
	public void setTamanhoAlturaGrafico(String tamanhoAlturaGrafico) {
		tamanhoAlturaGrafico = (tamanhoAlturaGrafico==null)?"":tamanhoAlturaGrafico;
		this.tamanhoAlturaGrafico = tamanhoAlturaGrafico;
	}
	public String getTipoGrafico() {
		return tipoGrafico;
	}
	public void setTipoGrafico(String tipoGrafico) {
		tipoGrafico = (tipoGrafico==null)?"":tipoGrafico;
		this.tipoGrafico = tipoGrafico;
	}
	public String getTipoGrafico3D() {
		return tipoGrafico3D;
	}
	public void setTipoGrafico3D(String tipoGrafico3D) {
		tipoGrafico3D = (tipoGrafico3D==null)?"":tipoGrafico3D;
		this.tipoGrafico3D = tipoGrafico3D;
	}
	public String getMerclarCelEixoY() {
		return merclarCelEixoY;
	}
	public void setMerclarCelEixoY(String merclarCelEixoY) {
		merclarCelEixoY = (merclarCelEixoY==null)?"":merclarCelEixoY;
		this.merclarCelEixoY = merclarCelEixoY;
	}
	public String getUsarTitCustomEixoY() {
		return usarTitCustomEixoY;
	}
	public void setUsarTitCustomEixoY(String usarTitCustomEixoY) {
		usarTitCustomEixoY = (usarTitCustomEixoY==null)?"":usarTitCustomEixoY;
		this.usarTitCustomEixoY = usarTitCustomEixoY;
	}
	public String getTituloCustomEixoY() {
		return tituloCustomEixoY;
	}
	public void setTituloCustomEixoY(String tituloCustomEixoY) {
		tituloCustomEixoY = (tituloCustomEixoY==null)?"":tituloCustomEixoY;
		this.tituloCustomEixoY = tituloCustomEixoY;
	}
	public String getVazioLugarZero() {
		return vazioLugarZero;
	}
	public void setVazioLugarZero(String vazioLugarZero) {
		vazioLugarZero = (vazioLugarZero==null)?"":vazioLugarZero;
		this.vazioLugarZero = vazioLugarZero;
	}
	public String getRepetirHeaderPag() {
		return repetirHeaderPag;
	}
	public void setRepetirHeaderPag(String repetirHeaderPag) {
		repetirHeaderPag = (repetirHeaderPag==null)?"":repetirHeaderPag;
		this.repetirHeaderPag = repetirHeaderPag;
	}
	public String getCodHeader() {
		return codHeader;
	}
	public void setCodHeader(String codHeader) {
		codHeader = (codHeader==null)?"":codHeader;
		this.codHeader = codHeader;
	}
	public String getCodFooter() {
		return codFooter;
	}
	public void setCodFooter(String codFooter) {
		codFooter = (codFooter==null)?"":codFooter;
		this.codFooter = codFooter;
	}
	public String getIndicadorForcaOnline() {
		return indicadorForcaOnline;
	}
	public void setIndicadorForcaOnline(String indicadorForcaOnline) {
		indicadorForcaOnline = (indicadorForcaOnline==null)?"":indicadorForcaOnline;
		this.indicadorForcaOnline = indicadorForcaOnline;
	}
	public String getCongelarCelularEixoY() {
		return congelarCelularEixoY;
	}
	public void setCongelarCelularEixoY(String congelarCelularEixoY) {
		congelarCelularEixoY = (congelarCelularEixoY==null)?"":congelarCelularEixoY;
		this.congelarCelularEixoY = congelarCelularEixoY;
	}
	public String getIndicadorPermiteOnline() {
		return indicadorPermiteOnline;
	}
	public void setIndicadorPermiteOnline(String indicadorPermiteOnline) {
		indicadorPermiteOnline = (indicadorPermiteOnline==null)?"":indicadorPermiteOnline;
		this.indicadorPermiteOnline = indicadorPermiteOnline;
	}
	public Consulta() {
		super();
	}
	public String getTituloConsulta() {
		return tituloConsulta;
	}
	public void setTituloConsulta(String tituloConsulta) {
		tituloConsulta = (tituloConsulta==null)?"":tituloConsulta;
		this.tituloConsulta = tituloConsulta;
	}
	public void setIndicadorSQLANSI(String IndicadorSQLANSI) {
		IndicadorSQLANSI = (IndicadorSQLANSI==null)?"":IndicadorSQLANSI;
		this.indicadorSQLANSI = IndicadorSQLANSI;		
	}
	public String getIndicadorSQLANSI() {
		return indicadorSQLANSI;
	}
	public Cubo getCubo() {
		return cubo;
	}
	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
	}
	public void setCompartilhamentos(List<Compartilhamento> compartilhamentos) {
		this.compartilhamentos = compartilhamentos;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Compartilhamento> getCompartilhamentos() {
		return compartilhamentos;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNiveis(List<Nivel> niveis) {
		this.niveis = niveis;
	}
	public List<Nivel> getNiveis() {
		return niveis;
	}
	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}
	public List<Propriedade> getPropriedades() {
		return propriedades;
	}	
	@Override
	public String DML(String esquemaDestino) {
		return "INSERT INTO "+esquemaDestino+".fv_consulta (\r\n"
				+ "    id_consulta,\r\n"
				+ "    id_cubo,\r\n"
				+ "    id_estilo,\r\n"
				+ "    id_estilo_cab,\r\n"
				+ "    tit_consulta,\r\n"
				+ "    des_consulta,\r\n"
				+ "    tip_visualizacao,\r\n"
				+ "    exp_filtro,\r\n"
				+ "    cod_usuario,\r\n"
				+ "    tip_filtro_dados,\r\n"
				+ "    category_id,\r\n"
				+ "    in_quebra_hierarquia_linhas,\r\n"
				+ "    in_quebra_hierarquia_colunas,\r\n"
				+ "    tip_corte_linhas,\r\n"
				+ "    tam_corte_linhas,\r\n"
				+ "    exp_corte_linhas,\r\n"
				+ "    tip_corte_colunas,\r\n"
				+ "    tam_corte_colunas,\r\n"
				+ "    exp_corte_colunas,\r\n"
				+ "    tip_orientacao,\r\n"
				+ "    tam_largura_grafico,\r\n"
				+ "    tam_altura_grafico,\r\n"
				+ "    tip_grafico,\r\n"
				+ "    tip_grafico_3d,\r\n"
				+ "    mesclar_cel_eixo_y,\r\n"
				+ "    usar_tit_custom_eixo_y,\r\n"
				+ "    tit_custom_eixo_y,\r\n"
				+ "    vazio_lugar_zero,\r\n"
				+ "    repetir_header_pag,\r\n"
				+ "    cod_header,\r\n"
				+ "    cod_footer,\r\n"
				+ "    in_sql_ansi,\r\n"
				+ "    in_forca_online,\r\n"
				+ "    congelar_cel_eixo_y,\r\n"
				+ "    in_permite_online\r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT LPAD(MAX(ID_CONSULTA)+1,6,'0') FROM "+esquemaDestino+".FV_CONSULTA),\r\n"
				+ "    (SELECT ID_CUBO FROM \r\n"
				+ "		"+esquemaDestino+".CUBO \r\n"
				+ "		WHERE TIT_CUBO = '"+this.cubo.getTitulo()+"'), \r\n"
				+ "    NULL,\r\n"
				+ "    NULL,\r\n" 
				+ "    '"+this.tituloConsulta+"',\r\n"
				+ "    '"+this.desConsulta+"',\r\n"
				+ "    '"+this.tipVisualizacao+"',\r\n"
				+ "    '"+this.expFiltro+"',\r\n"
				+ "    'admin',\r\n"
				+ "    '"+this.tipoFiltroDados+"',\r\n"
				+ "    '"+this.idCategory+"',\r\n"
				+ "    '"+this.indicadorQuebraHierarquiaLinhas+"',\r\n"
				+ "    '"+this.indicadorQuebraHierarquiaColunas+"',\r\n"
				+ "    '"+this.tipoCorteLinhas+"',\r\n"
				+ "    '"+this.tamanhoCorteLinhas+"',\r\n"
				+ "    '"+this.expressaoCorteLinhas+"',\r\n"
				+ "    '"+this.tipoCorteColunas+"',\r\n"
				+ "    '"+this.tamanhoCorteColunas+"',\r\n"
				+ "    '"+this.expressaoCorteColunas+"',\r\n"
				+ "    '"+this.tipoOrientacao+"',\r\n"
				+ "    '"+this.tamanhoLarguraGrafico+"',\r\n"
				+ "    '"+this.tamanhoAlturaGrafico+"',\r\n"
				+ "    '"+this.tipoGrafico+"',\r\n"
				+ "    '"+this.tipoGrafico3D+"',\r\n"
				+ "    '"+this.merclarCelEixoY+"',\r\n"
				+ "    '"+this.usarTitCustomEixoY+"',\r\n"
				+ "    '"+this.tituloCustomEixoY+"',\r\n"
				+ "    '"+this.vazioLugarZero+"',\r\n"
				+ "    '"+this.repetirHeaderPag+"',\r\n"
				+ "    '"+this.codHeader+"',\r\n"
				+ "    '"+this.codFooter+"',\r\n"
				+ "    '"+this.indicadorSQLANSI+"',\r\n"
				+ "    '"+this.indicadorForcaOnline+"',\r\n"
				+ "    '"+this.congelarCelularEixoY+"',\r\n"
				+ "    '"+this.indicadorPermiteOnline+"'\r\n"
				+ " FROM DUAL \r\n"
				+ " WHERE NOT EXISTS (SELECT NULL FROM "+esquemaDestino+".fv_consulta "
				+ " WHERE TIT_CONSULTA = '"+this.tituloConsulta+"'); \r\n";
	}
  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
}
