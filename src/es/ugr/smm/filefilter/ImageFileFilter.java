/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.filefilter;

import java.io.File;
import javax.swing.filechooser.*;
/**
 *
 * @author Jose
 */
abstract public class ImageFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg) ||
                extension.equals(Utils.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }


}
