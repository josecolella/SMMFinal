/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Stroke;

/**
 *
 * @author Jose
 */
public class ShapeAttribute {

    private Color paintColor;
    private Color fillColor;
    private Stroke shapeStroke;
    private GradientPaint gradient;
    private float strokeWidth;
    private boolean isFilled;
    private boolean isCont;

    public ShapeAttribute()
    {
        initializeAttributes();
    }
    
    private void initializeAttributes() {
        setPaintColor(Color.BLACK);
        setFillColor(Color.BLACK);
        setStrokeWidth(1.0F);
        setFilled(false);
        setCont(true);
    }

    /**
     * @return the paintColor
     */
    public Color getPaintColor() {
        return paintColor;
    }

    /**
     * @param paintColor the paintColor to set
     */
    public void setPaintColor(Color paintColor) {
        this.paintColor = paintColor;
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * @return the shapeStroke
     */
    public Stroke getShapeStroke() {
        return shapeStroke;
    }

    /**
     * @param shapeStroke the shapeStroke to set
     */
    public void setShapeStroke(Stroke shapeStroke) {
        this.shapeStroke = shapeStroke;
    }

    /**
     * @return the gradient
     */
    public GradientPaint getGradient() {
        return gradient;
    }

    /**
     * @param gradient the gradient to set
     */
    public void setGradient(GradientPaint gradient) {
        this.gradient = gradient;
    }

    /**
     * @return the strokeWidth
     */
    public float getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * @param strokeWidth the strokeWidth to set
     */
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * @return the isFilled
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * @param isFilled the isFilled to set
     */
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    /**
     * @return the isCont
     */
    public boolean isCont() {
        return isCont;
    }

    /**
     * @param isCont the isCont to set
     */
    public void setCont(boolean isCont) {
        this.isCont = isCont;
    }
    
    
}
