package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.NivelHierarquia;
import br.com.logusinfo.consultas.repository.NiveisHierarquiasRepository;

public class NiveisHierarquiasService {

  NiveisHierarquiasRepository repository = null;
	private String esquemaOrigem;
	
	public NiveisHierarquiasService(String esquemaOrigem) {
		repository = new NiveisHierarquiasRepository(esquemaOrigem);
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<NivelHierarquia> getNiveisHierarquias(String idHierarquia) {
		List<NivelHierarquia> niveisHierarquias = repository.getNiveisHierarquias(idHierarquia);	  
		return niveisHierarquias;
	}

}
