package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Filtro;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.repository.FiltrosRepository;
import br.com.logusinfo.consultas.repository.NodesRepository;

public class FiltrosService {
	private String esquemaOrigem;

	public FiltrosService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public Filtro getFiltro(Node node) {
		String idFiltro = node.getIdFiltro();
		FiltrosRepository repository = new FiltrosRepository(esquemaOrigem);
		Filtro filtro = repository.getFiltro(idFiltro);
		return filtro;
	}
}
