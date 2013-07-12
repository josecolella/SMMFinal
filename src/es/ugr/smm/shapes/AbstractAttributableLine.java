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
 *
 * @author Jose
 */
public abstract class AbstractAttributableLine extends Line2D.Float implements JShape {

    protected ShapeAttribute shapeAttribute;

    protected AbstractAttributableLine() {
        super();
        shapeAttribute = new ShapeAttribute();
    }

    protected AbstractAttributableLine(Point2D p1, Point2D p2) {
        super(p1, p2);
        shapeAttribute = new ShapeAttribute();
    }

    /**
     * @return the paintColor
     */
    @Override
    public Color getPaintColor() {
        return shapeAttribute.getPaintColor();
    }

    /**
     * @param paintColor the paintColor to set
     */
    @Override
    public void setPaintColor(Color color) {
        this.shapeAttribute.setPaintColor(color);
    }

    @Override
    public void setFillColor(Color color) {
        this.shapeAttribute.setFillColor(color);
    }

    @Override
    public Color getFillColor() {
        return this.shapeAttribute.getFillColor();
    }

    /**
     * @return the strokeWidth
     */
    @Override
    public float getStrokeWidth() {
        return shapeAttribute.getStrokeWidth();
    }

    /**
     * @param strokeWidth the strokeWidth to set
     */
    @Override
    public void setStrokeWidth(float strokeWidth) {
        this.shapeAttribute.setStrokeWidth(strokeWidth);
    }

    /**
     * @return the isFilled
     */
    @Override
    public boolean isFilled() {
        return shapeAttribute.isFilled();
    }

    /**
     * @param isFilled the isFilled to set
     */
    @Override
    public void setFilled(boolean isFilled) {
        this.shapeAttribute.setFilled(isFilled);
    }

    @Override
    public void setGradient(GradientPaint p) {
        this.shapeAttribute.setGradient(p);
    }

    @Override
    public GradientPaint getGradient()
    {
        return this.shapeAttribute.getGradient();
    }
    
    @Override
    public void setIsGradient(boolean isGradient)
    {
        this.shapeAttribute.setIsGradient(isGradient);
    }
    @Override
    public void setContinuous(boolean isContinuous) {
        this.shapeAttribute.setCont(isContinuous);
    }

    @Override
    public boolean isContinuous() {
        return shapeAttribute.isCont();
    }

    private boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 2.0;
    }

    @Override
    public boolean isContained(Point2D point) {
        if (this.isNear(point)) {
            return true;
        }
        return false;
    }

    @Override
    abstract public void setLocation(Point2D pos);

    @Override
    abstract public void update(Point2D p1, Point2D p2);

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
