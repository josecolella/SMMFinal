/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import static es.ugr.smm.shapes.JShape.dash1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public class JLine extends Line2D.Float implements JShape {

    private Color paintColor;
    private Stroke lineStroke;
    private float strokeWidth;
    private boolean isFilled;
    private boolean isEditable;
    private boolean isCont;

    public JLine() {
        super();
        paintColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }

    public JLine(Point2D p1, Point2D p2) {
        super(p1, p2);
        paintColor = Color.BLACK;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }

    public JLine(Point2D p1, Point2D p2, Color color) {
        super(p1, p2);
        paintColor = color;
        strokeWidth = (float) 1.0;
        initializeShapeProperties();
    }

    public JLine(Point2D p1, Point2D p2, Color color, float strokeWidth) {
        super(p1, p2);
        paintColor = color;
        this.strokeWidth = strokeWidth;
        initializeShapeProperties();
    }

    private void initializeShapeProperties() {
        lineStroke = new BasicStroke(strokeWidth);
        isFilled = false;
        isEditable = false;
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
        g2d.draw(this);

    }
}
