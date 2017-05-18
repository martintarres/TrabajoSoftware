
import java.awt.EventQueue;


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







import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Reproductor extends JFrame {

	private JPanel contentPane;
	String marco;
	String unir;
	static //AdvancedPlayer reproductor;
	 BasicPlayer player;
	
	//String files;
	//private String String datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//	Repro y= new Repro();
		 player= new BasicPlayer();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//player = new BasicPlayer();
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
		BotonAdelante.setBounds(335, 205, 70, 23);
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
		BotonAtras.setBounds(12, 205, 70, 23);
		contentPane.add(BotonAtras);
		
		JButton BotonStop = new JButton("Stop");
		BotonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					player.stop();
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BotonStop.setBounds(255, 205, 70, 23);
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
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Apretaste " + list.getSelectedItem());
				unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
				

			}
			@Override
			public void mousePressed(MouseEvent e) {
			//	System.out.println("Apretaste " + list.getSelectedItem()); // para ver el nombre elemento seleccionado
				//System.out.println("Apretaste " + )); // para ver el elemento seleccionado
			//	 unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
				//System.out.println(unir);
			}
		});
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	System.out.println("Apretaste " + list.getSelectedItem()); // para ver el nombre elemento seleccionado
				//System.out.println("Apretaste " + )); // para ver el elemento seleccionado
				// unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
			//	System.out.println(unir);
				
				try {
					//reproductor=new AdvancedPlayer(new FileInputStream(unir));
					//reproductor.play();
					
					player.open(new File(unir));
					player.play();
				}
				catch(Exception e){
					System.out.println("Error");
					
				}
			}
		});
		list.setBounds(13, 55, 327, 127);
		contentPane.add(list);
		
		JButton BotonPlay = new JButton("Play");
		BotonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				System.out.println(player.getStatus());
				if(player.getStatus()==-1 ||player.getStatus()== 2){
					
				//	player= new BasicPlayer();
					try {
						player.open(new File(unir));
						player.play();
					} catch (BasicPlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
					if(player.getStatus()==0 ){
				try {
					player.open(new File(unir));
					player.play();
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
				
				
				if(player.getStatus()==1){
					
						try {
							player.resume();
						} catch (BasicPlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				}
				
				
			
				
			}
		});
		BotonPlay.setBounds(92, 205, 70, 23);
		contentPane.add(BotonPlay);
		
		JButton BotonPause = new JButton("||");
		BotonPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					player.pause();
				} catch (BasicPlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		BotonPause.setBounds(172, 205, 70, 23);
		contentPane.add(BotonPause);
	
		String path= "C:\\Users\\marti\\Music";
		File files;
		File folder =new File (path);
		File [] listFiles = folder.listFiles();
		
		File archivo ;
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getAbsoluteFile();
				if(files.getName().endsWith("txt") || files.getName().endsWith("TXT") || files.getName().endsWith("mp3") 
						|| files.getName().endsWith("wav")){
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
}



