/*
 * konten.java
 *
 * Created on 18. Februar 2008, 12:49
 */
package mp4.items.visual;

import mp4.items.Ausgabe;
import mp4.items.Einnahme;
import mp4.datenbank.verbindung.ConnectionHandler;

import mp4.items.SKRKonto;
import javax.swing.JTextField;

import mp4.logs.*;

import mp4.items.visual.Help;
import mp4.panels.eur.eurAPanel;


import mp4.panels.eur.eurEPanel;
import mp4.utils.tabellen.TableFormat;
import mp4.utils.ui.Position;

/**
 *
 * @author  anti43
 */
public class konten extends javax.swing.JFrame {

    private SKRKonto current;
    private JTextField field;
    private Einnahme einnahme;
    private Ausgabe ausgabe;
    private eurEPanel ep = null;
    private eurAPanel ap = null;
    private Position pos = new Position();

    public konten() {
        initComponents();
        current = new SKRKonto();
        TableFormat.formatUneditableTable(jTable1, current.select("id, Nummer, Klasse, Gruppe, Art", null, null, "klasse", false), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
        pos.center(this);
        jButton5.setEnabled(false);
        this.setVisible(rootPaneCheckingEnabled);
    }

    public konten(JTextField jText, Ausgabe bill, eurAPanel panel) {

        initComponents();
        this.ap = panel;
        this.ausgabe = bill;
        this.einnahme = null;
        this.field = jText;
        current = new SKRKonto();
        TableFormat.formatUneditableTable(jTable1, current.select("*", "klasse", "Ausgabe", "klasse", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
        pos.center(this);
        this.setVisible(rootPaneCheckingEnabled);
    }

    public konten(JTextField jText, Einnahme bill, eurEPanel panel) {
        initComponents();
        this.ep = panel;
        this.einnahme = bill;
        this.ausgabe = null;
        this.field = jText;
        current = new SKRKonto();
        TableFormat.formatUneditableTable(jTable1, current.select("*", "klasse", "Einnahme", "klasse", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
        pos.center(this);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MP Kontenrahmen");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontenrahmen"));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nummer", "Klasse", "Gruppe", "Art"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jButton4.setText("Beenden");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setText("Einf�gen");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator2);

        jButton2.setText("Hilfe");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jTextField4.setEditable(false);
        jTextField4.setDragEnabled(true);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setDragEnabled(true);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Art");

        jLabel7.setText("Klasse");

        jTextField6.setDragEnabled(true);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton9.setText("Filter");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Filter");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel9.setText("Gruppe");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setDragEnabled(true);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel10.setText("Nummer:");

        jLabel1.setText("Details:");

        jLabel2.setText("Tip: Filter sind Case-sensitiv!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10))))
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(jLabel6))
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel10)
                    .addGap(36, 36, 36)
                    .addComponent(jLabel7)
                    .addGap(36, 36, 36)
                    .addComponent(jLabel9)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel6)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        boolean idOk = true;
        Integer id = 0;
        try {
            id = Integer.valueOf((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        } catch (Exception numberFormatException) {
            idOk = false;
        }
        if (evt.getClickCount() >= 1 && idOk) {
            try {
                this.setKonto(new SKRKonto(ConnectionHandler.instanceOf(), id));
            } catch (Exception exception) {
                Log.Debug(this,exception);
            }
        }
        if (einnahme != null || ausgabe != null) {
            if (evt.getClickCount() >= 2 && idOk) {
                try {
                    this.current = new SKRKonto(ConnectionHandler.instanceOf(), id);
                    this.field.setText(getKonto().getArt());

                    if (this.einnahme != null) {
                        einnahme.setKontenid(getKonto().getId());
                        this.ep.setKonto(getKonto());
                    } else if (ausgabe != null) {
                        ausgabe.setKontenid(getKonto().getId());
                        this.ap.setKonto(getKonto());
                    }
                    this.dispose();
                } catch (Exception exception) {
                    Log.Debug(this,exception);
                }
            }
            idOk = true;
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

        TableFormat.formatUneditableTable(jTable1, current.select("*", "nummer", jTextField4.getText(), "nummer", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        TableFormat.formatUneditableTable(jTable1, current.select("*", "gruppe", jTextField5.getText(), "gruppe", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        TableFormat.formatUneditableTable(jTable1, current.select("*", "klasse", jTextField6.getText(), "klasse", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        TableFormat.formatUneditableTable(jTable1, current.select("*", "klasse", jTextField6.getText(), "klasse", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        TableFormat.formatUneditableTable(jTable1, current.select("*", "gruppe", jTextField5.getText(), "gruppe", true), "id, Nummer, Klasse, Gruppe, Art".split(","));
        TableFormat.format(jTable1, 1, 50);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        boolean idOk = true;
        Integer id = 0;

        try {
            id = Integer.valueOf((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        } catch (Exception numberFormatException) {
            idOk = false;
        }

        try {
            this.current = new SKRKonto(ConnectionHandler.instanceOf(), id);
            this.field.setText(getKonto().getArt());

            if (this.einnahme != null) {
                einnahme.setKontenid(getKonto().getId());
                this.ep.setKonto(getKonto());
            } else if (ausgabe != null) {
                ausgabe.setKontenid(getKonto().getId());
                this.ap.setKonto(getKonto());
            }

            this.dispose();
        } catch (Exception exception) {
            Log.Debug(this,exception);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new Help("/helpfiles/konten1");
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    public SKRKonto getKonto() {
        return current;
    }

    private void setKonto(SKRKonto konten) {
        this.current = konten;
        jTextField4.setText(current.getNummer());
        jTextField6.setText(current.getKlasse());
        jTextField5.setText(current.getGruppe());
        jTextArea2.setText(current.getArt());
    }
}
