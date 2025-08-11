package br.com.logusinfo.consultas.services;

import java.util.List;

import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.model.Propriedade;
import br.com.logusinfo.consultas.repository.NiveisRepository;

public class NiveisService {
	private String esquemaOrigem;
	private NiveisRepository repository;

	public NiveisService(String esquemaOrigem) {
		repository = new NiveisRepository(esquemaOrigem);
		this.esquemaOrigem = esquemaOrigem;
		// TODO Auto-generated constructor stub
	}

	public List<Nivel> getNiveis(Cubo cubo) {
		String idCubo = cubo.getId();
		List<Nivel> niveis = repository.getNiveisCubo(idCubo);
		return niveis;
	}

	public Nivel getNivel(Node node) {
		String idNivel = node.getIdNivel();
		Nivel nivel = repository.getNivel(idNivel);
		return nivel;
	}

	public Nivel getNivel(Propriedade propriedade) {
		String idNivel = propriedade.getIdNivel();
		Nivel nivel = repository.getNivel(idNivel);
		return nivel;
	}
}
