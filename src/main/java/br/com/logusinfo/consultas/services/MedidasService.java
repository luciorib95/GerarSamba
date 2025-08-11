package br.com.logusinfo.consultas.services;

import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.consultas.model.Medida;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.repository.MedidasRepository;

public class MedidasService {
	private String esquemaOrigem;

	public MedidasService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public Medida getMedida(Node node) {
		String idMedida = node.getIdMedida();
		if(idMedida.isBlank()) {
			return new Medida();
		}
		MedidasRepository repository = new MedidasRepository(esquemaOrigem);
		Medida medida = repository.getMedida(idMedida);
		return medida;
	}
	
	   /**	  
	   * Busca medidas que estão no cubo mas não na consulta
	   */
	  public List<Medida> getMedidasCubo(String tituloCubo, String tituloConsulta) {
	        MedidasRepository repository = new MedidasRepository(esquemaOrigem);
	        List<Medida> medidas = repository.getMedidasCubo(tituloCubo, tituloConsulta);      
	        return medidas;
	    }
}
