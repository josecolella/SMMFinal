/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.imagePanel;

import es.ugr.smm.shapes.Shapes;
import es.ugr.smm.shapes.JEllipse;
import es.ugr.smm.shapes.JGeneralPath;
import es.ugr.smm.shapes.JLine;
import es.ugr.smm.shapes.JRectangle;
import es.ugr.smm.shapes.JShape;
import es.ugr.smm.shapes.JPoint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class ImagePanel extends javax.swing.JPanel {

    private Shapes currentDrawingShape;
    private Color currentShapeColor;
    private float strokeWidth;
    private static int DEFAULT_HEIGHT = 300;
    private static int DEFAULT_WIDTH = 300;
    private int height;
    private int width;
    private BufferedImage defaultImage;
    private BufferedImage image;
    private Graphics2D g2dImg;
    private List<JShape> jShapeArray;
    private JShape currentShape;
    private Point2D p;
    private boolean isEditable;
    private boolean isShapeFilled;
    private boolean isCont;

    /**
     * Creates new form ImagePanel
     */
    public ImagePanel() {
        initComponents();
        this.height = DEFAULT_HEIGHT;
        this.width = DEFAULT_WIDTH;
        defaultImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        jShapeArray = new ArrayList();
        currentShapeColor = Color.BLACK;
        currentDrawingShape = Shapes.POINT;
        strokeWidth = (float) 1.0;
        currentShape = new JPoint(new Point2D.Float(-1,-1), new Point2D.Float(-1,-1));
        isEditable = false;
        isShapeFilled = false;
        isCont = true;
    }

    public ImagePanel(Integer height, Integer width) {
        initComponents();
        this.height = height;
        this.width = width;
        defaultImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        jShapeArray = new ArrayList();
        currentShapeColor = Color.BLACK;
        currentDrawingShape = Shapes.POINT;
        strokeWidth = (float) 1.0;
        currentShape = new JPoint(new Point2D.Float(-1,-1), new Point2D.Float(-1,-1));
        isEditable = false;
        isShapeFilled = false;
        isCont = true;
    }

    private JShape getSelectedShape(Point2D p) {
        for (JShape s : jShapeArray) {
            if (s.isContained(p)) {
                return s;
            }
        }
        return null;
    }

    public void setCurrentShapeColor(Color color) {
        this.currentShapeColor = color;
    }

    public Color getCurrentShapeColor()
    {
        return this.currentShapeColor;
    }
    
     /**
     * @return the strokeWidth
     */
    public float getStrokeWidth() {
        return strokeWidth;
    }

    
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    
    public void setIsEdit(boolean isEdit) {
        this.isEditable = isEdit;
    }

    public void setShapeFilled(boolean isShapeFilled) {
        this.isShapeFilled = isShapeFilled;
    }

    /**
     * @param isCont the isCont to set
     */
    public void setIsCont(boolean isCont) {
        this.isCont = isCont;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    public BufferedImage getImage() {
        return image == null ? defaultImage : image;
    }

    public void setCurrentForm(Shapes s) {
        this.currentDrawingShape = s;
    }

    public String getCurrentForm() {
        return this.currentDrawingShape.toString();
    }

    public JShape getCurrentShape() {
        return this.currentShape;
    }

    public JShape createShape(Point2D punto1, Point2D punto2) {
        if (this.currentDrawingShape == Shapes.POINT) {
            currentShape = new JPoint(punto1, punto2);
        } else if (this.currentDrawingShape == Shapes.LINE) {
            currentShape = new JLine(punto1, punto2);
        } else if (this.currentDrawingShape == Shapes.RECTANGLE) {
            currentShape = new JRectangle();
            ((JRectangle) currentShape).setFrameFromDiagonal(punto1, punto2);
        } else if (this.currentDrawingShape == Shapes.ELLIPSE) {
            currentShape = new JEllipse(currentShapeColor);
            ((JEllipse) currentShape).setFrameFromDiagonal(punto1, punto2);
        } else if (this.currentDrawingShape == Shapes.FREEFORM) {
            currentShape = new JGeneralPath();
            ((JGeneralPath) currentShape).moveTo(punto1.getX(), punto1.getY());
        }

        //Set the attributes for the JShape to create
        currentShape.setPaintColor(this.currentShapeColor);
        currentShape.setStrokeWidth(this.strokeWidth);
        currentShape.setFilled(this.isShapeFilled);
        currentShape.setContinuous(isCont);
        
        return currentShape;
    }

    public void updateShape(Point2D p1, Point2D p2) {
        currentShape.update(p1, p2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2dImg = (Graphics2D) g;
        if (image == null) {
            //The x,y location specifies the position for the top-left of the image.
            
            g2dImg.drawImage(defaultImage, 0, 0, this);
            g2dImg = defaultImage.createGraphics();
           
            g2dImg.setBackground(Color.WHITE);
            g2dImg.clearRect(0, 0, this.height, this.width);
            

        } else if (image != null) {
            g2dImg.drawImage(image, 0, 0, this);
        }

        //Codigo para pintar Shapes

        for (JShape a : jShapeArray) {
            a.paint(g2dImg);
        }
        if (currentShape != null) {
            currentShape.paint(g2dImg);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p = evt.getPoint();
        if (isEditable) {
            currentShape = this.getSelectedShape(evt.getPoint());
        } else {
            currentShape = (JShape) createShape(p, p);
            jShapeArray.add(currentShape);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (!isEditable) {
            updateShape(p, evt.getPoint());
        }
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (isEditable) {
            currentShape.setLocation(evt.getPoint());
        } else {
            updateShape(p, evt.getPoint());
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
}
