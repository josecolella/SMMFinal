package es.ugr.smm.filefilter;

/**
 * GIFImageFilter extiende <tt>ImageFileFilter</tt>
 * y agrega la descripción de los ficheros con extensión
 * .gif
 * 
 * @author Jose Colella
 * @version 1.0
 */
public class GIFImageFilter extends ImageFileFilter{

    /**
     * Devuelve la descripción de los ficheros 
     * de extensión .gif
     * 
     * @return descripción de los fichero .gif
     */
    @Override
    public String getDescription() {
        return "GIF files (*.gif)";
    }
    
    
}