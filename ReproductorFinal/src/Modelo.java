import java.awt.Component;
import java.awt.List;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JSlider;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Modelo {
		
	String path;
	File files = null ;
	static BasicPlayer player;
	List list;
	String unir;
	File [] listFiles;
	File folder;
	File archivo;
	
	public void iniciarm(){
		player= new BasicPlayer();
		path= "C:\\Users\\marti\\Music";
		folder =new File (path);
	}
	
	public void cargar(List list){
		
		
		this.list=list;
		 
		 
		 listFiles = folder.listFiles();
		 
			for(int i=0; i<listFiles.length;i++){
				if(listFiles[i].isFile()){
					files=listFiles[i].getAbsoluteFile();
					if(files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")){
					System.out.println(files);
			//		System.out.println(listFiles[i]);
					list.add(files.getName());
					
					}
				}
			}
	}
	

	
	public void play(){
				unir= path.concat("\\" + list.getSelectedItem());
				archivo = new File ( unir);
				if(player.getStatus()==-1 ||player.getStatus()== 2){
					
					try {
				player.open(archivo);
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
	
	
	public void pause(){
		try {
			player.pause();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop(){
		try {
			player.stop();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void adelante(){
		list.select((list.getSelectedIndex()+1));
		unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void atras(){
		
		list.select((list.getSelectedIndex()-1));
		unir = "C:\\Users\\marti\\Music\\" + list.getSelectedItem();
		try {
			player.stop();
			player.open(new File(unir));
			player.play();
		} catch (BasicPlayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void volumen(JSlider source){
		
		source.setMaximum(141);
		try {
			player.setGain(source.getValue()*0.01); // Aca lo multiplico porque el volumen 
														//	solo puede ir entre 0 y 1.4 								
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscarcancion(String s){
		
		list.removeAll();
		
		for(int i=0; i<listFiles.length;i++){
			if(listFiles[i].isFile()){
				files=listFiles[i].getAbsoluteFile();
				if(files.getName().endsWith("mp3") || files.getName().endsWith("wav") || files.getName().endsWith("mp4")){
					
					
					if(files.toString().toLowerCase().contains(s)){
						//System.out.println(files.toString());
						list.add(files.getName());
						
					}
					
					}
			
		}
		}
	}
	
	public void seleccioncarpeta(List lista){
		JFileChooser fc=new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		Component contentPane = null;
		int ventanaseleccionada = fc.showOpenDialog(contentPane);
		
		if(ventanaseleccionada== JFileChooser.APPROVE_OPTION){
				folder=fc.getSelectedFile();
				path= folder.getAbsolutePath();
			
				//path= path.concat("\\");
				list.removeAll();
				cargar(lista);
		}
	}

}
