/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 * @see @link{Shape}
 */
public interface JShape extends Shape {

    /**
     *
     */
    static final float dash1[] = {10.0f};
 

    
    
    void setPaintColor(Color color);

    Color getPaintColor();

    void setFillColor(Color color);
    Color getFillColor();
    
    void setStrokeWidth(float width);

    float getStrokeWidth();

    void setFilled(boolean isFilled);

    boolean isFilled();
    
    void setContinuous(boolean isContinuous);
    
    boolean isContinuous();

    boolean isContained(Point2D point);

    void setLocation(Point2D pos);

    void update(Point2D p1, Point2D p2);

    void paint(Graphics g);
}
