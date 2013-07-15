/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * La interfaz <code>JShape</code> extiende las 
 * funcionalidades de geometricas de una forma 
 * proporcionadas en la interfaz {@link Shape} 
 * y agrega caracteristicas de dibujo en las formas
 * que implementan esta intefaz.
 * 
 *  Las características de dibujo que tienen las formas 
 * de dibujo que implementan la interfaz {@link JShape}
 * son:
 * <ul>
 *  <li>Color de Trazo</li>
 *  <li>Color de Relleno</li>
 *  <li>Relleno Degradado</li>
 *  <li>Grosor del Trazo</li>
 * </ul>
 * 
 * Además las formas que implementan esta interfaz tienen que implementar
 * metodos relacionados con la edición de la forma y un metodo paint para 
 * el dibujo de la forma con sus correspondientes atributos de dibujo.
 * 
 * @author Jose Colella
 * @version 1.0
 * @see Shape
 * @see Color
 * @see Stroke
 * @see GradientPaint
 * 
 */
public interface JShape extends Shape {

    //Usado para las lineas disontinuas
    static final float dash1[] = {10.0f};
     
    /**
     * Asigna el color del trazo de
     * la forma de dibujo actual 
     * 
     * @param color El color de trazo
     */
    void setPaintColor(Color color);

    /**
     * Devuelve el color de trazo de
     * la forma de dibujo actual
     * 
     * @return El color de trazo de la forma 
     */
    Color getPaintColor();

    /**
     * Asigna el color de relleno de 
     * la forma de dibujo actual
     * 
     * @param color El color de relleno 
     */
    void setFillColor(Color color);
    
    /**
     * Devuelve el color del relleno de
     * la forma actual
     * 
     * @return El color del relleno de la forma actual 
     */
    Color getFillColor();
    
    /**
     * Asigna el relleno degradado de la forma actual
     * 
     * @param p El relleno degradado  
     */
    void setGradient(GradientPaint p);
    
    /**
     * Devuelve el relleno degradado 
     * de la forma actual
     * 
     * @return Relleno degradado de la forma actual
     */
    GradientPaint getGradient();
    
    /**
     * Asigna si la forma actual tendrá 
     * un relleno degradado
     * 
     * @param isGradient booleano que determina si la forma actual 
     * tiene relleno degradado
     */
    void setIsGradient(boolean isGradient);
    
    /**
     * Asigna el grosor de trazo de la forma actual
     * 
     * @param width flotante que representa el grosor del trazo
     */
    void setStrokeWidth(float width);

    /**
     * Devuelve el grosor del trazo de la forma 
     * 
     * @return flotante que es el grosor del trazo
     */
    float getStrokeWidth();

    /**
     * Asigna si la forma tendrá relleno con
     * un color solido
     * 
     * @param isFilled booleano que determina si la forma estará relleno con un 
     * color solido
     */
    void setFilled(boolean isFilled);

    /**
     * Devuelve un booleano que proporciona información sobre si la forma esta 
     * relleno con un color solido
     * 
     * @return 
     */
    boolean isFilled();
    
    /**
     * Asigna si la forma de dibujo es continua o si 
     * se usarán lineas discontinuas. 
     * 
     * @param isContinuous booleano que determina si la forma es continua
     */
    void setContinuous(boolean isContinuous);
    
    /**
     * Devuelve si la forma es continua
     * @return true Si la forma es continua
     */
    boolean isContinuous();

    /**
     * Metodo que devuelve si la forma 
     * esta contenida en el {@link Point2D}
     * pasado por parametro
     * 
     * @param point Punto al cual analizamos si la forma esta contenida
     * @return true Si la forma esta contenida
     */
    boolean isContained(Point2D point);

    /**
     * Metodo que es usado en el evento del arrastrado del 
     * raton, cuando la forma se puede mover
     * 
     * @param pos Punto para mover la forma
     */
    void setLocation(Point2D pos);

    /**
     * Metodo que es usado para configurar la forma de dibujo 
     * cuando el usuario usa el raton para dibujar
     * 
     * @param p1 Punto2D de comienzo
     * @param p2 Punto final de la forma
     */
    void update(Point2D p1, Point2D p2);

    /**
     * El metodo paint se usa para dibujar la forma
     * con sus atributos de dibujo correspondientes.
     * El Graphics pasado como parametro dibuja la forma
     * 
     * @param g El Graphics que dibuja la forma con sus correspondientes
     * caracteristicas
     * 
     * @see Graphics
     */
    void paint(Graphics g);
}
