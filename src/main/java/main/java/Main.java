package main.java;


public class Main {

	public static void main(String[] args) {
		Modelo modelo = Modelo.getInstance();
		ClaseObservador observador=new ClaseObservador();
		
		

		
		Vista vista= new Vista(observador );
		
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciar();
		
		
		observador.addObserver(vista);
		

	}

}
