package main.java;

import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Component;




public class VistaPrincipal extends JFrame implements Observer {
	
	ClaseObservador miObservador;
	int seleccion;
	
	JPanel contentPane;
	List list;
	TextField BuscarCancion;
	JButton BotonAdelante;
	JSlider BarraVolumen;
	JButton BotonAtras;
	JButton BotonStop;
	Label TextoBuscar;
	JButton BotonPlay;
	JButton BotonPause;
	JButton SeleccionCarpeta;
	JButton ListaReproduccion;
	JButton AgregarListaReproduccion;
	JProgressBar BarraProgreso;
	
		public VistaPrincipal(ClaseObservador observador){
			
			miObservador=observador;
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
			
			TextoBuscar = new Label("Buscar Cancion");
			TextoBuscar.setBounds(19, 11, 104, 23);
			contentPane.add(TextoBuscar);
			
			BotonPlay = new JButton("Play");
			BotonPlay.setBounds(90, 227, 70, 23);
			contentPane.add(BotonPlay);
			
			BotonPause = new JButton("||");
			BotonPause.setBounds(90, 227, 70, 23);
			//contentPane.add(BotonPause);
			
			SeleccionCarpeta = new JButton();
			SeleccionCarpeta.setBounds(256, 11, 35, 23);
			contentPane.add(SeleccionCarpeta);
			ImageIcon selec= new ImageIcon("C:\\Users\\marti\\Desktop\\TrabajoSoftware\\folder.PNG"); 
			SeleccionCarpeta.setIcon(selec);
			
			ListaReproduccion = new JButton();
			ListaReproduccion.setBounds(335, 227, 70, 23);
			contentPane.add(ListaReproduccion);
			ImageIcon list= new ImageIcon("C:\\Users\\marti\\Desktop\\TrabajoSoftware\\lista.PNG"); 
			ListaReproduccion.setIcon(list);
			
			AgregarListaReproduccion = new JButton();
			AgregarListaReproduccion.setBounds(301, 11, 35, 23);
			contentPane.add(AgregarListaReproduccion);
			ImageIcon agreg= new ImageIcon("C:\\Users\\marti\\Desktop\\TrabajoSoftware\\mas.PNG"); 
			AgregarListaReproduccion.setIcon(agreg);
			
			BarraProgreso = new JProgressBar();
			BarraProgreso.setBounds(36, 236, 304, 14);
			//contentPane.add(BarraProgreso);
			
			
		}

		@Override
		public void update(Observable o, Object arg) {
			seleccion=miObservador.getPanelSeleccionado();
			System.out.println("Notifico en vistaprinciapl");
			
			if(seleccion ==1 ){
				contentPane.remove(BotonPlay);
				contentPane.add(BotonPause);
				miObservador.notifyObservers();
				
			}
			
			if ( seleccion == 2){
				contentPane.remove(BotonPause);
				contentPane.add(BotonPlay);
				miObservador.notifyObservers();
				
			}
			
			if(seleccion == 4){
				miObservador.setVista(contentPane);
				miObservador.setPanel(0);
			}
			
			
		}
}
