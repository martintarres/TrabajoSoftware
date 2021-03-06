

import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class VistaPrincipal extends JFrame implements Observer {
	
	private ClaseObservador miObservador;
	JPanel contentPane;
	List list;
	TextField BuscarCancion;
	JButton BotonAdelante;
	JSlider BarraVolumen;
	JButton BotonAtras;
	JButton BotonStop;
	JButton BotonPlay;
	JButton BotonPause;
	JButton SeleccionCarpeta;
	JButton ListaReproduccion;
	JButton AgregarListaReproduccion;

	VistaPrincipal(ClaseObservador observador){
			
			miObservador=observador;
			
			
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			list = new List();
			list.setBounds(13, 55, 327, 127);
			contentPane.add(list);
			
			BuscarCancion = new TextField();
			BuscarCancion.setBounds(123, 11, 127, 22);
			contentPane.add(BuscarCancion);
			
			BotonAdelante = new JButton(">>");
			BotonAdelante.setBounds(252, 227, 70, 23);
			contentPane.add(BotonAdelante);
			
			BarraVolumen = new JSlider();
			BarraVolumen.setMaximum(141);
			BarraVolumen.setOrientation(SwingConstants.VERTICAL);
			BarraVolumen.setBounds(346, 11, 78, 183);
			contentPane.add(BarraVolumen);
			
			
			BotonAtras = new JButton("<<");
			BotonAtras.setBounds(10, 227, 70, 23);
			contentPane.add(BotonAtras);
			
			
			BotonStop = new JButton("Stop");
			BotonStop.setBounds(172, 227, 70, 23);
			contentPane.add(BotonStop);


			Label textoBuscar = new Label("Buscar Cancion");
			textoBuscar.setBounds(19, 11, 104, 23);
			contentPane.add(textoBuscar);
			
			BotonPlay = new JButton("Play");
			BotonPlay.setBounds(90, 227, 70, 23);
			contentPane.add(BotonPlay);
			
			BotonPause = new JButton("||");
			BotonPause.setBounds(90, 227, 70, 23);
			
			SeleccionCarpeta = new JButton();
			SeleccionCarpeta.setBounds(256, 11, 35, 23);
			contentPane.add(SeleccionCarpeta);
			ImageIcon selec= new ImageIcon(getClass().getClassLoader().getResource("carpeta.png"));
			SeleccionCarpeta.setIcon(selec);
			
			ListaReproduccion = new JButton();
			ListaReproduccion.setBounds(335, 227, 70, 23);
			contentPane.add(ListaReproduccion);
			ImageIcon list= new ImageIcon(getClass().getResource("lista.png"));
			ListaReproduccion.setIcon(list);
			
			AgregarListaReproduccion = new JButton();
			AgregarListaReproduccion.setBounds(301, 11, 35, 23);
			contentPane.add(AgregarListaReproduccion);
			ImageIcon agreg= new ImageIcon(getClass().getResource("mas.png"));
			System.out.println(getClass().getResource("mas.png"));
			AgregarListaReproduccion.setIcon(agreg);

		}

		@Override													// Esta es la parte que implementa los observer
		public void update(Observable o, Object arg) {
			int seleccion = miObservador.getPanelSeleccionado();
			
			if(seleccion ==1 ){
				contentPane.remove(BotonPlay);						// Si seleccionamos uno, queda visible el boton de pausa
				contentPane.add(BotonPause);

				
			}
			
			if ( seleccion == 2){									// Si seleccionamos 2, queda visible el boton de play
				contentPane.remove(BotonPause);
				contentPane.add(BotonPlay);

				
			}
			
			if(seleccion == 4){										// El 4 es para informar el cambio de vista a la principal
				miObservador.setVista(contentPane);
				miObservador.setPanel(0);
			}
			
			
		}
}
