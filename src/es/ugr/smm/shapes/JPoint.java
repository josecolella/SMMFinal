/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public class JPoint extends AbstractAttributableLine {
    
    public JPoint(Point2D p1, Point2D p2) {
        super(p1, p1);
    }

//     public JPoint(Point2D p1, Point2D p2, Color color)
//    {
//        super(p1,p1,color);
//    }
//    
//    public JPoint(Point2D p1, Point2D p2, Color color, float strokeWidth)
//    {
//        super(p1,p1,color,strokeWidth);
//    }
    
    
    @Override
    public void setLocation(Point2D p)
    {
        super.setLine(p.getX(), p.getY(), p.getX()+1, p.getY()+1);
    }
    
    @Override
    public void update(Point2D p1, Point2D p2)
    {
        this.setLine(p1, p1);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (isCont) {
            lineStroke = new BasicStroke(this.strokeWidth);
            g2d.setStroke(lineStroke);
        } else if (!isCont) {
            lineStroke = new BasicStroke(this.strokeWidth,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, JShape.dash1, 0.0f);
            g2d.setStroke(lineStroke);
        }
        g2d.setPaint(this.paintColor);
        g2d.draw(this);

    }
}
