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

/**
 *
 * @author Jose
 */
public class JGeneralPath extends GeneralPath.Float implements JShape {

    private ShapeAttribute shapeAttribute;

    /**
     *
     */
    public JGeneralPath() {
        super();
        shapeAttribute = new ShapeAttribute();

    }

    @Override
    public void setPaintColor(Color color) {
        this.shapeAttribute.setPaintColor(color);
    }

    @Override
    public Color getPaintColor() {
        return this.shapeAttribute.getPaintColor();
    }

    @Override
    public void setStrokeWidth(float width) {
        this.shapeAttribute.setStrokeWidth(width);
    }

    @Override
    public float getStrokeWidth() {
        return this.shapeAttribute.getStrokeWidth();
    }

    @Override
    public void setFillColor(Color color) {
        this.shapeAttribute.setFillColor(color);
    }

    @Override
    public Color getFillColor() {
        return this.shapeAttribute.getFillColor();
    }

    @Override
    public void setFilled(boolean isFilled) {
        this.shapeAttribute.setFilled(isFilled);
    }

    @Override
    public boolean isFilled() {
        return this.shapeAttribute.isFilled();
    }

    @Override
    public void setContinuous(boolean isContinuous) {
        this.shapeAttribute.setCont(isContinuous);

    }

    @Override
    public boolean isContinuous() {
        return this.shapeAttribute.isCont();
    }

    /**
     * @return the isGradient
     */
    public boolean isGradient() {
        return this.shapeAttribute.isGradient();
    }

    /**
     * @param isGradient the isGradient to set
     */
    @Override
    public void setIsGradient(boolean isGradient) {
        this.shapeAttribute.setIsGradient(isGradient);
    }

    /**
     * @return the fillPaint
     */
    public Paint getFillPaint() {
        return this.shapeAttribute.getGradient();
    }

    @Override
    public void setGradient(GradientPaint p) {
        this.shapeAttribute.setGradient(p);
    }

    @Override
    public GradientPaint getGradient() {
        return this.shapeAttribute.getGradient();
    }
    
    
    @Override
    public boolean isContained(Point2D point) {
        if (this.contains(point)) {
            return true;
        }
        return false;
    }

    @Override
    public void setLocation(Point2D pos) {
        //this.lineTo(pos.getX(),pos.getY());
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.lineTo(p2.getX(), p2.getY());
    }

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
            System.out.println("Is Gradient");
            g2d.setPaint(this.shapeAttribute.getGradient());
            g2d.fill(this);
        }

    }
}
