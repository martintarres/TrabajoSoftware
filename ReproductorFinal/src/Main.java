
public class Main {

	public static void main(String[] args) {
		ClaseObservador observador=new ClaseObservador();
		
		
		Modelo modelo = new Modelo();
		
		Vista vista= new Vista(observador );
		
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciar();
		
		
		observador.addObserver(vista);
		
		
		/*
		ClaseObservador observador=new ClaseObservador();
		
		VistaG vistag= new VistaG(observador);
		observador.addObserver(vista);
		*/

	}

}
