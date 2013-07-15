package es.ugr.smm.filefilter;

/**
 * PNGImageFilter extiende <tt>ImageFileFilter</tt>
 * y agrega la descripción de ficheros con extensión
 * .png
 * 
 * @author Jose Colella
 * @version 1.0 
 * @see ImageFileFilter
 */
public class PNGImageFilter extends ImageFileFilter{

     /**
     * Devuelve la descripción de ficheros .png
     * 
     * @return String descripción de ficheros de extensión .png
     */
    @Override
    public String getDescription() {
        return "PNG files (*.png)";
    }
    
    
}
