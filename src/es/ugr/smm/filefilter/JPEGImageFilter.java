package es.ugr.smm.filefilter;

/**
 * JPEGImageFilter extiende <tt>ImageFileFilter</tt> y agrega 
 * la descripción de ficheros .jpeg, .jpg
 * 
 * @author Jose Colella
 * @version 1.0
 * @see ImageFileFilter
 */
public class JPEGImageFilter extends ImageFileFilter{

    /**
     * Devuelve la descripción de ficheros con extensión .jpeg
     * 
     * @return String descripción de ficheros con extensión .jpeg
     */
    @Override
    public String getDescription() {
        return "JPEG files (*.jpeg,*.jpg)";
    }
    
    
}
