package es.ugr.smm.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jose
 */
abstract public class SoundFileFilter extends FileFilter{

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