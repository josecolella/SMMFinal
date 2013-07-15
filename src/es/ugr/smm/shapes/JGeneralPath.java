/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Un JGeneralPath representa un trazo libre que tiene las funcionalidades
 * geometricas de la clase GeneralPath.Float con las funcionalidades de atributos
 * de dibujo obtenidas de JShape
 * 
 * @author Jose Colella
 * @version 1.0
 * @see GeneralPath
 * @see JShape
 * 
 */
public class JGeneralPath extends GeneralPath.Float implements JShape {
    
    //Atributo de clase que encapsula los atrobutos de dibujo
    private ShapeAttribute shapeAttribute;

    /**
     * Crea un JGeneralPath con los atributos de dibujo de la forma
     */
    public JGeneralPath() {
        super();
        shapeAttribute = new ShapeAttribute();

    }
    
    /**
     * Asigna el color del trazo
     * @param color Color de trazo a asignar 
     */
    @Override
    public void setPaintColor(Color color) {
        this.shapeAttribute.setPaintColor(color);
    }
    
    /**
     * Devulve el color del trazo
     * @return El color del trazo
     */
    @Override
    public Color getPaintColor() {
        return this.shapeAttribute.getPaintColor();
    }
    
    /**
     * Asigna el grosor del trazo
     * @param width El grosor del trazo 
     */
    @Override
    public void setStrokeWidth(float width) {
        this.shapeAttribute.setStrokeWidth(width);
    }

     /**
     * Devuelve el grosor del trazo
     * @return float que representa el grosor del trazo
     */
    @Override
    public float getStrokeWidth() {
        return this.shapeAttribute.getStrokeWidth();
    }

    /**
     * Asigna el color del relleno
     * @param color Color del relleno a asignar
     */
    @Override
    public void setFillColor(Color color) {
        this.shapeAttribute.setFillColor(color);
    }

    /**
     * Devuelve el color de relleno del trazo libre actual
     * @return El color del relleno
     */
    @Override
    public Color getFillColor() {
        return this.shapeAttribute.getFillColor();
    }
    
    /**
     * Asigna si el trazo libre tiene un relleno solido
     * 
     * @param isFilled booleano que denota si el JGeneralPath tiene relleno solido 
     */
    @Override
    public void setFilled(boolean isFilled) {
        this.shapeAttribute.setFilled(isFilled);
    }
    
    /**
     * Devuelve si el trazo libre tiene relleno solido
     * 
     * @return true si esta relleno con color solido 
     */
    @Override
    public boolean isFilled() {
        return this.shapeAttribute.isFilled();
    }
    
    /**
     * Asigna si el JGeneralPath es continuo
     * 
     * @param isContinuous booleano que denota si el trazo libre es continuo
     */
    @Override
    public void setContinuous(boolean isContinuous) {
        this.shapeAttribute.setCont(isContinuous);

    }
    
    /**
     * Devuelve si el rectangle es continuo
     * 
     * @return true si el trazo libre es continuo
     */
    @Override
    public boolean isContinuous() {
        return this.shapeAttribute.isCont();
    }

    /**
     * Devuelve si el JGeneralPath tiene relleno degradado
     * 
     * @return true si tiene relleno degradado
     */
    public boolean isGradient() {
        return this.shapeAttribute.isGradient();
    }

    /**
     * Asigna si el trazo libre tiene relleno degradado
     * 
     * @param isGradient booleano que denota si el trazo libre tiene relleno degradado
     */
    @Override
    public void setIsGradient(boolean isGradient) {
        this.shapeAttribute.setIsGradient(isGradient);
    }

    /**
     * Devuelve el color de relleno 
     * 
     * @return El color de relleno del JGeneralPath
     */
    public Paint getFillPaint() {
        return this.shapeAttribute.getGradient();
    }

    /**
     * Asigna el relleno degradado del JGeneralPath
     * @param p El relleno degradado a asignar
     */
    @Override
    public void setGradient(GradientPaint p) {
        this.shapeAttribute.setGradient(p);
    }

    /**
     * Devuelve el relleno degradado del JGeneralPath
     * @return El relleno degradado 
     */
    @Override
    public GradientPaint getGradient() {
        return this.shapeAttribute.getGradient();
    }
    

    /**
     * Devuelve si el JGeneralPath actual esta contenida dentro del 
     * Punto2D pasado por parametro
     * 
     * @param point Punto2D que se usa para verificar si esta contenido
     * @return true Si esta contenido en el trazo libre
     */@Override
    public boolean isContained(Point2D point) {
        if (this.contains(point)) {
            return true;
        }
        return false;
    }

    /**
     * Mueve el JGeneralPath actual a una nueva posición denotado 
     * por el parametro
     * 
     * @param pos Punto que denota la posición nueva
     */
    @Override
    public void setLocation(Point2D pos) {
        Rectangle2D v = this.getBounds2D();
        v.setFrame(pos.getX(), pos.getY(), v.getWidth(), v.getHeight());
       
    }

    /**
     * Configura el JGeneralPath con los puntos pasados por
     * parametro 
     * 
     * @param p1 Punto inicial
     * @param p2 Punto final
     */
    @Override
    public void update(Point2D p1, Point2D p2) {
        this.lineTo(p2.getX(), p2.getY());
    }

    /**
     * Metodo que dibuja el JGeneralPath con sus ccrrespondientes 
     * atributos de dibujo. 
     * 
     * @param g El {@link Graphics} que dibuja el JGeneralPath actual
      
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (shapeAttribute.isCont()) {
            shapeAttribute.setShapeStroke(new BasicStroke(this.shapeAttribute.getStrokeWidth()));
            g2d.setStroke(shapeAttribute.getShapeStroke());
        } else if (!shapeAttribute.isCont()) {
            shapeAttribute.setShapeStroke(new BasicStroke(this.shapeAttribute.getStrokeWidth(),
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, JShape.dash1, 0.0f));
            g2d.setStroke(shapeAttribute.getShapeStroke());
        }
        g2d.setPaint(this.shapeAttribute.getPaintColor());
        g2d.draw(this);
        if (shapeAttribute.isFilled()) {
            g2d.setPaint(this.shapeAttribute.getFillColor());
            g2d.fill(this);
        } else if (shapeAttribute.isGradient()) {
            g2d.setPaint(this.shapeAttribute.getGradient());
            g2d.fill(this);
        }

    }
}
