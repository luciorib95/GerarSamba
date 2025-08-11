package br.com.logusinfo.consultas.model;

public interface Exportavel {
	String DML(String esquemaDestino);

  /**
   * @param esquemaDestino
   * @param idPropriedade
   * @return
   */
  String DML(String esquemaDestino, String idPropriedade);
}
