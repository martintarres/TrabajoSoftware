import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class Vista extends JFrame implements Observer {

	
	ClaseObservador miObservador;
	ClaseObservador miObser;
	int seleccion;
	VistaPrincipal vistaprincipal;
	VistaListaReproduccion vistalistareproduccion;
		
		public Vista(ClaseObservador observador){
			miObservador=observador;
			miObser=observador;
			
			setTitle("Reproductor Musical");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setVisible(true);
			
			vistaprincipal= new VistaPrincipal(observador);
			observador.addObserver(vistaprincipal);
			
			vistalistareproduccion = new VistaListaReproduccion(observador);
			observador.addObserver(vistalistareproduccion);
			
			miObservador.setVista(vistaprincipal.contentPane);
			setContentPane(miObservador.getVista());
		
			setVisible(true);
			
			
		}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		seleccion=miObservador.getPanelSeleccionado();
		
		if(seleccion == 0 ){
	
			setContentPane(miObservador.getVista());
			miObservador.setVista(miObservador.getVista());
			setVisible(true);
		}
		
	

		}
	
}
		
	


