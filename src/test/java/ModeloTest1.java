import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by martin on 22/6/2017.
 */
public class ModeloTest1 {
    Modelo modelo;
    @Before
    public void setUp() throws Exception {
         modelo= new Modelo();
    }

    @Test
    public void iniciarm() throws Exception {
        modelo.iniciarm();
    }
/*
    @Test
    public void cargar() throws Exception {
    }

    @Test
    public void play() throws Exception {
    }

    @Test
    public void pause() throws Exception {
    }

    @Test
    public void stop() throws Exception {
    }

    @Test
    public void adelante() throws Exception {
    }

    @Test
    public void atras() throws Exception {
    }

    @Test
    public void volumen() throws Exception {
    }

    @Test
    public void buscarcancion() throws Exception {
    }

    @Test
    public void seleccioncarpeta() throws Exception {
    }

    @Test
    public void agregarLista() throws Exception {
    }

    @Test
    public void borrar() throws Exception {
    }

    @Test
    public void adelanterep() throws Exception {
    }

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