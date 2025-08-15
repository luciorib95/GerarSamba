package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.Nivel;
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

	public List<NivelHierarquia> getNiveisHierarquiasgetNiveisHierarquias(Hierarquia hierarquia, Nivel nivel) {
		List<NivelHierarquia> niveisHierarquias = repository.getNiveisHierarquias(hierarquia,nivel);	  
		return niveisHierarquias;
	}

}
