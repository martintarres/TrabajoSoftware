import javazoom.jlgui.basicplayer.BasicPlayer;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by martin on 22/6/2017.
 */
public class ModeloTest1 {
    Modelo modelo;
    List listarepro;
    List listareproad;
    File[] listFiles;
    File folder;
    JSlider vol;
    @Before
    public void setUp() throws Exception {
         modelo= new Modelo();
         listarepro= new List();
         listareproad= new List();
        folder = new File("src/main/resources");
        listFiles = folder.listFiles();
        vol = new JSlider();
    }

    @Test
    public void iniciarm() throws Exception {
        modelo.iniciarm();
    }

    @Test
    public void cargar() throws Exception {
        assertEquals(0 , listarepro.getItemCount());
        modelo.cargar(listarepro, folder);
        assertEquals(2, listarepro.getItemCount());

    }

  /*  @Test
    public void play() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro, folder);
        listarepro.select(0);
        modelo.archivo= new File(modelo.unir(listarepro.getSelectedItem()));
        assertEquals(-1, modelo.player.getStatus());
        modelo.play();
        assertEquals(0, modelo.player.getStatus());
    }

    @Test
    public void pause() throws Exception {
        play();
        assertEquals(0, modelo.player.getStatus());
        modelo.pause();
        assertEquals(1, modelo.player.getStatus());
    }

    @Test
    public void stop() throws Exception {
        play();
        assertEquals(0,modelo.player.getStatus());
        modelo.stop();
        assertEquals(2, modelo.player.getStatus());
    }
*/
    @Test
    public void adelante() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro,folder);
        listarepro.select(0);
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listarepro.getSelectedItem() );
        modelo.adelante();
        assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3" , listarepro.getSelectedItem());
    }

    @Test
    public void atras() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro,folder);
        listarepro.select(1);
        assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3" , listarepro.getSelectedItem());

        modelo.atras();
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listarepro.getSelectedItem() );

    }

   /* @Test
    public void volumen() throws Exception {
        modelo.iniciarm();
        System.out.println(modelo.player.getGainValue());
        modelo.player.setGain(vol.setValue(0.04));
        modelo.volumen(vol);
        System.out.println(modelo.player.getGainValue());
    }*/

    @Test
    public void buscarcancion() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro,folder);
        String busqueda = "col";
        modelo.buscarcancion(busqueda, listarepro);
        listarepro.select(0);
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listarepro.getSelectedItem());
    }

   /* @Test
    public void seleccioncarpeta() throws Exception {
        modelo.iniciarm();
        JFileChooser fc=new JFileChooser();
        fc.setFileSelectionMode(0);
        //fc.getSelectedFile(new File("src/main/resources/masmusica"));
        modelo.seleccioncarpeta(listarepro);
    }*/

    @Test
    public void agregarLista() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro,folder);
        listarepro.select(0);
        assertEquals(0, listareproad.getItemCount());
        modelo.agregarLista(listarepro.getSelectedItem() , listareproad);
        assertEquals(1, listareproad.getItemCount());
        modelo.agregarLista(listarepro.getSelectedItem(), listareproad);
        assertEquals(2, listareproad.getItemCount());
    }

    @Test
    public void borrar() throws Exception {
        agregarLista();
        assertEquals(2, listareproad.getItemCount());
        listareproad.select(0);
        modelo.borrar(listareproad.getSelectedItem());
        assertEquals(1, listareproad.getItemCount());
    }

    @Test
    public void adelanterep() throws Exception {
        modelo.iniciarm();
        modelo.cargar(listarepro,folder);
        listarepro.select(0);
        assertEquals("Coldplay_-_The_Scientist_RB-RcX5DS5A.mp3", listarepro.getSelectedItem() );
        modelo.adelante();
        assertEquals("Luis_Fonsi_-_Despacito_ft_Daddy_Yankee_kJQP7kiw5Fk.mp3" , listarepro.getSelectedItem());
    }
/*
    @Test
    public void atrasrep() throws Exception {
    }

    @Test
    public void verListaRepr() throws Exception {
    }

    @Test
    public void aleatorio() throws Exception {
    }
*/
}