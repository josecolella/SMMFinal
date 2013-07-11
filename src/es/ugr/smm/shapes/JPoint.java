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
public class JPoint extends AbstractAttributableLine {

    public JPoint(Point2D p1, Point2D p2) {
        super(p1, p1);
    }

    @Override
    public void setLocation(Point2D p) {
        super.setLine(p.getX(), p.getY(), p.getX() + 1, p.getY() + 1);
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.setLine(p1, p1);
    }
}
