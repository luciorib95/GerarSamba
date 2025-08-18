package br.com.logusinfo.consultas.model;

import java.util.ArrayList;
import java.util.List;

public class Hierarquia implements Exportavel{
    private String id = "";
    private Dimensao dimensao;
    private String titulo = "";
    private List<NivelHierarquia> niveisHierarquia = new ArrayList<>();

    /**
     * @return {@link #dimensao}
     */
    public Dimensao getDimensao() {
      return dimensao;
    }

    /**
     * @param dimensao atualiza {@link #dimensao}.
     */
    public void setDimensao(Dimensao dimensao) {
      this.dimensao = dimensao;
    }

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

    /**
     * @return {@link #niveisHierarquia}
     */
    public List<NivelHierarquia> getNiveisHierarquia() {
      return niveisHierarquia;
    }

    /**
     * @param niveisHierarquia atualiza {@link #niveisHierarquia}.
     */
    public void setNiveisHierarquia(List<NivelHierarquia> niveisHierarquia) {
      this.niveisHierarquia = niveisHierarquia;
    }
    
    private String sqlValue(String valor) {
      return valor == null ? null : "'" + valor.replace("'", "''") + "'";
    }

    public String DML(String esquemaDestino) {
      String dml = "INSERT INTO " + esquemaDestino + ".HIERARQUIA (\n" 
               + "    ID_HIERARQUIA,\n" 
               + "    ID_DIMENSAO,\n" 
               + "    TIT_HIERARQUIA\n" 
               + ") SELECT \r\n"
               + "    (SELECT LPAD(MAX(ID_HIERARQUIA)+1,6,'0') FROM " + esquemaDestino + ".HIERARQUIA),\r\n" 
               + "    (SELECT ID_DIMENSAO FROM " + esquemaDestino + ".DIMENSAO \r\n"
               + "      WHERE TIT_DIMENSAO = '" + this.getDimensao().getTitulo() + "'),\r\n"
               + "    " + sqlValue(this.titulo) + "\r\n"
               + " FROM DUAL\r\n"
               + "WHERE NOT EXISTS (\n" 
               + "    SELECT NULL FROM " + esquemaDestino + ".HIERARQUIA \n" 
               + "    WHERE TIT_HIERARQUIA = " + sqlValue(this.titulo) + " \n" 
               + "   AND ID_DIMENSAO = (SELECT ID_DIMENSAO FROM " + esquemaDestino + ".DIMENSAO \r\n"
               + "      WHERE TIT_DIMENSAO = '" + this.getDimensao().getTitulo() + "')\r\n"
               + ");\r\n";
        
        for (NivelHierarquia nivelhierarquia : this.getNiveisHierarquia()) {
          if (!nivelhierarquia.equals(null)) {
            dml += "\n-- NIVEL HIERARQUIA ----------------------\n";
            dml += "INSERT INTO " + esquemaDestino + ".nivel_hierarquia (\r\n"
                + "    ID_HIERARQUIA,\r\n"
                + "    ID_NIVEL,\r\n"
                + "    COL_JOIN,\r\n"
                + "    SEQ_NIVEL\r\n"
                + ") SELECT \r\n"
                + "    (SELECT ID_HIERARQUIA FROM " + esquemaDestino + ".HIERARQUIA \r\n"
                + "     WHERE TIT_HIERARQUIA = '" + this.titulo + "'),\r\n"
                + "    (SELECT N.ID_NIVEL FROM " + esquemaDestino + ".NIVEL N \r\n"
                + "     JOIN " + esquemaDestino + ".DIMENSAO D ON N.ID_DIMENSAO = D.ID_DIMENSAO \r\n"
                + "     WHERE N.TIT_NIVEL = '" + nivelhierarquia.getNivel().getTitulo() + "' \r\n"
                + "       AND D.TIT_DIMENSAO = '" + this.getDimensao().getTitulo() + "'),\r\n"
                + "    " + sqlValue(nivelhierarquia.getColunaJuncao()) + ",\r\n"
                + "    '" + nivelhierarquia.getSeqNivel() + "'\r\n"
                + " FROM DUAL\r\n"
                + " WHERE NOT EXISTS (\r\n"
                + "    SELECT NULL FROM " + esquemaDestino + ".nivel_hierarquia \r\n"
                + "    WHERE ID_HIERARQUIA = (SELECT ID_HIERARQUIA FROM " + esquemaDestino + ".HIERARQUIA \r\n"
                + "                    WHERE TIT_HIERARQUIA = '" + this.titulo + "')\r\n"
                + "      AND ID_NIVEL = (SELECT N.ID_NIVEL FROM " + esquemaDestino + ".NIVEL N \r\n"
                + "                      JOIN " + esquemaDestino + ".DIMENSAO D ON N.ID_DIMENSAO = D.ID_DIMENSAO \r\n"
                + "                      WHERE N.TIT_NIVEL = '" + nivelhierarquia.getNivel().getTitulo() + "' \r\n"
                + "                        AND D.TIT_DIMENSAO = '" + this.getDimensao().getTitulo() + "')\r\n"
                + ");\r\n";
          }
        }
        
        return dml;
    }

    @Override
    public String DML(String esquemaDestino, String idPropriedade) {
      // TODO Auto-generated method stub
      return null;
    }
}
