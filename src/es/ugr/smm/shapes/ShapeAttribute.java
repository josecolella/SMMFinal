/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;

/**
 * ShapeAttribute representa la encapsulación de los atributos 
 * de dibujo que contiene un {@link JShape}. Ofrece metodos setters 
 * y getters para dichos attributos. 
 * 
 * Si hay que agregar o cambiar atributos de dibujo, cambiando esta clase,
 * todas las correpondientes clases que usan ShapeAttribute como atributo 
 * estan automaticamente afectadas.
 * 
 * @author Jose Colella
 * @version 1.0
 * @see Color
 * @see Stroke
 * @see GradientPaint
 */
public class ShapeAttribute {

    private Color paintColor;
    private Color fillColor;
    private Stroke shapeStroke;
    private GradientPaint gradient;
    private float strokeWidth;
    private boolean isFilled;
    private boolean isCont;
    private boolean isGradient;

    /**
     * Instancia un ShapeAttribute donde 
     * todos los atributos de dibujo estan inicializados
     */
    public ShapeAttribute() {
        initializeAttributes();
    }

    private void initializeAttributes() {
        this.paintColor = Color.BLACK;
        this.fillColor = Color.BLACK;
        this.strokeWidth = 1.0F;
        this.isFilled = false;
        this.isCont = true;
        this.isGradient = false;
    }

    /**
     * Devuelve el color de trazo
     * @return color de trazo
     */
    public Color getPaintColor() {
        return paintColor;
    }

    /**
     * Asigna el color del trazo
     * @param paintColor El color de trazo
     */
    public void setPaintColor(Color paintColor) {
        this.paintColor = paintColor;
    }

    /**
     * Devuelve el color del relleno
     * 
     * @return El color del relleno
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Asigna el color de relleno
     * @param fillColor El color de relleno
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * Devielve el trazo
     * 
     * @return El trazo
     */
    public Stroke getShapeStroke() {
        return shapeStroke;
    }

    /**
     * Asigna el trazo 
     * 
     * @param shapeStroke El trazo a asignar
     */
    public void setShapeStroke(Stroke shapeStroke) {
        this.shapeStroke = shapeStroke;
    }

    /**
     * Devuelve el relleno degradado
     * @return Relleno degradado
     */
    public GradientPaint getGradient() {
        return gradient;
    }

    /**
     * Asigna el relleno degradado 
     * 
     * @param gradient El relleno degradado a asignar
     */
    public void setGradient(GradientPaint gradient) {
        this.gradient = gradient;
    }

    /**
     * Devuelve el grosor del trazo
     * 
     * @return float que representa el grosor del trazo
     */
    public float getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * Asigna el grosor 
     * 
     * @param strokeWidth El grosor a asignar
     */
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * Devuelve si la forma esta rellena con un color solido
     * @return true si la forma esta rellena
     * 
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * Asigna si la forma esta rellena con color solido
     * 
     * @param isFilled booleano que denota si la forma esta rellena
     */
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    /**
     * Devuelve si la forma tiene un relleno degradado
     * 
     * @return true si tiene un relleno degradado
     */
    public boolean isGradient() {
        return isGradient;
    }

    /**
     * Asigna si la forma tiene el relleno degradado 
     * @param isGradient booleano que denota si tiene relleno degradado 
     */
    public void setIsGradient(boolean isGradient) {
        this.isGradient = isGradient;
    }

    /**
     * Devuelve si la forma es continua
     * 
     * @return true si la forma es continua
     */
    public boolean isCont() {
        return isCont;
    }

    /**
     * Asigna si la forma es continua
     * 
     * @param isCont booleano que denota si la forma es continua
     */
    public void setCont(boolean isCont) {
        this.isCont = isCont;
    }
}
