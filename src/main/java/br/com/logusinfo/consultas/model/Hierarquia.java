package br.com.logusinfo.consultas.model;

import java.util.ArrayList;
import java.util.List;

public class Hierarquia implements Exportavel{
    private String id = "";
    private String idDimensao = "";
    private String titulo = "";
    private List<NivelHierarquia> niveisHierarquia = new ArrayList<>();
    
    public String getIdDimensao() {
        return idDimensao;
    }

    public void setIdDimensao(String idDimensao) {
        this.idDimensao = idDimensao;
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

    private String sqlValue(String valor) {
        return valor == null ? "NULL" : "'" + valor.replace("'", "''") + "'";
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

    public String DML(String esquemaDestino) {
        return "INSERT INTO " + esquemaDestino + ".HIERARQUIA (\n" +
               "    ID_HIERARQUIA,\n" +
               "    ID_DIMENSAO,\n" +
               "    TIT_HIERARQUIA\n" +
               ") \n" +
               "WITH IDHIERARQUIA AS (\n" +
               "    SELECT LPAD(MAX(ID_HIERARQUIA)+1,6,'0') AS ID FROM " + esquemaDestino + ".HIERARQUIA\n" +
               ")\n" +
               "SELECT\n" +
               "    IDHIERARQUIA.ID,\n" +
               "    " + sqlValue(this.idDimensao) + ",\n" +
               "    " + sqlValue(this.titulo) + "\n" +
               "FROM DUAL, IDHIERARQUIA\n" +
               "WHERE NOT EXISTS (\n" +
               "    SELECT NULL FROM " + esquemaDestino + ".HIERARQUIA \n" +
               "    WHERE TIT_HIERARQUIA = " + sqlValue(this.titulo) + " \n" +
               "    AND ID_DIMENSAO = " + sqlValue(this.idDimensao) + "\n" +
               ");";
    }

    @Override
    public String DML(String esquemaDestino, String idPropriedade) {
      // TODO Auto-generated method stub
      return null;
    }
}
