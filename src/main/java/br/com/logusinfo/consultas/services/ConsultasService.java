package br.com.logusinfo.consultas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.repository.ConsultasRepository;

public class ConsultasService {
	
	private List<Consulta> consultas;
	private String esquemaOrigem; 

	public ConsultasService(String esquemaOrigem) {
		super();
		this.esquemaOrigem = esquemaOrigem;
	}

	public List<Consulta> getConsultas() {
		if(null==consultas || consultas.size()==0) {
			ConsultasRepository repository = new ConsultasRepository(esquemaOrigem);
			consultas = repository.getConsultas();
		}
		return consultas;
	}
	
	public Consulta getConsulta(String idConsulta) {
		consultas = getConsultas();
		Stream<Consulta> resultado = consultas.stream().filter((Consulta c) ->{
				return idConsulta.equals(c.getIdConsulta());
		});
		Optional<Consulta> first = resultado.findFirst();
		Consulta consulta = first.get();		
		return consulta;
	}

	public String[] getTitulosConsultas() {
		List<Consulta> consultas = getConsultas();
		String items[] = new String[consultas.size()];
		int cont = 0;
		for (Consulta consulta : consultas) {
			items[cont] = consulta.getIdConsulta() + " - " + consulta.getTituloConsulta();
			cont++;
		}
		return items;
	}
	

	public String getIdConsulta(String text) {
		return text.split("-")[0].trim();
	}

}
