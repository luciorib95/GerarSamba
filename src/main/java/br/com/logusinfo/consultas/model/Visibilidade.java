package br.com.logusinfo.consultas.model;

public class Visibilidade implements Exportavel {
	private String id; 
	private String idCubo; 
	private Cubo cubo;
	private String codigoUsuario;
	private String codigoPerfil;
	private String expressaoFiltro;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cubo getCubo() {
		return cubo;
	}

	public void setCubo(Cubo cubo) {
		this.cubo = cubo;
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

	public String getExpressaoFiltro() {
		return expressaoFiltro;
	}

	public void setExpressaoFiltro(String expressaoFiltro) {
		this.expressaoFiltro = expressaoFiltro;
	}

	public String getIdCubo() {
		return idCubo;
	}

	public void setIdCubo(String idCubo) {
		this.idCubo = idCubo;
	}
	
	@Override
	public String DML(String esquemaDestino) {
		String sql = "INSERT INTO "+esquemaDestino+".visibilidade (\r\n"
				+ "    id_visibilidade,\r\n"
				+ "    id_cubo,\r\n"
				+ "    cod_usuario,\r\n"
				+ "    cod_perfil,\r\n"
				+ "    exp_filtro\r\n"
				+ ") SELECT \r\n"
				+ "    (SELECT LPAD(MAX(ID_VISIBILIDADE)+1,6,'0') FROM "+esquemaDestino+".VISIBILIDADE),\r\n"
				+ "    (SELECT ID_CUBO FROM "+esquemaDestino+".CUBO WHERE TIT_CUBO = '"+this.cubo.getTitulo()+"'),\r\n";
                if (null == this.codigoUsuario) {
                  sql += this.codigoUsuario + ", \r\n";
                } else {
                  sql += "'" + this.codigoUsuario + "',\r\n";
                }	
				if(null == this.codigoPerfil) {
                    sql += this.codigoPerfil + ", \r\n";
                } else {
                    sql += "'" +this.codigoPerfil+"',\r\n";
                }
				sql += "    '"+this.expressaoFiltro+"'\r\n"
				+ " FROM DUAL \r\n"
				+ " WHERE NOT EXISTS (SELECT NULL FROM "+esquemaDestino+".visibilidade WHERE "
				+ " ID_CUBO = (SELECT ID_CUBO FROM "+esquemaDestino+".CUBO WHERE TIT_CUBO = '"+this.cubo.getTitulo()+"')\r\n";
				if(null == this.codigoUsuario) {
					sql += " AND COD_USUARIO = "+this.codigoUsuario;
					
				} else {
					sql += " AND COD_USUARIO = '"+this.codigoUsuario+"'";
				}
				if(null == this.codigoPerfil) {
					sql += " AND COD_PERFIL = "+this.codigoPerfil;
				} else {
					sql += " AND COD_PERFIL = '"+this.codigoPerfil+"'";
				}
				sql += "); \r\n";
				return sql;
	}

  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
}
