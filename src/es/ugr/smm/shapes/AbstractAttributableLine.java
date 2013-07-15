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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Un AbstractAttributableLine representa una extensión de las funcionalidades
 * geometricas proporcionadas por {@link Line2D.Float} con una forma que 
 * contiene atributos de dibujo, proporcionada por la interfaz {@link Shape}.
 * 
 * Esta clase es abstract y deja los siguientes metodos abstractos para las clases 
 * que heredan de AbstractAttributableLine:
 * <ul>
 *  <li>setLocation(Point2D pos)</li>
 *  <li>update(Point2D p1, Point2D p2);</li>
 * </ul>
 * 
 * 
 * 
 * @author Jose Colella
 * @version 1.0
 * @see JShape
 * @see Line2D.Float
 */
public abstract class AbstractAttributableLine extends Line2D.Float implements JShape {

    //La varibale es protected así solo las clases que extienden esta 
    //pueden modificar
    protected ShapeAttribute shapeAttribute;

    /**
     * Esta es una clase abstracta que no puede ser instanciada
     * directamente. Las clases que extienden esta clase
     * tienen inicializadas los atributos de dibujo
     */
    protected AbstractAttributableLine() {
        super();
        shapeAttribute = new ShapeAttribute();
    }

    /**
     * Esta es una clase abstracta que no puede ser instanciada
     * directamente. Las clases que extienden esta clase tienen
     * inicializadas los atributos de dibujo.
     * @param p1 Punto de comienzo
     * @param p2 Punto final de la forma
     */
    protected AbstractAttributableLine(Point2D p1, Point2D p2) {
        super(p1, p2);
        shapeAttribute = new ShapeAttribute();
    }

    /**
     * Devuelve el color del trazo de la forma
     * 
     * @return El color del trazo
     */
    @Override
    public Color getPaintColor() {
        return shapeAttribute.getPaintColor();
    }

    /**
     * Asigna el color del trazo de la forma
     * 
     * @param paintColor El color de trazo a asignar
     */
    @Override
    public void setPaintColor(Color color) {
        this.shapeAttribute.setPaintColor(color);
    }

    /**
     * Asigna el color de relleno de la forma
     * 
     * @param color El color de relleno a asignar 
     */
    @Override
    public void setFillColor(Color color) {
        this.shapeAttribute.setFillColor(color);
    }

    /**
     * Devuelve el color de; relleno de la forma
     * @return El color del relleno de la forma
     */
    @Override
    public Color getFillColor() {
        return this.shapeAttribute.getFillColor();
    }

    /**
     * Devuelve el grosor del trazo de la forma
     * 
     * @return El flotante represetante del grosor de la forma
     */
    @Override
    public float getStrokeWidth() {
        return shapeAttribute.getStrokeWidth();
    }

    /**
     * Asigna el grosor del trazo 
     * 
     * @param strokeWidth El grosor del trazo a asignar
     */
    @Override
    public void setStrokeWidth(float strokeWidth) {
        this.shapeAttribute.setStrokeWidth(strokeWidth);
    }

    /**
     * Devuelve si la forma tiene relleno solido 
     * 
     * @return true Si la forma tiene relleno solido
     */
    @Override
    public boolean isFilled() {
        return shapeAttribute.isFilled();
    }

    /**
     * Asigna si la forma tiene relleno solido
     * 
     * @param isFilled Booleano que denota si la forma esta rellena
     */
    @Override
    public void setFilled(boolean isFilled) {
        this.shapeAttribute.setFilled(isFilled);
    }

    /**
     * Asigna el relleno degradado de la forma
     * 
     * @param p El relleno degradado de la forma
     * 
     */
    @Override
    public void setGradient(GradientPaint p) {
        this.shapeAttribute.setGradient(p);
    }

    /**
     * Devuelve el relleno degradado de la forma actual
     * 
     * @return El relleno degradado {@link GradientPaint} de la forma
     */
    @Override
    public GradientPaint getGradient()
    {
        return this.shapeAttribute.getGradient();
    }
    
    /**
     * Asigna si la forma tiene un relleno degradado
     * 
     * @param isGradient Booleano que denota si la forma tiene relleno degradado 
     */
    @Override
    public void setIsGradient(boolean isGradient)
    {
        this.shapeAttribute.setIsGradient(isGradient);
    }
    
    /**
     * Asigna si la forma es continua
     * 
     * @param isContinuous Booleano que denota si la forma es continua
     */
    @Override
    public void setContinuous(boolean isContinuous) {
        this.shapeAttribute.setCont(isContinuous);
    }

    /**
     * Devuelve si la forma es continua
     * 
     * @return true Si la forma es continua
     */
    @Override
    public boolean isContinuous() {
        return shapeAttribute.isCont();
    }

    //Metodo creado para verificar si un punto esta cerca de la forma
    private boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 2.0;
    }

    /**
     * Devuelve si el punto {@link Point2D} pasado por parametro
     * esta contenido dentro del limite de la forma
     * 
     * @param point Punto al cual analizamos
     * @return true si la forma esta contenida en el punto
     */
    @Override
    public boolean isContained(Point2D point) {
        if (this.isNear(point)) {
            return true;
        }
        return false;
    }

    /**
     * Metodo abstracto usado para mover la forma
     * @param pos Punto a donde mover la forma
     */
    @Override
    abstract public void setLocation(Point2D pos);

    /**
     * Metodo abstracto usado para configurar la forma
     * 
     * @param p1 Punto inicial
     * @param p2 Punto final
     */
    @Override
    abstract public void update(Point2D p1, Point2D p2);

    /**
     * Metodo que dibuja la forma actual con sus ccrrespondientes 
     * atributos de dibujo. 
     * 
     * @param g El {@link Graphics} que dibuja la forma con sus atributos de dibujo 
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
        }
        else if(shapeAttribute.isGradient())
        {
            g2d.setPaint(this.shapeAttribute.getGradient());
            g2d.fill(this);
        }

    }
}
