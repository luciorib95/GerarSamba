package br.com.logusinfo.consultas.services;

import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.repository.DimensoesRepository;

public class DimensoesService {

	DimensoesRepository repository = null;
	private String esquemaOrigem;
	
	public DimensoesService(String esquemaOrigem) {
		repository = new DimensoesRepository(esquemaOrigem);
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public Dimensao getDimensao(Nivel nivel) {
		String idDimensao = nivel.getIdDimensao();
		Dimensao dimensao = repository.getDimensao(idDimensao);
		return dimensao;
	}

}
