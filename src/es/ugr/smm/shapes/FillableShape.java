/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;

/**
 *
 * @author Jose
 */
public interface FillableShape extends JShape{
    
    
    void setFillColor(Color color);
    Color getFillColor();
   
}
