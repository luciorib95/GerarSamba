package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.repository.NodesRepository;

public class NodesService {
	private String esquemaOrigem;

	public NodesService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<Node> getNodes(Consulta consulta) {
		String idConsulta = consulta.getIdConsulta();
		NodesRepository repository = new NodesRepository(esquemaOrigem);
		List<Node> nodes = repository.getNodes(idConsulta);
		return nodes;
	}
}
