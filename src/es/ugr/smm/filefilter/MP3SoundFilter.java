package es.ugr.smm.filefilter;

/**
 * MP3SouandFilter extiende <tt>SoundFileFilter</tt>
 * y agrega la descripción de ficheros con extensión .mp3
 *
 * @author Jose Colella
 * @version 1.0
 * @see SoundFileFilter
 */
public class MP3SoundFilter extends SoundFileFilter {

    /**
     * Devuelve la descripción de ficheros .mp3
     * 
     * @return String descripción de ficheros de extensión .mp3
     */
    @Override
    public String getDescription() {
        return "MP3 files (*.mp3)";
    }
}
