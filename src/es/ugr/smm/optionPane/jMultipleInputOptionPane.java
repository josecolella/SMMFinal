/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.optionPane;

import javax.swing.*;

/**
 *
 * @author Jose
 */
public class jMultipleInputOptionPane {

    private static final String WIDTH_STR = "Anchura: ";
    private static final String HEIGHT_STR = "Altura: ";
    private JTextField heightText;
    private JTextField widthText;
    private JPanel sizePanel;
    private int result;
    private Integer height;
    private Integer width;
    private boolean isCancelled;

    public jMultipleInputOptionPane() {
        this.height = 0;
        this.width = 0;
        this.heightText = new JTextField(3);
        this.widthText = new JTextField(3);
        this.sizePanel = new JPanel();
        sizePanel.add(new JLabel(HEIGHT_STR));
        sizePanel.add(heightText);
        sizePanel.add(Box.createHorizontalStrut(15));
        sizePanel.add(new JLabel(WIDTH_STR));
        sizePanel.add(widthText);
        result = JOptionPane.showConfirmDialog(null, sizePanel,
                "Insertar Altura y Anchura de Imágen deseada", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            do {
                try {
                    this.height = Integer.parseInt(heightText.getText());
                    this.width = Integer.parseInt(widthText.getText());
                    isCancelled = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "No se puede dejar vacios los campos", "Error",JOptionPane.ERROR_MESSAGE);
                    result = JOptionPane.showConfirmDialog(null, sizePanel,
                            "Insertar Altura y Anchura de Imágen deseada", JOptionPane.OK_CANCEL_OPTION);
                }
            } while (height == 0 || width == 0);
        } else {
            isCancelled = true;
        }

    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}
