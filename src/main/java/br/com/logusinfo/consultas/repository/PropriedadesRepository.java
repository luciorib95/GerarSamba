package br.com.logusinfo.consultas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.logusinfo.consultas.ConnUtil;
import br.com.logusinfo.consultas.ConnectionException;
import br.com.logusinfo.consultas.model.Propriedade;

public class PropriedadesRepository {

	private Connection connection;

	private PreparedStatement pstmt;

	private StringBuilder sql;

	private String esquemaOrigem;

	public PropriedadesRepository(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

    public List<Propriedade> getPropriedades(String idConsulta) {
      List<Propriedade> propriedades = new ArrayList<Propriedade>();
      try {
          connection = ConnUtil.init();
          sql = new StringBuilder();
          sql.append("SELECT\r\n"
                      + "    b.id_propriedade,\r\n"
                      + "    b.id_nivel,\r\n"
                      + "    b.nom_coluna,\r\n"
                      + "    b.tit_propriedade,\r\n"
                      + "    b.chave,\r\n"
                      + "    b.desc_padrao,\r\n"
                      + "    b.tip_propriedade,\r\n"
                      + "    b.oculta,\r\n"
                      + "    b.georef,\r\n"
                      + "    a.id_consulta,\r\n"
                      + "    a.id_eixo,\r\n"
                      + "    a.id_estilo,\r\n"
                      + "    a.seq_no,\r\n"
                      + "    a.seq_propriedade_no\r\n"
                      + " FROM\r\n"
                      + "    "+esquemaOrigem+".fv_propriedade_no a \r\n"
                      + " LEFT JOIN "+esquemaOrigem+".propriedade b ON a.id_propriedade = b.id_propriedade \r\n"
                      + " WHERE \r\n"
                      + "    a.id_consulta = ?");
          
          pstmt = connection.prepareStatement(sql.toString()); 
          pstmt.setString(1, idConsulta);
          ResultSet rs = pstmt.executeQuery();
          
	        while (rs.next()) {
	            Propriedade propriedade = new Propriedade();
	            propriedade.setId(rs.getString(1));
	            propriedade.setIdNivel(rs.getString(2));
	            propriedade.setNomeColuna(rs.getString(3));
	            propriedade.setTitPropriedade(rs.getString(4));
	            propriedade.setChave(rs.getString(5));
	            propriedade.setDescricaoPadrao(rs.getString(6));
	            propriedade.setTipoPropriedade(rs.getString(7));
	            propriedade.setEhOculta(rs.getString(8));
	            propriedade.setGeoRef(rs.getString(9));
	            propriedade.setIdConsulta(rs.getString(10));
	            propriedade.setIdEixo(rs.getString(11));
	            propriedade.setIdEstilo(rs.getString(12));
	            propriedade.setSeqNo(rs.getString(13));
	            propriedade.setSeqPropriedadeNo(rs.getString(14));
	            propriedades.add(propriedade);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (ConnectionException | SQLException e) {
	        e.printStackTrace();
	    }

	    return propriedades;
    }
    
    public List<Propriedade> getPropriedadeNiveis(String idConsulta) {
      List<Propriedade> propriedades = new ArrayList<>();

      try {
          connection = ConnUtil.init();
          sql = new StringBuilder();

          sql.append("SELECT\n")
             .append("    p.ID_PROPRIEDADE,\n")
             .append("    p.ID_NIVEL,\n")
             .append("    p.NOM_COLUNA,\n")
             .append("    p.TIT_PROPRIEDADE,\n")
             .append("    p.CHAVE,\n")
             .append("    p.DESC_PADRAO,\n")
             .append("    p.TIP_PROPRIEDADE,\n")
             .append("    p.OCULTA,\n")
             .append("    p.GEOREF\n")
             .append("FROM\n")
             .append("    ").append(esquemaOrigem).append(".PROPRIEDADE p\n")
             .append("WHERE\n")
             .append("    p.ID_NIVEL IN (\n")
             .append("        SELECT nc.ID_NIVEL\n")
             .append("        FROM ").append(esquemaOrigem).append(".NIVEL_CUBO nc\n")
             .append("        WHERE nc.ID_CUBO = (\n")
             .append("            SELECT fc.ID_CUBO\n")
             .append("            FROM ").append(esquemaOrigem).append(".FV_CONSULTA fc\n")
             .append("            WHERE fc.ID_CONSULTA = ?\n")
             .append("        )\n")
             .append("    )\n")
             .append("    AND p.ID_PROPRIEDADE NOT IN (\n")
             .append("        SELECT a.ID_PROPRIEDADE\n")
             .append("        FROM ").append(esquemaOrigem).append(".FV_PROPRIEDADE_NO a\n")
             .append("        WHERE a.ID_CONSULTA = ?\n")
             .append("    )");

          pstmt = connection.prepareStatement(sql.toString());
          pstmt.setString(1, idConsulta);
          pstmt.setString(2, idConsulta); 

          ResultSet rs = pstmt.executeQuery();

          while (rs.next()) {
              Propriedade propriedade = new Propriedade();
              propriedade.setId(rs.getString(1));
              propriedade.setIdNivel(rs.getString(2));
              propriedade.setNomeColuna(rs.getString(3));
              propriedade.setTitPropriedade(rs.getString(4));
              propriedade.setChave(rs.getString(5));
              propriedade.setDescricaoPadrao(rs.getString(6));
              propriedade.setTipoPropriedade(rs.getString(7));
              propriedade.setEhOculta(rs.getString(8));
              propriedade.setGeoRef(rs.getString(9));

              propriedades.add(propriedade);
          }

          rs.close();
          pstmt.close();

      } catch (ConnectionException | SQLException e) {
          e.printStackTrace();
      }

      return propriedades;
  }
    
    public List<Propriedade> getPropriedadesForaCubo(String idCubo) {
      List<Propriedade> propriedades = new ArrayList<>();

      try {
          connection = ConnUtil.init();
          sql = new StringBuilder();

          sql.append("SELECT * FROM ").append(esquemaOrigem).append(".PROPRIEDADE p WHERE p.ID_NIVEL IN (")
             .append("SELECT n.ID_NIVEL ")
             .append("FROM ").append(esquemaOrigem).append(".NIVEL n ")
             .append("WHERE n.ID_DIMENSAO IN (")
             .append("    SELECT DISTINCT n2.ID_DIMENSAO ")
             .append("    FROM ").append(esquemaOrigem).append(".NIVEL n2 ")
             .append("    JOIN ").append(esquemaOrigem).append(".NIVEL_CUBO nc2 ON n2.ID_NIVEL = nc2.ID_NIVEL ")
             .append("    WHERE nc2.ID_CUBO = ?")
             .append(") ")
             .append("AND n.ID_NIVEL NOT IN (")
             .append("    SELECT nc3.ID_NIVEL ")
             .append("    FROM ").append(esquemaOrigem).append(".NIVEL_CUBO nc3 ")
             .append("    WHERE nc3.ID_CUBO = ?")
             .append("))");

          pstmt = connection.prepareStatement(sql.toString());
          pstmt.setString(1, idCubo);
          pstmt.setString(2, idCubo);

          ResultSet rs = pstmt.executeQuery();

          while (rs.next()) {
              Propriedade propriedade = new Propriedade();
              propriedade.setId(rs.getString("ID_PROPRIEDADE"));
              propriedade.setIdNivel(rs.getString("ID_NIVEL"));
              propriedade.setNomeColuna(rs.getString("NOM_COLUNA"));
              propriedade.setTitPropriedade(rs.getString("TIT_PROPRIEDADE"));
              propriedade.setChave(rs.getString("CHAVE"));
              propriedade.setDescricaoPadrao(rs.getString("DESC_PADRAO"));
              propriedade.setTipoPropriedade(rs.getString("TIP_PROPRIEDADE"));
              propriedade.setEhOculta(rs.getString("OCULTA"));
              propriedade.setGeoRef(rs.getString("GEOREF"));

              propriedades.add(propriedade);
          }

          rs.close();
          pstmt.close();

      } catch (ConnectionException | SQLException e) {
          e.printStackTrace();
      }

      return propriedades;
  }

}
