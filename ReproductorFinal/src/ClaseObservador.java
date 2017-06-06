import java.util.Observable;

import javax.swing.JPanel;

public class ClaseObservador extends Observable {
	public int contentPaneSeleccionado;
	public JPanel panel;
	
	public ClaseObservador(){
		
	}
	
	public void setPanel(int contentPaneSeleccionado){
		this.contentPaneSeleccionado=contentPaneSeleccionado;
		setChanged();
		
	    notifyObservers();
	
	}
	
	public int getPanelSeleccionado() {
		
		return contentPaneSeleccionado;
	}

	public void setVista(JPanel panel) {
		
		this.panel=panel;
		//notifyObservers();

	
		
	}
	public JPanel getVista(){
		//notifyObservers();
		return panel;
		
	}

}
