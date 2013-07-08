/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.internalWindow;

import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import sm.sound.SMRecorder;
import sm.sound.SMSoundRecorder;

/**
 *
 * @author Jose Colella
 * @version 1.0
 */
public class VentanaInternaGrabacion extends javax.swing.JInternalFrame {

    SMRecorder recorder;

    /**
     * Creates new form VentanaInternaGrabacion
     */
    public VentanaInternaGrabacion(File f) {
        initComponents();
        recorder = new SMSoundRecorder(f);
        ((SMSoundRecorder) recorder).setLineListener(lineListener);
    }
    LineListener lineListener = new LineListener() {
        @Override
        public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.START) {
                botonGrabar.setSelected(true);
                botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/RecordDisabled_48x48.png"))); // NOI18N
                botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/StopNormalRed_48x48.png"))); // NOI18N
            }
            if (event.getType() == LineEvent.Type.STOP) {
                botonStop.setSelected(true);
                botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/RecordPressed_48x48.png"))); // NOI18N
                botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/StopDisabled_48x48.png"))); // NOI18N

            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonGrabar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botonStop = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/RecordPressed_48x48.png"))); // NOI18N
        botonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGrabarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGrabar, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/ugr/smm/icons/StopDisabled_48x48.png"))); // NOI18N
        botonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStopActionPerformed(evt);
            }
        });
        jPanel2.add(botonStop, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGrabarActionPerformed
        if (recorder != null) {
            recorder.record();
        }

        //Estas dos lineas las agrego para que cambie el tipo de icono
        //botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sm/sound/iconos/RecordPressed_48x48.png"))); // NOI18N
        //botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sm/sound/iconos/StopNormalRed_48x48.png"))); // NOI18N
    }//GEN-LAST:event_botonGrabarActionPerformed

    private void botonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStopActionPerformed
        if (recorder != null) {
            recorder.stop();
        }

        //Estas dos lineas las agrego para que cambie el tipo de icono
        // botonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sm/sound/iconos/RecordDisabled_48x48.png"))); // NOI18N
        //botonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sm/sound/iconos/StopPessedBlue_48x48.png"))); // NOI18N
    }//GEN-LAST:event_botonStopActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGrabar;
    private javax.swing.JButton botonStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}