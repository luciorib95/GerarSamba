package br.com.logusinfo.consultas.model;

/**
 * @author lucio.santos
 *
 */
public class NivelHierarquia implements Exportavel {
  
  private Nivel nivel;
  private Hierarquia hierarquia;
  private String colunaJuncao;
  private String seqNivel;
  /**
   * @return {@link #nivel}
   */
  public Nivel getNivel() {
    return nivel;
  }
  /**
   * @param nivel atualiza {@link #nivel}.
   */
  public void setNivel(Nivel nivel) {
    this.nivel = nivel;
  }
  /**
   * @return {@link #hierarquia}
   */
  public Hierarquia getHierarquia() {
    return hierarquia;
  }
  /**
   * @param hierarquia atualiza {@link #hierarquia}.
   */
  public void setHierarquia(Hierarquia hierarquia) {
    this.hierarquia = hierarquia;
  }
  /**
   * @return {@link #colunaJuncao}
   */
  public String getColunaJuncao() {
    return colunaJuncao;
  }
  /**
   * @param colunaJuncao atualiza {@link #colunaJuncao}.
   */
  public void setColunaJuncao(String colunaJuncao) {
    this.colunaJuncao = colunaJuncao;
  }
  /**
   * @return {@link #seqNivel}
   */
  public String getSeqNivel() {
    return seqNivel;
  }
  /**
   * @param seqNivel atualiza {@link #seqNivel}.
   */
  public void setSeqNivel(String seqNivel) {
    this.seqNivel = seqNivel;
  } 

  @Override
  public String DML(String esquemaDestino, String idPropriedade) {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public String DML(String esquemaDestino) {
    // TODO Auto-generated method stub
    return null;
  }
  

}
