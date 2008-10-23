/*
 * overdue.java
 *
 * Created on 13. Februar 2008, 13:19
 */

package mp4.panels.rechnungen;


import mp4.logs.*;
import mp4.items.Product;
import mp4.items.Rechnung;

import mp4.items.Kunde;
import mp4.utils.export.pdf.PDF_Mahnung;
import mp4.benutzerverwaltung.User;
import mp4.einstellungen.Einstellungen;
import mp4.einstellungen.Programmdaten;
import mp4.einstellungen.VariablenZuText;
import mp4.frames.mainframe;
import mp4.frames.PdfVorschauWindow;
import mp4.interfaces.DataPanel;
import mp4.utils.datum.DateConverter;
import mp4.utils.export.druck.DruckJob;
import mp4.utils.files.PDFFile;
import mp4.utils.tasks.Job;
import mp4.utils.ui.Position;
import mp4.utils.ui.inputfields.InputVerifiers;

import mp4.utils.zahlen.FormatNumber;

/**
 *
 * @author  anti43
 */
public class MahnungView extends javax.swing.JFrame {
    private Rechnung bill;
    private Kunde c;
    private DataPanel view;
//, new Kunde(current.getKundenId()), view
    public MahnungView(Rechnung current) {
        initComponents();
        
        this.bill = current;
        this.bill.setMahnungen(this.bill.getMahnungen()+1);
        this.c = new Kunde(bill.getKundenId());

        this.jTextArea1.setText(Programmdaten.instanceOf().getMAHNUNG_TEXT_DEFAULT());
        
        jLabel2.setText(bill.getRechnungnummer());
        jLabel6.setText(c.getFirma());
        jTextField1.setText(DateConverter.getTodayDefDate());
        jButton1.setEnabled(false);
        
        jTextField2.setInputVerifier(InputVerifiers.getDoubleInputVerfier(jTextField2));
        
        new Position(this);
        this.setVisible(rootPaneCheckingEnabled);
    }
    
    /** Creates new form overdue
     * @param bill
     * @param Kunde
     * @param view 
     */
    public MahnungView(Rechnung bill, Kunde Kunde, DataPanel  view) {
        initComponents();
        
        this.bill=bill;
        this.bill.setMahnungen(this.bill.getMahnungen()+1);
        this.c=Kunde;
        this.view = view;   
        this.jTextArea1.setText(Programmdaten.instanceOf().getMAHNUNG_TEXT_DEFAULT());
        
        jLabel2.setText(bill.getRechnungnummer());
        jLabel6.setText(Kunde.getFirma());
        jTextField1.setText(DateConverter.getTodayDefDate());
        
        jTextField2.setInputVerifier(InputVerifiers.getDoubleInputVerfier(jTextField2));
        
        new Position(this);
        this.setVisible(rootPaneCheckingEnabled);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
private void initComponents() {

jPanel1 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();
jTextArea1 = new javax.swing.JTextArea();
jLabel3 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jLabel5 = new javax.swing.JLabel();
jLabel6 = new javax.swing.JLabel();
jLabel7 = new javax.swing.JLabel();
jTextField2 = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
jTextField1 = new javax.swing.JTextField();
jButton3 = new javax.swing.JButton();
jButton4 = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("MP Mahnung Editor");
setResizable(false);

jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mahnung erstellen"));

jLabel1.setText("Rechnung Nummer:");

jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
jScrollPane1.setAutoscrolls(true);

jTextArea1.setColumns(20);
jTextArea1.setFont(new java.awt.Font("Arial", 0, 12));
jTextArea1.setLineWrap(true);
jTextArea1.setRows(5);
jTextArea1.setWrapStyleWord(true);
jScrollPane1.setViewportView(jTextArea1);

jLabel3.setText("Mahntext:");

jButton1.setText("Zu Rechnung");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setText("Abbruch");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

jLabel5.setText("Kunde:");

jLabel7.setText("Mahngebühr:");

jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11));
jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
jTextField2.setText("0,0");
jTextField2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jTextField2ActionPerformed(evt);
}
});

jLabel4.setText("Datum der Mahnung:");

jButton3.setText("Vorschau");
jButton3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton3ActionPerformed(evt);
}
});

jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/3232/agt_print.png"))); // NOI18N
jButton4.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton4ActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jLabel7)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(40, 40, 40)
.addComponent(jButton2))
.addGroup(jPanel1Layout.createSequentialGroup()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel1)
.addComponent(jLabel5))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
.addComponent(jLabel3))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jLabel4)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jButton3)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jButton1))
.addComponent(jButton4)))
.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
.addContainerGap())
);
jPanel1Layout.setVerticalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
.addComponent(jButton4))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
.addComponent(jLabel4))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jButton1)
.addComponent(jButton3)
.addComponent(jButton2)
.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel7))
.addContainerGap())
);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
);

pack();
}// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
       if(mainframe.getUser().doAction(User.EDITOR)) {
            try {

//            new PDF_Mahnung(bill, VariablenZuText.parseText(jTextArea1.getText(), new Object[]{bill, Kunde}), bill.getMahnungen().toString(), FormatNumber.parseDezimal(jTextField2.getText()));
                
                view.setProduct(new Product("Mahnung vom " + DateConverter.getTodayDefDate(),
                        FormatNumber.parseDezimal(jTextField2.getText())));
                Programmdaten.instanceOf().setMAHNUNG_TEXT_DEFAULT(jTextArea1.getText());
                this.dispose();
            } catch (NumberFormatException numberFormatException) {
                Log.Debug(this,numberFormatException);
            }
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        
    }//GEN-LAST:event_jTextField2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

   new PdfVorschauWindow(new PDFFile(new PDF_Mahnung(bill, 
           VariablenZuText.parseText(jTextArea1.getText(), new Object[]{bill, c}), 
           FormatNumber.parseDezimal(jTextField2.getText()), bill.getMahnungen())));

}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    Job job = new Job(new PDFFile(new PDF_Mahnung(bill, 
           VariablenZuText.parseText(jTextArea1.getText(), new Object[]{bill, c}), 
           FormatNumber.parseDezimal(jTextField2.getText()), bill.getMahnungen())), new mp4.utils.export.druck.DruckJob());
}//GEN-LAST:event_jButton4ActionPerformed
    

    
// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JPanel jPanel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea jTextArea1;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
// End of variables declaration//GEN-END:variables
    
}
