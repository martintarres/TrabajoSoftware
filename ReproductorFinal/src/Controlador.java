import java.awt.List;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controlador implements ActionListener {

	Modelo modelo;
	Vista vista;
	List lista;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		
		vista.vistag.vistaprincipal.list.addActionListener(this);
		vista.vistag.vistaprincipal.BuscarCancion.addTextListener(new MyTextListener());
		vista.vistag.vistaprincipal.BotonAdelante.addActionListener(this);
		vista.vistag.vistaprincipal.BarraVolumen.addChangeListener(new SliderListener());
		vista.vistag.vistaprincipal.BotonAtras.addActionListener(this);
		vista.vistag.vistaprincipal.BotonStop.addActionListener(this);
		vista.vistag.vistaprincipal.BotonPlay.addActionListener(this);
		vista.vistag.vistaprincipal.BotonPause.addActionListener(this);
		vista.vistag.vistaprincipal.SeleccionCarpeta.addActionListener(this);
	
		
		
		
		
	}
	

	
	public void iniciar(){
		modelo.iniciarm();
		
		lista = vista.vistag.vistaprincipal.list;
		modelo.cargar(lista);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(vista.vistag.vistaprincipal.BotonPlay == e.getSource()){
				modelo.play();
		}
			if(vista.vistag.vistaprincipal.BotonPause== e.getSource()){
				modelo.pause();
				}
			if(vista.vistag.vistaprincipal.BotonStop == e.getSource()){
				System.out.println("Toque stop");
				modelo.stop();
			}
			if(vista.vistag.vistaprincipal.BotonAdelante== e.getSource()){
				modelo.adelante();
			}
			if(vista.vistag.vistaprincipal.BotonAtras == e.getSource()){
				modelo.atras();
			}
			
			if(vista.vistag.vistaprincipal.list == e.getSource()){
				modelo.stop();
				modelo.play();
			}
			
			if(vista.vistag.vistaprincipal.SeleccionCarpeta == e.getSource()){
				modelo.seleccioncarpeta(lista);
			}
	}
	
	class SliderListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			if (!source.getValueIsAdjusting()) {
				modelo.volumen(source);
			}
			
		}
		
	}
	
	 class MyTextListener implements TextListener {

		public void textValueChanged(TextEvent e) {
			 TextComponent tc = (TextComponent)e.getSource();
			 String s = tc.getText();
			 modelo.buscarcancion(s);
		}
		 
	 }


	 
	
	
	
	
}
