package br.com.logusinfo.consultas.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Text;

import br.com.logusinfo.consultas.model.Compartilhamento;
import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Cubo;
import br.com.logusinfo.consultas.model.Dimensao;
import br.com.logusinfo.consultas.model.Filtro;
import br.com.logusinfo.consultas.model.Medida;
import br.com.logusinfo.consultas.model.Nivel;
import br.com.logusinfo.consultas.model.Node;
import br.com.logusinfo.consultas.model.Propriedade;
import br.com.logusinfo.consultas.model.Visibilidade;

public class DiscoveryService {
	private Text textArea;
	private String idConsulta;
	private String esquemaOrigem;	
	List<String> propriedadesForaConsultaId;
	
	public DiscoveryService(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public Consulta discover(String opcaoConsulta) {
		// Services
		ConsultasService consultasService = new ConsultasService(esquemaOrigem);
		CompartilhamentosService compartilhamentosService = new CompartilhamentosService(esquemaOrigem);
		CubosService cubosService = new CubosService(esquemaOrigem);
		VisibilidadesService visibilidadesService = new VisibilidadesService(esquemaOrigem);
		MedidasService medidasService = new MedidasService(esquemaOrigem);
		NodesService nodesService = new NodesService(esquemaOrigem);
		FiltrosService filtrosService = new FiltrosService(esquemaOrigem);
		PropriedadesService propriedadesService = new PropriedadesService(esquemaOrigem);
		NiveisService niveisService = new NiveisService(esquemaOrigem);
		DimensoesService dimensoesService = new DimensoesService(esquemaOrigem);
		
		// Recupero o ID da Consulta.
		idConsulta = consultasService.getIdConsulta(opcaoConsulta);
		
		// Recupero o Objeto Consulta.
		Consulta consulta = consultasService.getConsulta(idConsulta);
		
		// Atribui a coleção de compartilhamentos à consulta.
		List<Compartilhamento> compartilhamentos = compartilhamentosService.getCompartilhamentos(consulta);
		for (Compartilhamento compartilhamento : compartilhamentos) {
			compartilhamento.setConsulta(consulta);
		}
		consulta.setCompartilhamentos(compartilhamentos);
		
		// Atribui o objeto cubo à consulta.
		Cubo cubo = cubosService.getCubo(consulta);
		consulta.setCubo(cubo);

		// Atribui a coleção de objetos de visibilidade ao cubo.
		List<Visibilidade> visibilidades = visibilidadesService.getVisibilidades(cubo);
		cubo.setVisibilidades(visibilidades);
		
		List<Node> nodes = nodesService.getNodes(consulta);
		for (Node node : nodes) {
			Nivel nivel = niveisService.getNivel(node);
			Dimensao dimensao = dimensoesService.getDimensao(nivel);
			nivel.setDimensao(dimensao);
			nivel.setCubo(cubo);
			node.setNivel(nivel);
			Filtro filtro = filtrosService.getFiltro(node);
			filtro.setCubo(cubo);
			node.setFiltro(filtro);
			Medida medida = medidasService.getMedida(node);
			medida.setCubo(cubo);
			node.setMedida(medida);
			node.setConsulta(consulta);
		}
		consulta.setNodes(nodes);
		List<Nivel> niveis = niveisService.getNiveis(cubo);
		for (Nivel nivel : niveis) {			
			Dimensao dimensao = dimensoesService.getDimensao(nivel);
			nivel.setDimensao(dimensao);
		}
		cubo.setNiveis(niveis);
		cubo.setMedidasCubo(medidasService.getMedidasCubo(cubo.getTitulo(), consulta.getTituloConsulta()));
		
		List<Propriedade> propriedades = propriedadesService.getPropriedades(consulta);
		for (Propriedade propriedade : propriedades) {
			Nivel nivel = niveisService.getNivel(propriedade);
			Dimensao dimensao = dimensoesService.getDimensao(nivel);
			nivel.setDimensao(dimensao);
			propriedade.setNivel(nivel);
			propriedade.setConsulta(consulta);
		}
		consulta.setPropriedades(propriedades);
		return consulta;
	}
}
