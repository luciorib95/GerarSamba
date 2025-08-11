package br.com.logusinfo.consultas;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.logusinfo.consultas.events.ConsultasComboSelection;
import br.com.logusinfo.consultas.events.GerarSelection;
import br.com.logusinfo.consultas.services.ConsultasService;
import br.com.logusinfo.consultas.services.EsquemasService;

public class SeletorConsulta {

	private Display display;
	private Shell shell;
	private String esquemaOrigem;
	private String esquemaDestino;
	//TODO Implementar DML de Propriedades, Medidas e Filtros.
	//TODO Implementar botão de Cópia. 
	public SeletorConsulta() {
		display = new Display();
		shell = new Shell(display);
		shell.setLocation(350, 100);
		shell.setSize(500, 500);
		shell.setText("Gera Samba");
		GridLayout gridLayout = new GridLayout(4, false);
		shell.setLayout(gridLayout);
		
		EsquemasService esquemasService = new EsquemasService();
		new Label(shell, SWT.NONE).setText("Esquema Origem");
		final Combo comboEsquemasOrigem = new Combo(shell, SWT.DROP_DOWN | SWT.WRAP);
		GridData data1 = new GridData();
		data1.widthHint = 300;
		data1.horizontalSpan=4;
		comboEsquemasOrigem.setLayoutData(data1);
		comboEsquemasOrigem.setItems(esquemasService.getNomesEsquemas());
		
		new Label(shell, SWT.NONE).setText("Esquema Destino");
		final Combo comboEsquemasDestino = new Combo(shell, SWT.DROP_DOWN | SWT.WRAP);
		GridData data2 = new GridData();
		data2.widthHint = 300;
		data2.horizontalSpan=4;
		comboEsquemasDestino.setLayoutData(data2);
		comboEsquemasDestino.setItems(esquemasService.getNomesEsquemas());
		
		new Label(shell, SWT.NONE).setText("Consultas Origem");
		final Combo comboConsultas = new Combo(shell, SWT.DROP_DOWN | SWT.WRAP);
		GridData data3 = new GridData();
		data3.widthHint = 300;
		data3.horizontalSpan=4;
		comboConsultas.setLayoutData(data3);
		comboConsultas.setBounds(50, 50, 300, 100);
		
		Button buttonGera = new Button(shell, SWT.BUTTON1);
		buttonGera.setText("Gera");
		buttonGera.setEnabled(false);
		
		Text textArea = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
	    GridData gridData = new GridData(GridData.FILL_BOTH);
	    gridData.horizontalSpan = 4;
		textArea.setLayoutData(gridData);
		GerarSelection gerarSelection = new GerarSelection(comboConsultas, textArea);
		buttonGera.addSelectionListener(gerarSelection);

		comboEsquemasOrigem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent evt) {
				Combo source = (Combo)evt.getSource();
				esquemaOrigem = source.getText();
				gerarSelection.setEsquemaOrigem(esquemaOrigem);
				ConsultasService consultasService = new ConsultasService(esquemaOrigem);
				comboConsultas.setItems(consultasService.getTitulosConsultas());
				comboConsultas.addSelectionListener(new ConsultasComboSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent evt) {
				System.out.println(evt.getSource().toString());
			}
		});
		
		comboEsquemasDestino.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent evt) {
				Combo source = (Combo)evt.getSource();
				esquemaDestino = source.getText();
				buttonGera.setEnabled(true);
				gerarSelection.setEsquemaDestino(esquemaDestino);
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String[] argv) {
		new SeletorConsulta();
	}
}
