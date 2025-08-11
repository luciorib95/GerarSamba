package br.com.logusinfo.consultas.model;

public class Compartilhamento implements Exportavel {
	// ID_COMPARTILHAMENTO, ID_CUBO, ID_CONSULTA, COD_USUARIO, COD_PERFIL, ID_DASHBOARD
	private String id;
	private String idCubo;
	private String idConsulta;
	private String idDashboard;
	private String codigoUsuario;
	private String codigoPerfil;
	private Consulta consulta;
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
	public String getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getIdDashboard() {
		return idDashboard;
	}
	public void setIdDashboard(String idDashboard) {
		this.idDashboard = idDashboard;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	
	@Override
	public String DML(String esquemaDestino) {
	    String tituloConsulta = this.consulta.getTituloConsulta();

	    String codigoUsuario = (this.codigoUsuario == null) ? "null" : "'" + this.codigoUsuario + "'";
	    String codigoPerfil = (this.codigoPerfil == null) ? "null" : "'" + this.codigoPerfil + "'";
	    String idDashboard = (this.idDashboard == null) ? "null" : "'" + this.idDashboard + "'";

	    String sql = 
	        "INSERT INTO " + esquemaDestino + ".compartilhamento (\n" +
	        "    id_compartilhamento,\n" +
	        "    id_consulta,\n" +
	        "    cod_usuario,\n" +
	        "    cod_perfil,\n" +
	        "    id_dashboard\n" +
	        ")\n" +
	        "SELECT \n" +
	        "    'Q' || id_consulta_base || '_' || NVL(sequencial, 0),\n" +
	        "    id_consulta_base,\n" +
	        "    " + codigoUsuario + ",\n" +
	        "    " + codigoPerfil + ",\n" +
	        "    " + idDashboard + "\n" +
	        "FROM (\n" +
	        "    SELECT\n" +
	        "        (SELECT ID_CONSULTA FROM " + esquemaDestino + ".FV_CONSULTA WHERE TIT_CONSULTA = '" + tituloConsulta + "') AS id_consulta_base,\n" +
	        "        (SELECT SUBSTR(MAX(ID_COMPARTILHAMENTO), INSTR(MAX(ID_COMPARTILHAMENTO), '_', 3) + 1) + 1\n" +
	        "         FROM " + esquemaDestino + ".COMPARTILHAMENTO\n" +
	        "         WHERE id_consulta = (SELECT ID_CONSULTA FROM " + esquemaDestino + ".FV_CONSULTA WHERE TIT_CONSULTA = '" + tituloConsulta + "')) AS sequencial\n" +
	        "    FROM DUAL\n" +
	        ");\n";

	    return sql;
	}
  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }

}
