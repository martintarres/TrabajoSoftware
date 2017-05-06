import java.awt.BorderLayout;
import java.awt.EventQueue;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Canvas;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;


public class Reproductor extends JFrame {

	private JPanel contentPane;
	String marco;
	AdvancedPlayer reproductor;
	//String files;
	//private String String datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reproductor frame = new Reproductor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reproductor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BotonAdelante = new JButton(">>");
		BotonAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BotonAdelante.setBounds(335, 205, 89, 23);
		contentPane.add(BotonAdelante);
		
		JSlider BarraVolumen = new JSlider();
		BarraVolumen.setOrientation(SwingConstants.VERTICAL);
		BarraVolumen.setBounds(346, 11, 78, 183);
		contentPane.add(BarraVolumen);
		
		JButton BotonAtras = new JButton("<<");
		BotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAtras.setBounds(19, 205, 89, 23);
		contentPane.add(BotonAtras);
		
		JButton botonPlayPause = new JButton("Play / Pause");
		botonPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//AdvancedPlayer reproductor = null;
				reproductor.stop();
				
			}
		});
		botonPlayPause.setBounds(121, 205, 104, 23);
		contentPane.add(botonPlayPause);
		
		JButton BotonStop = new JButton("Stop");
		BotonStop.setBounds(236, 205, 89, 23);
		contentPane.add(BotonStop);
		
		Label TextoBuscar = new Label("Buscar Cancion");
		TextoBuscar.setBounds(19, 11, 104, 23);
		contentPane.add(TextoBuscar);
		//System.out.println(marco);
		
		TextField BuscarCancion = new TextField();
		BuscarCancion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				marco=BuscarCancion.getText();
	//			System.out.println(marco);
			//	buscar();
	
			}
		});
		BuscarCancion.setBounds(123, 11, 127, 22);
		contentPane.add(BuscarCancion);
		
		List list = new List();
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Apretaste " + list.getSelectedItem()); // para ver el nombre elemento seleccionado
				//System.out.println("Apretaste " + )); // para ver el elemento seleccionado
				String unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
				System.out.println(unir);
				
				try {
					reproductor=new AdvancedPlayer(new FileInputStream(unir));
					reproductor.play();
				}
				catch(Exception e){
					System.out.println("Error");
				}
			}
		});
		list.setBounds(13, 55, 327, 127);
		contentPane.add(list);
	
		String path= "C:\\Users\\marti\\Music";
		File files;
		File folder =new File (path);
		File [] listFiles = folder.listFiles();
		
		File archivo ;
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getAbsoluteFile();
				if(files.getName().endsWith("txt") || files.getName().endsWith("TXT") || files.getName().endsWith("mp3") ){
				System.out.println(files);
				list.add(files.getName());
			
				}
			}
		}
	}
		
		
		/*JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String values =  files;
			//public int getSize() {
		//		return values.length;
			//}
		//	public Object getElementAt(int index) {
			//	return values[index];
			//}
		});
		list_1.setBounds(172, 55, 118, 98);
		contentPane.add(list_1);
		*/
		
		//File archivo = list.getSelectedItem();
	//}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	
	/*	
	private void buscar (){
		
		/*ArrayList<File> resultados;
		resultados=new ArrayList<File>();
		
		
		String path= "C:\\Users\\marti\\Music";
		File f= new File (path);
		File[] archivos = f.listFiles();
		for(int i=0;i<archivos.length;i++){
		File archivo = archivos[i];
		
		if(archivo.getName() != null){
			resultados.add(archivo);
		//	System.out.println(archivo);
		}
		}
		
		for (int i=0; i<resultados.size();i++){
			System.out.println(resultados[i]);
		}*/
		
		/*String path= "C:\\Users\\marti\\Music";
		//String files;
		File folder =new File (path);
		File [] listFiles = folder.listFiles();
		
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getName();
				System.out.println(files);
			}
		}
	}*/
}



