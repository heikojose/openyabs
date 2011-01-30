/*
 *  This file is part of YaBS.
 *
 *      YaBS is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      YaBS is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with YaBS.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * GeneralListPanel.java
 *
 * Created on 03.04.2009, 15:26:37
 */
package mpv5.ui.panels;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.table.TableCellRenderer;
import mpv5.handler.TrashHandler;
import mpv5.globals.Headers;
import mpv5.globals.Messages;
import mpv5.ui.popups.TablePopUp;
import mpv5.utils.models.MPTableModel;
import mpv5.utils.tables.TableFormat;
import mpv5.utils.ui.TableViewPersistenceHandler;

/**
 *
 *  
 */
public class TrashPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private static TrashPanel ident;
    private java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle();

    public static TrashPanel instanceOf() {
        if (ident == null) {
            ident = new TrashPanel();
        }
        ident.setData();
        return ident;
    }
    private TablePopUp tablePopUp;
  

    /** Creates new form GeneralListPanel */
    private TrashPanel() {
        initComponents();
        setName("trashpanel");
        setData();
        tablePopUp = new TablePopUp(jTable1, new String[]{Messages.DELETE.toString(), Messages.RESTORE.toString(), null, Messages.RELOAD.getValue()}, new ActionListener[]{new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < jTable1.getSelectedRows().length; i++) {
                        try {
                            int id = Integer.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 1).toString());
                            String type = String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 0).toString());
                            TrashHandler.delete(type, id, String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 2).toString()) + Messages.DELETED);
                           
                        } catch (Exception numberFormatException) {
                        }
                    } setData();
                }
            }, new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < jTable1.getSelectedRows().length; i++) {
                        try {
                            int id = Integer.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 1).toString());
                            String type = String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 0).toString());
                            TrashHandler.restore(type, id, String.valueOf(jTable1.getModel().getValueAt(jTable1.getSelectedRows()[i], 2).toString()) + Messages.RESTORED);
                            
                        } catch (Exception numberFormatException) {
                        }
                    }setData();
                }
            }, null, new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    setData();
                }
            }});
      //  t = new mpv5.utils.ui.TableViewPersistenceHandler(jTable1, this);
    }

    public void setData() {
        
        jTable1.setModel(new MPTableModel(TrashHandler.getData(), Headers.TRASHBIN));
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new  mpv5.ui.misc.MPTable(this) {
            public Component prepareRenderer(TableCellRenderer renderer,
                int rowIndex, int vColIndex) {
                Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
                if (c instanceof JComponent) {
                    JComponent jc = (JComponent)c;
                    jc.setToolTipText(String.valueOf(getValueAt(rowIndex, vColIndex)));
                }
                return c;
            }
        };

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        java.util.ResourceBundle bundle = mpv5.i18n.LanguageManager.getBundle(); // NOI18N
        setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("TrashPanel.border.title"))); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setDragEnabled(true);
        jTable1.setFillsViewportHeight(true);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
//tablePopUp.show(jTable1, evt.getX(),evt.getY());
    }//GEN-LAST:event_jTable1MouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
