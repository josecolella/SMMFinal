/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.geom.Point2D;

/**
 *
 * @author Jose
 */
public class JLine extends AbstractAttributableLine {

    public JLine() {
        super();

    }

    public JLine(Point2D p1, Point2D p2) {
        super(p1, p2);

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
}
