/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public abstract class AbstractAttributableLine extends Line2D.Float implements JShape {

    protected Color paintColor;
    protected Stroke lineStroke;
    protected float strokeWidth;
    protected boolean isFilled;
    protected boolean isCont;

    
    protected AbstractAttributableLine()
    {
        super();
        paintColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }
    
    protected AbstractAttributableLine(Point2D p1, Point2D p2) {
        super(p1, p2);
        paintColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }

    
    private void initializeShapeProperties() {
        isFilled = false;      
        isCont = true;
    }
    /**
     * @return the paintColor
     */
    @Override
    public Color getPaintColor() {
        return paintColor;
    }

    /**
     * @param paintColor the paintColor to set
     */
    @Override
    public void setPaintColor(Color paintColor) {
        this.paintColor = paintColor;
    }


    /**
     * @return the strokeWidth
     */
    @Override
    public float getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * @param strokeWidth the strokeWidth to set
     */
    @Override
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * @return the isFilled
     */
    @Override
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * @param isFilled the isFilled to set
     */
    @Override
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
   public void setContinuous(boolean isContinuous) {
        this.isCont = isContinuous;
    }

    @Override
    public boolean isContinuous() {
        return isCont;
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
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.getX1();
        double dy = pos.getY() - this.getY1();
        Point2D newPoint;
        newPoint = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        this.setLine(pos, newPoint);
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.setLine(p1, p2);
    }

    abstract public void paint(Graphics g);
    
}
