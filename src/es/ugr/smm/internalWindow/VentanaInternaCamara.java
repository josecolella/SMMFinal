package es.ugr.smm.internalWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JInternalFrame;

/**
 * VentanaInternaCamara representa la ventana interna {@link JInternalFrame}
 * que proporciona acceso a la cámara del usuario para capturar secuencias de video
 * El objetivo de esta clase es la captura de secuencias de video, para proporcionar
 * una captura, que será una ventana interna {@link jImageInternalWindow} 
 *
 * @author Jose Colella
 * @version 1.0
 * @see jImageInternalWindow
 * @see Player
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {

    //Atributo player de la ventana interna
    private Player player;

    /* El contructor es privado ya que se usa un metodo
     * para llamar una instancia de la VentanaInternaCamara
     * 
     */
    private VentanaInternaCamara() {
        try {
            initComponents();
             this.setSize(640, 480);
            startWebcam();
        } catch (IOException | NoPlayerException | CannotRealizeException ex) {
            Logger.getLogger(VentanaInternaCamara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Crea una instancia de {@link VentanaInternaCamara} en el escritorio
     * central. 
     * 
     * @return <code>this</code> La instancia de la ventana interna que captura secuencias
     * de video
     */
    public static VentanaInternaCamara getInstance() {
        VentanaInternaCamara v = new VentanaInternaCamara();
        return (v.player != null ? v : null);
    }

    //Metodo privado para capturar video. Basicamente este metodo
    //inicializa los componentes hardware para que comience la camara
    private void startWebcam() throws IOException, NoPlayerException, CannotRealizeException {
        
       
        String dName = "vfw://0";
        MediaLocator ml = new MediaLocator(dName);
        player = Manager.createRealizedPlayer(ml);
        Component areaVisual = player.getVisualComponent();
        if (areaVisual != null) {
            areaVisual.setBounds(20, 20, 600, 600);
            add(areaVisual);
            Component panelControl = player.getControlPanelComponent();
            if (panelControl != null) {
                add(panelControl,BorderLayout.SOUTH);
            }
            this.pack();
            
        }
        player.start();
    }

    /**
     * Metodo para iniciar la grabación de video
     * 
     */
    public void play() {
        try {
            player.start();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Cierra la instancia de la {@link VentanaInternaCamara}
     */
    public void close() {
        player.close();
    }

    /**
     * Devuelve el reproductor de la {@link VentanaInternaCamara}
     * 
     * @return El reproductor actual {@link Player}
     * @see Player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Webcam");
        setVisible(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    //Acción tomada cuando cerramos la instancia de la {@link VentanaInternaCamara}}
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        player.close();         // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
