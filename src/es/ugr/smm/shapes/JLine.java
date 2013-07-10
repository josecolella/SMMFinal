/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
