/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.mainFrame;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jose
 */
abstract class VideoFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
          if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.avi)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

 
    
}