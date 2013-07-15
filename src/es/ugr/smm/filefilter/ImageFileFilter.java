package es.ugr.smm.filefilter;

import java.io.File;
import javax.swing.filechooser.*;
/**
 * ImageFileFilter es una clase abstracta que denota 
 * todas las extensiones de imágenes que se pueden
 * aceptar como validas
 * 
 * @author Jose Colella
 * @version 1.0
 * @see FileFilter
 */
abstract public class ImageFileFilter extends FileFilter{

    /**
     * Metodo que denota los ficheros y directorios 
     * validos para un ImageFileFilter
     * 
     * @param f El fichero
     * @return true si el fichero cumple con las reglas
     */
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg) ||
                extension.equals(Utils.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }


}
