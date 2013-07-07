/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public class JPoint extends JLine implements JShape {
    
    public JPoint(Point2D p1, Point2D p2) {
        super(p1, p1);
    }

     public JPoint(Point2D p1, Point2D p2, Color color)
    {
        super(p1,p1,color);
    }
    
    public JPoint(Point2D p1, Point2D p2, Color color, float strokeWidth)
    {
        super(p1,p1,color,strokeWidth);
    }
    
    
    @Override
    public void setLocation(Point2D p)
    {
        super.setLine(p.getX(), p.getY(), p.getX()+0.1, p.getY()+0.1);
    }
    
    @Override
    public void update(Point2D p1, Point2D p2)
    {
        this.setLine(p1, p1);
    }
}
