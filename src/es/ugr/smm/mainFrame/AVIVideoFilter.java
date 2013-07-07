/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.mainFrame;

import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jose
 */
class AVIVideoFilter extends VideoFileFilter {


    @Override
    public String getDescription() {
         return "AVI files (*.avi)";
    }
    
}
