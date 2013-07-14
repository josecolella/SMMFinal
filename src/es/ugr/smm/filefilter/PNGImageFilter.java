/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.smm.filefilter;

import es.ugr.smm.filefilter.ImageFileFilter;

/**
 *
 * @author Jose
 */
public class PNGImageFilter extends ImageFileFilter{

    @Override
    public String getDescription() {
        return "PNG files (*.png)";
    }
    
    
}
