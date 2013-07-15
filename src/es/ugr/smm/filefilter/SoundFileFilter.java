package es.ugr.smm.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * SoundFileFilter extiende <tt>FileFilter</tt>
 * e implementa los ficheros de sonido que son validos
 * en esta aplicación
 * 
 * @author Jose Colella
 * @version 1.0
 * @see FileFilter
 */
abstract public class SoundFileFilter extends FileFilter{

   /**
     * Metodo que denota los ficheros y directorios 
     * validos para un SoundFileFilter
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
            if (extension.equals(Utils.wav) || extension.equals(Utils.mp3)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    
}
