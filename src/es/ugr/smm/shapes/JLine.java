/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.geom.Point2D;

/**
 * JLine representa una linea que contiene 
 * propiedades geometricas y propiedades 
 * las caracteristicas de dibujo.
 * 
 * JLine extiende {@link AbstractAttributableLine}
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
public class JLine extends AbstractAttributableLine {

    
    /**
     * Inicializa una JLine
     */
    public JLine() {
        super();

    }
    
    /**
     * Construye una JLine que comienza en el
     * primer punto pasado y termina en el segundo punto
     * pasado por parametro
     * 
     * @param p1 Punto que denota el comienzo de la linea
     * @param p2 Punto donde termina la linea
     */
    public JLine(Point2D p1, Point2D p2) {
        super(p1, p2);

    }
   
    /**
     *  Asigna el lugardonde se mueve la linea cuando 
     * se mueve
     * 
     * @param pos Punto a donde se mueve la linea
     */
    @Override
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.getX1();
        double dy = pos.getY() - this.getY1();
        Point2D newPoint;
        newPoint = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        this.setLine(pos, newPoint);
    }

    /**
     * Configura la linea a dibujar con los puntos 
     * pasados por parametro
     * 
     * @param p1 Punto inicial
     * @param p2 Punto final de la configuración
     */
    @Override
    public void update(Point2D p1, Point2D p2) {
        this.setLine(p1, p2);
    }
}
