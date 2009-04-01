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
package mpv5.ui.menus;

import javax.swing.JMenuItem;
import mpv5.db.common.DatabaseObject;
import mpv5.ui.frames.MPV5View;

/**
 *
 * @author anti
 */
public class ClipboardMenuItem extends JMenuItem {

    private static final long serialVersionUID = 1L;
    private DatabaseObject item;

    public ClipboardMenuItem(final DatabaseObject dbo) {
        this.item = dbo;
        this.setText(dbo.__getCName());
        this.setIcon(dbo.getTypeIcon());

        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 MPV5View.identifierView.getCurrentTab().paste(dbo);
            }
        });

    }

    public ClipboardMenuItem(DatabaseObject dbo, String name) {
        this.item = dbo;
        this.setText(name);
        this.setIcon(dbo.getTypeIcon());
    }

    /**
     * @return the item
     */
    public DatabaseObject getItem() {
        return item;
    }
}
