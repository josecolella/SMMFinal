/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

/**
 * El enum Shapes representa un tipo especial 
 * que denota las formas dispondibles de dibujo
 * como constantes predefinidas. 
 * Se ha sobrecargado <code>toString()</code> 
 * en todos los contantes para que declare la forma
 * actual.
 * 
 * Este enum es usado para denotar la forma actual 
 * {@link JShape} de dibujo
 * 
 * @author Jose Colella
 * @version 1.0
 */
public enum Shapes {
    
    POINT{
        @Override
        public String toString() {
            return "Punto";
        }
    },
    LINE{
        @Override
        public String toString() {
            return "Linea";
        }
    },
    RECTANGLE{
        @Override
        public String toString() {
            return "Rectángulo";
        }
    },
    ELLIPSE{
        @Override
        public String toString() {
            return "Elipse";
        }
    },
    FREEFORM{
        @Override
        public String toString() {
            return "Trazo Libre";
        }
    },
}
