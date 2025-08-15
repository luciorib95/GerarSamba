package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Hierarquia;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.repository.DimensoesRepository;
import br.com.logusinfo.consultas.repository.HierarquiasRepository;

public class HierarquiasService {

  HierarquiasRepository repository = null;
	private String esquemaOrigem;
	
	public HierarquiasService(String esquemaOrigem) {
		repository = new HierarquiasRepository(esquemaOrigem);
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<Hierarquia> getHierarquias(Dimensao dimensao) {
		List<Hierarquia> hierarquias = repository.getHierarquias(dimensao);	  
		return hierarquias;
	}

}
