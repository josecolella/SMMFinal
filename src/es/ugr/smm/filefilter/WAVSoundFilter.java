package es.ugr.smm.filefilter;

/**
 * WAVSoundFilter extiende <tt>SoundFileFilter</tt>
 * y agrega la descripción de ficheros de extensión 
 * .wav
 * 
 * @author Jose Colella
 * @version 1.0
 * @see SoundFileFilter
 */
public class WAVSoundFilter extends SoundFileFilter {

    /**
     * Devuelve la descripción de ficheros .wav
     * 
     * @return String descripción de ficheros de extensión .wav
     */
    @Override
    public String getDescription() {
        return "WAV files (*.wav)";
    }
}
