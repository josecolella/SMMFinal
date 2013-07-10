/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Jose Colella
 * @version 1.0
 */
public class JRectangle extends Rectangle2D.Float implements FillableShape {

    private Color paintColor;
    private Color fillColor;
    private Stroke lineStroke;
    private Paint fillPaint;
    private float strokeWidth;
    private boolean isFilled;
    
    private boolean isCont;

    public JRectangle() {
        super();
        paintColor = Color.BLACK;
        fillColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }

    private void initializeShapeProperties() {
        lineStroke = new BasicStroke(strokeWidth);
        isFilled = false;
        
        isCont = true;
    }

    @Override
    public void setPaintColor(Color color) {
        this.paintColor = color;
    }

    @Override
    public Color getPaintColor() {
        return this.paintColor;
    }

    @Override
    public void setStrokeWidth(float width) {
        this.strokeWidth = width;
        this.lineStroke = new BasicStroke(strokeWidth);
    }

    @Override
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    public boolean isFilled() {
        return isFilled;
    }

   
    @Override
    public void setContinuous(boolean isContinuous) {
        this.isCont = isContinuous;
    }

    @Override
    public boolean isContinuous() {
        return this.isCont;
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
        this.setFrame(pos.getX(), pos.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.setFrameFromDiagonal(p1, p2);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (isCont) {
            g2d.setStroke(this.lineStroke);
        } else if (!isCont) {
            g2d.setStroke(new BasicStroke(this.strokeWidth,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, JShape.dash1, 0.0f));
        }
        g2d.setPaint(this.paintColor);
        if (!isFilled) {
            g2d.draw(this);
        } else if (isFilled) {
            g2d.fill(this);
        }
    }
}
