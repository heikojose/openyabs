/*
 * billsNotesEditor.java
 *
 * Created on July 21, 2008, 5:35 PM
 */
package mp4.panels.rechnungen;

import mp4.items.RechnungBetreffzeile;
import mp4.items.Rechnung;
import mp4.benutzerverwaltung.User;
import mp4.frames.mainframe;

import mp3.classes.interfaces.panelInterface;
import mp4.utils.tabellen.DataModelUtils;
import mp4.utils.tabellen.SelectionCheck;
import mp4.utils.tabellen.TableFormat;
import mp4.utils.tabellen.models.BillNotesTableModel;

/**
 *
 * @author  Administrator
 */
public class billsNotesEditor extends javax.swing.JFrame {

    private Rechnung rechnung;
    private panelInterface panel;


    public billsNotesEditor(Rechnung current, panelInterface panel) {
        initComponents();
        jTable2.setModel(new BillNotesTableModel());
        jTable1.setModel(new BillNotesTableModel(current.getZeilenHandler().getOriginalListData(), new String[]{"id", "Name", "Text"}));

        resizeTables();
        this.rechnung = current;
        this.panel = panel;
        new mp4.utils.windows.Position().center(this);
        setVisible(rootPaneCheckingEnabled);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {

jPanel1 = new javax.swing.JPanel();
jScrollPane1 = new javax.swing.JScrollPane();
jTable1 = new javax.swing.JTable();
jScrollPane2 = new javax.swing.JScrollPane();
jTable2 = new javax.swing.JTable();
jButton2 = new javax.swing.JButton();
jButton3 = new javax.swing.JButton();
jButton4 = new javax.swing.JButton();
jButton5 = new javax.swing.JButton();
jButton6 = new javax.swing.JButton();
jButton1 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Betreffzeilen");

jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Betreffzeilen editieren"));

jTable1.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		{null},
		{null},
		{null},
		{null}
	},
	new String [] {
		"Text"
	}
) {
	Class[] types = new Class [] {
		java.lang.String.class
	};

	public Class getColumnClass(int columnIndex) {
		return types [columnIndex];
	}
});
jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
jScrollPane1.setViewportView(jTable1);

jTable2.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		{null},
		{null},
		{null},
		{null}
	},
	new String [] {
		"Vorlagen"
	}
) {
	Class[] types = new Class [] {
		java.lang.String.class
	};
	boolean[] canEdit = new boolean [] {
		false
	};

	public Class getColumnClass(int columnIndex) {
		return types [columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
jScrollPane2.setViewportView(jTable2);

jButton2.setText("Entfernen");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

jButton3.setText("Zu Vorlagen");
jButton3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton3ActionPerformed(evt);
}
});

jButton4.setText("Speichern und schlie�en");
jButton4.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton4ActionPerformed(evt);
}
});

jButton5.setText("Entfernen");
jButton5.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton5ActionPerformed(evt);
}
});

jButton6.setText("Neue Zeile");
jButton6.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton6ActionPerformed(evt);
}
});

jButton1.setText("Abbrechen");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
.addComponent(jButton2)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jButton3)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jButton6))
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jButton5)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
.addComponent(jButton1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jButton4)))
.addContainerGap())
);
jPanel1Layout.setVerticalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jButton3)
.addComponent(jButton6))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton4)
.addComponent(jButton5)
.addComponent(jButton1))
.addContainerGap())
);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
);

pack();
}// </editor-fold>//GEN-END:initComponents
private void add(){
    SelectionCheck selection = new SelectionCheck(jTable2);

    if (selection.checkID()) {
        RechnungBetreffzeile zeile = new RechnungBetreffzeile(selection.getId());
        DataModelUtils.addToTable(jTable1, new String[]{zeile.getId().toString(), zeile.getName(), zeile.getText()});
    }
    resizeTables();
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   if(mainframe.getUser().doAction(User.EDITOR)) {
        SelectionCheck selection = new SelectionCheck(jTable1);

        if (selection.rowHasData(2)) {
            Object[] data = selection.getRowData();
            RechnungBetreffzeile zeile = new RechnungBetreffzeile();
            zeile.setName((String) data[1]);
            zeile.setText((String) data[2]);
            zeile.isVorlage(true);
            zeile.save();
            DataModelUtils.addToTable(jTable2, new String[]{zeile.getId().toString(), zeile.getName(), zeile.getText()});
        }
        resizeTables();
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

   if(mainframe.getUser().doAction(User.EDITOR)) {
        DataModelUtils.removeSelectedRowFromTable(jTable1);
        resizeTables();
    }

}//GEN-LAST:event_jButton2ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//GEN-LAST:event_jButton5ActionPerformed
  if(mainframe.getUser().doAction(User.EDITOR)) {
        SelectionCheck selection = new SelectionCheck(jTable2);

        if (selection.rowHasData(2)) {
            Object[] data = selection.getRowData();
            RechnungBetreffzeile zeile = new RechnungBetreffzeile(Integer.valueOf((String) data[0]));
            zeile.isVorlage(false);
            zeile.save();
            selection.removeRow();
        }
        resizeTables();
    }
}                                        

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    SelectionCheck selection = new SelectionCheck(jTable1);
    DataModelUtils.addToTable(jTable1, new Object[][]{{0, null, null}});
    resizeTables();
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

 if(mainframe.getUser().doAction(User.EDITOR)) {
        SelectionCheck selection = new SelectionCheck(jTable1);
        Object[][] obj = DataModelUtils.tableModelToArray(jTable1);
        this.rechnung.getZeilenHandler().removeAll();
        RechnungBetreffzeile z;

        this.rechnung.getZeilenHandler().removeAll();
        
        for (int i = 0; i < obj.length; i++) {
            
            if (obj[i][0] != null && obj[i][1] != null && obj[i][2] != null) {
                if (obj[i][0].equals(0)) {
                    this.rechnung.getZeilenHandler().add(new RechnungBetreffzeile((String) obj[i][1], (String) obj[i][2]));
                } else {
                    z = new RechnungBetreffzeile(Integer.valueOf(String.valueOf(obj[i][0])));
                    z.setName((String) obj[i][1]);
                    z.setText((String) obj[i][2]);
                    z.save();
                    this.rechnung.getZeilenHandler().add(z);
                }
            }
        }

        panel.updateTables();
        this.dispose();
    }
    
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed

// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton5;
private javax.swing.JButton jButton6;
private javax.swing.JPanel jPanel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JScrollPane jScrollPane2;
private javax.swing.JTable jTable1;
private javax.swing.JTable jTable2;
// End of variables declaration//GEN-END:variables

    private void resizeTables() {
        TableFormat.stripFirst(jTable1);
        TableFormat.stripFirst(jTable2);
        TableFormat.resizeCols(jTable1, new Integer[]{null,100}, true);
        TableFormat.resizeCols(jTable2, new Integer[]{null,100}, true);
        
        TableFormat.makeUneditable(jTable2);
    }
}
