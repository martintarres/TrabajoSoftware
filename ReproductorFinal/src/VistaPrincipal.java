import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;




public class VistaPrincipal extends JFrame implements Observer {
	JPanel contentPane;
	ClaseObservador miObservador;
	int seleccion;
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
	JSlider AvanceCancion;
	
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
			BotonAdelante.setBounds(335, 205, 70, 23);
			contentPane.add(BotonAdelante);
			
			BarraVolumen = new JSlider();
			BarraVolumen.setMaximum(141);
			BarraVolumen.setOrientation(SwingConstants.VERTICAL);
			BarraVolumen.setBounds(346, 11, 78, 183);
			contentPane.add(BarraVolumen);
			
			
			BotonAtras = new JButton("<<");
			BotonAtras.setBounds(12, 205, 70, 23);
			contentPane.add(BotonAtras);
			
			
			BotonStop = new JButton("Stop");
			BotonStop.setBounds(255, 205, 70, 23);
			contentPane.add(BotonStop);
			
			
			TextoBuscar = new Label("Buscar Cancion");
			TextoBuscar.setBounds(19, 11, 104, 23);
			contentPane.add(TextoBuscar);
			
			BotonPlay = new JButton("Play");
			BotonPlay.setBounds(92, 205, 70, 23);
			contentPane.add(BotonPlay);
			
			BotonPause = new JButton("||");
			BotonPause.setBounds(172, 205, 70, 23);
			contentPane.add(BotonPause);
			
			SeleccionCarpeta = new JButton("Seleccion carpeta");
			SeleccionCarpeta.setBounds(269, 11, 89, 23);
			contentPane.add(SeleccionCarpeta);
			
			AvanceCancion = new JSlider();
			AvanceCancion.setBounds(34, 235, 353, 26);
			contentPane.add(AvanceCancion);
			
			
		}

		@Override
		public void update(Observable o, Object arg) {
			seleccion=miObservador.getPanelSeleccionado();
			
			if (seleccion == 1){
				
				
				
				
				miObservador.setVista(contentPane);
				
				miObservador.setPanel(5);
		
				
				

			}
			
			
		}
}
