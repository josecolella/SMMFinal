/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public class JGeneralPath extends GeneralPath.Float implements JShape {

    private Color paintColor;
    private Stroke lineStroke;
    private float strokeWidth;
    private boolean isFilled;
    private boolean isEditable;
    private boolean isCont;

    /**
     *
     */
    public JGeneralPath() {
        super();
        paintColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
        
    }

    private void initializeShapeProperties()
    {
        lineStroke = new BasicStroke(strokeWidth);
        isFilled = false;
        isEditable = false;
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
    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    public boolean isFilled() {
        return isFilled;
    }

    @Override
    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    @Override
    public boolean isEditable() {
        return this.isEditable;
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
         //this.lineTo(pos.getX(),pos.getY());
        
    
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.lineTo(p2.getX(), p2.getY());
    }

    @Override
    public void paint(Graphics g) {
         Graphics2D g2d = (Graphics2D)g;
        if(isCont) g2d.setStroke(this.lineStroke);
        else if(!isCont) g2d.setStroke(new BasicStroke(this.strokeWidth,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f,JShape.dash1, 0.0f));
        g2d.setPaint(this.paintColor);
        g2d.draw(this);

    }
}
