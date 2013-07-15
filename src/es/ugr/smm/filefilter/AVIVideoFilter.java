package es.ugr.smm.filefilter;

/**
 * AVIVideoFilter extiende <tt>VideoFileFilter</tt> y agrega
 * la descripción del tipo de archivo .avi
 * 
 * @author Jose Colella
 * @version 1.0
 * @see FileFilter
 */
public class AVIVideoFilter extends VideoFileFilter {

    /**
     * Devuelve la descripción de los ficheros 
     * de extensión .avi
     * 
     * @return descripción de los fichero .avi
     */
    @Override
    public String getDescription() {
         return "AVI files (*.avi)";
    }
    
}
