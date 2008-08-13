/*
 * customers.java
 *
 * Created on 28. Dezember 2007, 19:17
 */
package mp3.classes.visual.sub;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import mp3.classes.objects.ungrouped.HistoryHandler;
import javax.swing.table.DefaultTableModel;
import mp3.classes.interfaces.Constants;

import mp3.classes.interfaces.Strings;
import mp3.classes.utils.FileReaderWriter;
import mp3.classes.utils.Log;
import mp3.classes.layer.Popup;
import mp4.datenbank.verbindung.ConnectionHandler;
//import mp3.classes.objects.ungrouped.History;
//import mp3.classes.objects.ungrouped.MyData;
import mp4.utils.files.FileDirectoryHandler;
import mp3.classes.utils.Formater;
import mp3.classes.utils.UnZip;
import mp3.classes.utils.Zip;
import mp4.frames.mainframe;
import mp4.einstellungen.Einstellungen;
import mp4.klassen.objekte.HistoryItem;


/**
 *
 * @author  anti43
 */
public class backupView extends javax.swing.JPanel{ 
    private String[][] liste;
    private String[] header;
    private mainframe mainframe;
    private Thread t;
    private String savepath;
    private ArrayList lstFiles;
    private File src;
    private Einstellungen l;
    private String[][] str;
    private SimpleDateFormat df;
    private FileReaderWriter rw;
    private SimpleDateFormat df2;
    private String[] dat;

    /** Creates new form customers
     * @param aThis 
     */
    public backupView(mainframe aThis) {
        initComponents();

        mainframe = aThis;
        l = Einstellungen.instanceOf();
        header = new String[]{"id", "Datum", "Datei"};
        jTextField1.setText(l.getBackupverz());
        this.savepath = l.getBackupverz();


        df = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        df2 = new SimpleDateFormat("dd. MMMMMMMM yyyy HH:mm:ss");

        this.validateTable();
        
           rw = new FileReaderWriter(Constants.SETTINGS_FILE);
            
           dat = rw.read().split(";");


    }

    private JTable getJTable1() {
        return jTable1;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel1.setText("Backup");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jLabel2.setText("Verf�gbare Sicherungsdateien:");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "Datei"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Pfad");

        jButton3.setText("w�hlen..");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        jButton6.setText("Sicherung anlegen");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setText("zur�ckspielen");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void saving() {
            String store, path;
        String savefile;

        try {

            path = dat[0] + File.separator + Constants.DATABASENAME;
            store = l.getBackupverz();

            savefile = store + File.separator + df.format(new Date()) + ".mpsavefile-35.zip";


            if (store.equals("")) {
                store = Constants.HOME + File.separator + Constants.DATABASENAME;
            }

            Log.Debug("Anlegen einer Sicherungsdatei:\nZiel: " + savefile, true);

            this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            Zip.zip(path, savefile);
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            mainframe.setMessage("Sicherungsdatei '" + savefile + "' angelegt.");
            new HistoryItem(ConnectionHandler.instanceOf(), Strings.BACKUP, "Sicherungsdatei " + savefile + " angelegt.");
        } catch (Exception ex) {
            Log.Debug(ex.getMessage(), true);
        }
        this.validateTable();
        
        
    }
    private void setSavePath(String path) {
        this.savepath = path;
        validateTable();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            jTextField1.setText(fc.getSelectedFile().toString());

            setSavePath(fc.getSelectedFile().toString());
        }

        l.setBackupverz(jTextField1.getText());
        l.save();

        l = Einstellungen.instanceOf();

        mainframe.setMessage("Sicherungspfad '" + l.getBackupverz() + "' gespeichert");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      

       
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
                saving();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked



        boolean idOk = true;
        Integer id = 0;


        try {
            id = Integer.valueOf((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        } catch (Exception numberFormatException) {
            idOk = false;
            Popup.notice("Sie m�ssen eine Sicherungsdatei ausw�hlen.");
        }

        File path;

        String store = "";




        if (idOk) {
            if ((JOptionPane.showConfirmDialog(this, "M�glicherweise vorhandene neuere Daten,\n " +
                    "die Sie seit der Sicherung angelegt haben, werden gel�scht!\n " +
                    "Vor dem Ersetzen wird eine Sicherheitskopie des aktuellen Datenbestandes angelegt.\n " +
                    "Wollen Sie wirklich die Sicherungsdatei vom * " + str[id][1] + " * zur�ckspielen?",
                    "Sicher?", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {


                jButton6MouseClicked(evt);



                try {




                    File olddb = new File(dat[0] + File.separator + Constants.DATABASENAME);

                    path = new File(dat[0]);
                    store = path.getCanonicalPath() + File.separator + Constants.DATABASENAME;
                    Log.Debug("Zur�ckspielen einer Sicherungsdatei:\nZiel: " + store, true);

                    FileDirectoryHandler.deleteTree(olddb);
//                int z =path.getCanonicalPath().lastIndexOf(File.separator);
//                store =store.substring(0, z);
                    Log.Debug("R�cksichern nach: " + store, true);

                    UnZip.deflate(str[id][2], store);

                    mainframe.setMessage("Sicherungsdatei '" + str[id][2] + "' wiederhergestellt.");

                    new Popup("Starten Sie das Programm neu.", Popup.NOTICE);
                    
                    System.exit(0);
                    



                } catch (IOException ex) {
                    Log.Debug(ex.getMessage(), true);
                }
            }
        }
    }//GEN-LAST:event_jButton7MouseClicked
    /**
     * 
     * @param current
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    

    private void validateTable() {


        try {
            this.lstFiles = new ArrayList();
            this.src = new File(this.savepath);

            Log.Debug("Backup Verzeichnis: " + src, true);

            File[] files = src.listFiles();
            Log.Debug("Dateien analysieren...", true);
            str = new String[files.length][3];

            for (int i = 0,  k = 0; i < files.length; i++) {

//                Log.Debug("Datei analysieren: " + files[i].getName());
                if (files[i].isFile() && files[i].toString().contains("mpsavefile-35")) {

                    try {
                        str[k][0] = String.valueOf(k);
                        str[k][1] = df2.format(df.parse(files[i].getName().substring(0, 18)));
                        str[k][2] = files[i].getCanonicalPath();
                        Log.Debug("Sicherungsdatei gefunden: " + files[i].getName(), true);
                        k++;
                    } catch (Exception ex) {

//                        Log.Debug(ex);
                        Log.Debug(ex.getMessage(), true);
                    }

                }

            }
            if (files.length == 0) {

                str[0][0] = "Keine Datei vorhanden";
            }
        } catch (Exception exception) {
//            Log.Debug(exception);
//            Log.Debug(exception.getMessage(), true);
        }


        jTable1.setModel(new DefaultTableModel(str, header));

        l.stripFirst(jTable1);

        Formater.format(jTable1, 1, 180);



    }
}
