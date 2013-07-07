/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.shapes;

/**
 *
 * @author Jose
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
