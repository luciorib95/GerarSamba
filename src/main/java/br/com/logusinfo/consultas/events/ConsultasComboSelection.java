package br.com.logusinfo.consultas.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;

public class ConsultasComboSelection implements SelectionListener {

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		System.out.println("selected");
	}

	@Override
	public void widgetSelected(SelectionEvent evt) {
		Combo source = (Combo)evt.getSource();		
		System.out.println(source.getText());
	}

}
