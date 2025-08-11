package br.com.logusinfo.consultas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.math3.ode.FirstOrderConverter;

import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.model.Esquema;
import br.com.logusinfo.consultas.repository.ConsultasRepository;
import br.com.logusinfo.consultas.repository.EsquemasRepository;

public class EsquemasService {
	
	private List<Esquema> esquemas; 

	public List<Esquema> getEsquemas() {
		if(null==esquemas || esquemas.size()==0) {
			EsquemasRepository repository = new EsquemasRepository();
			esquemas = repository.getEsquemas();
		}
		return esquemas;
	}

	public String[] getNomesEsquemas() {
		List<Esquema> esquemas = getEsquemas();
		String items[] = new String[esquemas.size()];
		int cont = 0;
		for (Esquema esquema : esquemas) {
			items[cont] = esquema.getNome();
			cont++;
		}
		return items;
	}
}
