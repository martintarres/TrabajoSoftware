import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.Observable;

import static org.junit.Assert.*;

/**
 * Created by martin on 23/6/2017.
 */
public class ClaseObservadorTest {
   ClaseObservador  observador;
    private int contentPaneSeleccionado;
    private JPanel panel;
    @Before
    public void setUp() throws Exception {
        observador= new ClaseObservador();

    }

    @Test
    public void setPanel() throws Exception {
        contentPaneSeleccionado = 1;
        assertEquals(0, observador.getPanelSeleccionado());
        observador.setPanel(contentPaneSeleccionado);
        assertEquals(1, observador.getPanelSeleccionado());
    }

    @Test
    public void getPanelSeleccionado() throws Exception {
    }

    @Test
    public void setVista() throws Exception {
    }

    @Test
    public void getVista() throws Exception {
    }

}