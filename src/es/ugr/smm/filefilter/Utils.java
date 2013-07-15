package es.ugr.smm.filefilter;

import java.io.File;

/**
 * Esta clase implementa las extensiones
 * validas para la aplicación 
 * 
 * @author Oracle
 * @version 1.0
 */
public class Utils {

    //Las extensiones validas
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String png = "png";
    public final static String wav = "wav";
    public final static String mp3 = "mp3";
    public final static String avi = "avi";
    
    /**
     * Devuelve la extension de fichero
     * @param f Fichero a analizar
     * @return La extensión del fichero
     */  
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}