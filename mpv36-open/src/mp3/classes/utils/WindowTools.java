/*
 *  This file is part of MP by anti43 /GPL.
 *  
 *      MP is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *  
 *      MP is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *  
 *      You should have received a copy of the GNU General Public License
 *      along with MP.  If not, see <http://www.gnu.org/licenses/>.
 */


package mp3.classes.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author anti43
 */
public class WindowTools {

    public WindowTools(Component comp){
    
        Dimension frameSize = new Dimension(comp.getSize());

        // Gr��e des Bildschirms ermitteln
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Position des JFrames errechnen
        int top = (screenSize.height - frameSize.height) / 2;
        int left = (screenSize.width - frameSize.width) / 2;

        // Gr��e zuordnen
        comp.setSize(frameSize);

        // Position zuordnen
        comp.setLocation(left, top);
    
    }

    private void setLocation(int left, int top) {
        
      
    }

    private void setSize(Dimension frameSize) {
  
     
    }
}
