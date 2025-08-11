package br.com.logusinfo.consultas.model;

public class Medida implements Exportavel{
	private String id = "";
	private String idCubo = "";
	private Cubo cubo;
	private String colMedida = "";
	private String tituloMedida = "";
	private String expressaoFiltro = "";
	private String ehPadrao = "";
	private String descricaoMedida = "";

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCubo() {
		return idCubo;
	}
	public void setIdCubo(String idCubo) {
		this.idCubo = idCubo;
	}
	public Cubo getCubo() {
		return cubo;
	}
	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
	}
	public String getColMedida() {
		return colMedida;
	}
	public void setColMedida(String colMedida) {
		this.colMedida = colMedida;
	}
	public String getTituloMedida() {
		return tituloMedida;
	}
	public void setTituloMedida(String tituloMedida) {
		this.tituloMedida = tituloMedida;
	}
	public String getExpressaoFiltro() {
		return expressaoFiltro;
	}
	public void setExpressaoFiltro(String expressaoFiltro) {
		this.expressaoFiltro = expressaoFiltro;
	}
	public String getEhPadrao() {
		return ehPadrao;
	}
	public void setEhPadrao(String ehPadrao) {
		this.ehPadrao = ehPadrao;
	}
	public String getDescricaoMedida() {
		return descricaoMedida;
	}
	public void setDescricaoMedida(String descricaoMedida) {
		this.descricaoMedida = descricaoMedida;
	}
	
	private String sqlValue(String valor) {
	    return valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'";
	}

	@Override
	public String DML(String esquemaDestino) {
	    return "INSERT INTO " + esquemaDestino + ".medida (\r\n"
	            + "    id_medida,\r\n"
	            + "    id_cubo,\r\n"
	            + "    col_medida,\r\n"
	            + "    tit_medida,\r\n"
	            + "    exp_filtro,\r\n"
	            + "    e_padrao,\r\n"
	            + "    des_medida\r\n"
	            + ") \r\n"
	            + "WITH IDMEDIDA AS (\r\n"
	            + "    SELECT LPAD(MAX(ID_MEDIDA)+1,6,'0') AS ID FROM " + esquemaDestino + ".MEDIDA\r\n"
	            + "), IDCUBO AS (\r\n"
	            + "    SELECT ID_CUBO AS ID FROM " + esquemaDestino + ".CUBO \r\n"
	            + "    WHERE TIT_CUBO = " + sqlValue(this.cubo.getTitulo()) + "\r\n"
	            + ") \r\n"
	            + "SELECT\r\n"
	            + "    IDMEDIDA.ID,\r\n"
	            + "    IDCUBO.ID,\r\n"
	            + "    " + sqlValue(this.colMedida) + ",\r\n"
	            + "    " + sqlValue(this.tituloMedida) + ",\r\n"
	            + "    " + sqlValue(this.expressaoFiltro) + ",\r\n"
	            + "    " + sqlValue(this.ehPadrao) + ",\r\n"
	            + "    " + sqlValue(this.descricaoMedida) + "\r\n"
	            + "FROM DUAL, IDCUBO, IDMEDIDA \r\n"
	            + "WHERE NOT EXISTS (\r\n"
	            + "    SELECT NULL FROM " + esquemaDestino + ".medida \r\n"
	            + "    WHERE tit_medida = " + sqlValue(this.tituloMedida) + " \r\n"
	            + "    AND id_cubo = IDCUBO.ID\r\n"
	            + ");\r\n";
	}
  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }

}
