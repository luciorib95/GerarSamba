package br.com.logusinfo.consultas.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import br.com.logusinfo.consultas.model.Consulta;
import br.com.logusinfo.consultas.services.DiscoveryService;
import br.com.logusinfo.consultas.services.ScriptsService;

public class GerarSelection implements SelectionListener {

	private Text textArea;
	private Combo c;
	private String idConsulta;
	private String esquemaOrigem;
	private String esquemaDestino;

	public GerarSelection(Combo c, Text textArea) {
		this.c = c;
		this.textArea = textArea;
	}

	public void setEsquemaOrigem(String esquemaOrigem) {
		this.esquemaOrigem = esquemaOrigem;
	}

	public void setEsquemaDestino(String esquemaDestino) {
		this.esquemaDestino = esquemaDestino;
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		System.out.println("selected");
	}

	@Override
	public void widgetSelected(SelectionEvent evt) {
		// Script.
		StringBuilder scriptDML = new StringBuilder("--SAMBA\n");
		// Inicializo serviços.
		DiscoveryService discoveryService = new DiscoveryService(esquemaOrigem);
		String opcaoConsulta = this.c.getText();
		Consulta consulta = discoveryService.discover(opcaoConsulta);
		ScriptsService service = new ScriptsService(esquemaDestino);
		scriptDML = service.generate(scriptDML,  consulta);
		print(scriptDML.toString());
	}

	

	private void print(String text) {
		textArea.append(text+"\n");
	}

}
