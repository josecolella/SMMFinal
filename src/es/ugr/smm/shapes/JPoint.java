/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.geom.Point2D;

/**
 * JPoint representa un punto que contiene 
 * propiedades geometricas y propiedades 
 * las caracteristicas de dibujo.
 * 
 * JPoint extiende {@link AbstractAttributableLine}
 * e implementa los siguientes metodos:
 * <ul>
 *  <li>setLocation(Point2D p)</li>
 *  <li>update(Point2D p1, Point2D p2)</li>
 * </ul>
 * 
 * @author Jose Colella
 * @version 1.0
 * @see AbstractAttributableLine
 * @see JShape
 */
public class JPoint extends AbstractAttributableLine {

    /**
     * Construye un JPoint con los puntos pasados
     * como parametro
     * 
     * @param p1 Punto de inicio
     * @param p2 Punto final
     */
    public JPoint(Point2D p1, Point2D p2) {
        super(p1, p1);
    }

    /**
     * Asigna el lugar del punto cuando se mueve
     * 
     * @param p Punto donde se mueve el JPoint
     */
    @Override
    public void setLocation(Point2D p) {
        super.setLine(p.getX(), p.getY(), p.getX() + 1, p.getY() + 1);
    }

    /**
     * Configura la forma con los puntos pasado
     * como parametro
     * 
     * @param p1 Punto inicial
     * @param p2 Punto final
     */
    @Override
    public void update(Point2D p1, Point2D p2) {
        this.setLine(p1, p1);
    }
}
