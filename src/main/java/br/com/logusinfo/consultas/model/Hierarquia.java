package br.com.logusinfo.consultas.model;

/**
 * @author lucio.santos
 *
 */
public class Hierarquia {
  private String id = "";
  private String idDimensao = "";
  private String titulo = "";
  
  
  /**
   * @return {@link #idDimensao}
   */
  public String getIdDimensao() {
    return idDimensao;
  }
  /**
   * @param idDimensao atualiza {@link #idDimensao}.
   */
  public void setIdDimensao(String idDimensao) {
    this.idDimensao = idDimensao;
  }
  
  
  /**
   * @return {@link #id}
   */
  public String getId() {
    return id;
  }
  /**
   * @param id atualiza {@link #id}.
   */
  public void setId(String id) {
    this.id = id;
  }
  /**
   * @return {@link #titulo}
   */
  public String getTitulo() {
    return titulo;
  }
  /**
   * @param titulo atualiza {@link #titulo}.
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
}
