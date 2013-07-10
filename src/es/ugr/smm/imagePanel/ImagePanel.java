package es.ugr.smm.imagePanel;

import es.ugr.smm.internalWindow.jImageInternalWindow;
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
 * ImagePanel representa el lienzo de imágenes
 * donde se crean imágenes de usuarios, o generadas 
 * de capturas de:
 * <ul>
 *  <li>VentanaInternaCamara</li>
 *  <li>VentanaInternaJMFPlayer</li>
 * </ul>
 * Sobre el se puede dibujar diversas formas {@link JShape} con diversos
 * atributos. Las siguientes formas son validas:
 * <ul>
 *  <li>JLine</li>
 *  <li>JPoint</li>
 *  <li>JEllipse</li>
 *  <li>JRectangle</li>
 *  <li>JGeneralPath</li>
 * </ul>
 * <p>
 * Sobre dichos {link JShape} se puede manipular los siguientes 
 * atributos:
 * <ul>
 *  <li>Color</li>
 *  <li>Stroke</li>
 *  <li>Filling</li>
 * </ul>
 * </p>
 * <p>
 * Además se puede manipular las imágenes con diversas 
 * operaciones.
 * </p>
 *
 *
 * @author Jose Colella
 * @version 1.0
 * @see jImageInternalWindow
 */
public class ImagePanel extends javax.swing.JPanel {

    private static int DEFAULT_HEIGHT = 300;
    private static int DEFAULT_WIDTH = 300;
    
    private Shapes currentDrawingShape;
    private Color currentShapeColor;
    private float strokeWidth;
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
     * Construye un ImagePanel e inicializa sus componentes
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
        currentShape = new JPoint(new Point2D.Float(-1, -1), new Point2D.Float(-1, -1));
        isEditable = false;
        isShapeFilled = false;
        isCont = true;
    }
    /**
     * Construye un ImagePanel con las dimensiones 
     * especificadas como parametros de entrada
     * 
     * @param height La altura de la ventana a construir
     * @param width  La anchura de la venta a construir
     * @see Integer
     */
    public ImagePanel(Integer height, Integer width) {
        initComponents();
        this.height = height;
        this.width = width;
        defaultImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        jShapeArray = new ArrayList();
        currentShapeColor = Color.BLACK;
        currentDrawingShape = Shapes.POINT;
        strokeWidth = (float) 1.0;
        currentShape = new JPoint(new Point2D.Float(-1, -1), new Point2D.Float(-1, -1));
        isEditable = false;
        isShapeFilled = false;
        isCont = true;
    }
    //Devuelve la forma que esta contenida en el {@link Point2D} pasado
    //parametro
    private JShape getSelectedShape(Point2D p) {
        for (JShape s : jShapeArray) {
            if (s.isContained(p)) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Asigna el color de la forma {@link JShape} actual
     * 
     * @param color El color que caracteriza la forma actual 
     * @see Color
     * @see JShape
     */
    public void setCurrentShapeColor(Color color) {
        this.currentShapeColor = color;
    }

    /**
     * Devuelve el color de la forma actual
     * 
     * @return el Color de la forma {@link JShape}
     */
    public Color getCurrentShapeColor() {
        return this.currentShapeColor;
    }

    /**
     * Devuelve el flotante que representa la anchura 
     * del Trazo 
     * 
     * @return flotante que representa la anchura
     * @see Stroke
     */
    public float getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * Asigna el flotante que representa la anchura del 
     * trazo de la forma actual
     *
     * @param strokeWidth El flotante que representa la anchura 
     * 
     */
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * Metodo que asigna si las formas del lienzo pueden
     * ser editadas
     * 
     * @param isEdit un booleano que determina si las formas del ImagePanel 
     *               se pueden editar
     * 
     */
    public void setIsEdit(boolean isEdit) {
        this.isEditable = isEdit;
    }

    /**
     * Asigna si la forma actual esta rellena
     * 
     * @param isShapeFilled booleano que indica si la forma esta rellena
     */
    public void setShapeFilled(boolean isShapeFilled) {
        this.isShapeFilled = isShapeFilled;
    }

    /**
     * Asigna un booleano que indica si la forma 
     * es continua o discontinua
     * 
     * @param isCont booleana que representa si la forma es continua
     */
    public void setIsCont(boolean isCont) {
        this.isCont = isCont;
    }

    /**
     * El metodo coge el parametro y lo asigna
     * a el lienzo, además cambia la dimensión
     * de la ventana interna con las dimensiones de la
     * {@link BufferedImage}
     * 
     * @param image 
     * @see BufferedImage
     */
    public void setImage(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    /**
     * Devuelve la imagen actual que tiene el lienzo actual
     * 
     * @return BufferedImage la imágen del lienzo
     */
    public BufferedImage getImage() {
        return image == null ? defaultImage : image;
    }

    /**
     * Asigna la forma actual del lienzo
     * usando {@link Shapes}
     * 
     * @param s La forma actual
     * @see Shapes
     */
    public void setCurrentForm(Shapes s) {
        this.currentDrawingShape = s;
    }

    /**
     * El metodo devuelve una cadena de caracteres 
     * que representa la forma actual a dibujar
     * 
     * @return String La cadena de catacteres que representa la forma
     */
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
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
        } else if (currentShape.getClass() != JPoint.class) {
            updateShape(p, evt.getPoint());
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (isEditable) {
            currentShape = this.getSelectedShape(evt.getPoint());
        } else if (currentShape.getClass() == JPoint.class) {
            currentShape.setLocation(evt.getPoint());
            this.repaint();
        }
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
