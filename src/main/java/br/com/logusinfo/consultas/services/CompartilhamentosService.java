package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Compartilhamento;
import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.repository.CompartilhamentosRepository;

public class CompartilhamentosService {
	private String esquemaOrigem;

	public CompartilhamentosService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Compartilhamento> getCompartilhamentos(Consulta consulta) {
		String idConsulta = consulta.getIdConsulta();
		CompartilhamentosRepository repository = new CompartilhamentosRepository(esquemaOrigem);
		List<Compartilhamento> compartilhamentos = repository.getCompartilhamentos(idConsulta);
		return compartilhamentos;
	}
}
