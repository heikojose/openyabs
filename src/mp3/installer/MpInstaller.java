/*
 * mpInstaller.java
 *
 * Created on 25. Oktober 2007, 19:21
 */
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
package mp3.installer;

import java.io.IOException;
import mp3.database.util.Conn;
import de.copyleft.java.utils.cout;


import java.awt.Cursor;

import java.io.File;
import mp3.classes.interfaces.Constants;
import mp3.classes.interfaces.ProtectedStrings;
import mp3.classes.interfaces.Strings;
import mp3.classes.utils.WindowTools;
import mp3.classes.layer.Popup;
import mp3.classes.utils.DesktopIcon;
import mp3.classes.utils.DirectoryHandler;
import mp3.classes.utils.JarFinder;
import mp3.classes.utils.Log;
import mp3.classes.visual.main.license;
import mp3.classes.visual.main.mainframe;

/**
 * @author  anti43
 */
public class MpInstaller extends javax.swing.JFrame implements ProtectedStrings, Strings {

    private String url;
    private boolean update = false;
    private String workdir;

    /** Creates new form mpInstaller */
    public MpInstaller() {
        initComponents();

        new WindowTools(this);
        this.setVisible(true);
        new cout(JAVA_VERSION);

    }

    private void deleteFiles() {
        try {


            File fil = new File(workdir);
            DirectoryHandler.deleteTree(fil);



        } catch (IOException ex) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Installation");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Installation"));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setWheelScrollingEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Zun�chst muss die Datenbank erstellt werden. Anschliessend k�nnen Sie das Programm starten.\n\nLinux:\nUm einen KDE Men�eintrag anzulegen, kopieren Sie das erstellte Desktopicon als Root nach \"/opt/kde3/share/applications/kde\".\n");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jTextArea1.setRequestFocusEnabled(false);
        jTextArea1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Willkommen zur Installation der MP Rechnungs -und Kundenverwaltung!");

        jButton1.setText("Weiter");
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

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Desktopicon anlegen");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bilder/mp.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setText("Lizenz anzeigen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Sie m�ssen die Bedingungen der GPL akzeptieren, um dieses Programm verwenden zu d�rfen.");

        jCheckBox2.setText("Ich akzeptiere diese Bedingungen.");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 435, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jCheckBox1)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel3))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(jButton3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBox2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButton2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton1)))
                        .add(67, 67, 67))
                    .add(jLabel1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)
                        .add(16, 16, 16)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox1))
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3)
                    .add(jCheckBox2))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 517, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void copyFiles() {

        try {

            workdir = JarFinder.getPathOfJar(JAR_NAME);
            System.out.println("Workdir: " + workdir);

            File f = new File(USER_HOME + SEP + PROG_NAME);
            File fol = new File(USER_HOME + SEP + PROG_NAME + File.separator + LIB_DIR);
            File fil = new File(workdir + SEP + LIB_DIR);
            File fel = new File(USER_HOME + SEP + PROG_NAME + File.separator + TEMPLATES_DIR);
            File ful = new File(USER_HOME + SEP + PROG_NAME + File.separator + BACKUPS_SAVE_DIR);
            File fiil = new File(USER_HOME + SEP + PROG_NAME + File.separator + PDF);
            File feel = new File(USER_HOME + SEP + PROG_NAME + File.separator + PDF + File.separator + OFFER_SAVE_DIR);
            File fool = new File(USER_HOME + SEP + PROG_NAME + File.separator + PDF + File.separator + BILL_SAVE_DIR);
            File fuul = new File(USER_HOME + SEP + PROG_NAME + File.separator + PDF + File.separator + ARREAR_SAVE_DIR);
            File fal = new File(workdir + SEP + TEMPLATES_DIR);

            if (!f.exists() && fil.exists()) {

                if (f.mkdirs()) {
                    try {

                        Log.Debug("Libraries kopieren..", true);
                        DirectoryHandler.copyDirectory(fil, fol);
                        Log.Debug("MPv3.5 Jar kopieren..", true);
                        DirectoryHandler.copyDirectory(new File(workdir + File.separator + ProtectedStrings.JAR_NAME), new File(f.getAbsolutePath() + File.separator + ProtectedStrings.JAR_NAME));
                        Log.Debug("Verzeichnisse anlegen..", true);

                        if (fel.mkdirs() && ful.mkdirs() && fiil.mkdirs() && fool.mkdirs() && feel.mkdirs() && fuul.mkdirs()) {
                            Log.Debug("Erfolgreich!", true);
                        }

                        Log.Debug("Templates kopieren..", true);
                        DirectoryHandler.copyDirectory(fal, fel);
                        Log.Debug("Installation abgeschlossen.", true);

                    } catch (IOException ex) {
                        Log.Debug("Es ist ein Fehler aufgetreten: " + ex.getMessage(), true);
                    }
                } else {

                    Log.Debug("Es ist ein Fehler aufgetreten,\n�berpr�fen Sie Ihre Berechtigungen!", true);
                }
            }
        } catch (Exception ex) {
            Log.Debug("Es ist ein Fehler aufgetreten,\n�berpr�fen Sie Ihre Berechtigungen!\n" + ex.getMessage(), true);
        }


    }

    public static void writeDesktopIcon() {


        if (System.getProperty("os.name").contains("indows")) {
            DesktopIcon.createWindowsDesktopIcon();
        } else {

            DesktopIcon.createLinuxDesktopIcon();

        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainframe f;
        if (jCheckBox2.isSelected()) {
            // TODO add your handling code here:
            try {

                this.setCursor(new Cursor(Cursor.WAIT_CURSOR));


                if (makeDB(update)) {
                    if (jCheckBox1.isSelected()) {
                        MpInstaller.writeDesktopIcon();
                    }


                    this.copyFiles();

                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    
                    
                    new Popup("Sie k�nnen das Programm nun starten.", Popup.NOTICE);
                    System.exit(0);
                } else {

                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                new Popup(PERMISSION_DENIED, Popup.ERROR);

                //Logger.getLogger(mpInstaller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
license l = new license();
                new WindowTools(l);
                l.setVisible(rootPaneCheckingEnabled);
}//GEN-LAST:event_jButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton3;
    javax.swing.JCheckBox jCheckBox1;
    javax.swing.JCheckBox jCheckBox2;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    private boolean makeDB(boolean update) {

        url = Constants.DATABASEPATH + File.separator + Constants.DATABASENAME;
        Conn c = null;
        try {
            c = Conn.instanceOf(url, true);
        } catch (Exception ex) {
            Popup.warn(ex.getMessage(), Popup.ERROR);
        }

        return Conn.isTablesCreated();
    }
}
