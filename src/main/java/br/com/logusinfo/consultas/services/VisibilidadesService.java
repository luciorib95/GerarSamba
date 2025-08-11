package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Visibilidade;
import br.com.logusinfo.consultas.repository.VisibilidadesRepository;

public class VisibilidadesService {
	private String esquemaOrigem;

	public VisibilidadesService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<Visibilidade> getVisibilidades(Cubo cubo) {
		String idCubo = cubo.getId();
		VisibilidadesRepository repository = new VisibilidadesRepository(esquemaOrigem);
		List<Visibilidade> visibilidades = repository.getVisibilidades(idCubo);
		visibilidades.stream().forEach(v->{v.setCubo(cubo);});
		return visibilidades;
	}
}
