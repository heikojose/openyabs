/*
 * groupsView.java
 *
 * Created on 30. Januar 2008, 21:32
 */
package mp3.classes.visual.sub;

import mp4.frames.mainframe;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import mp4.utils.windows.Position;
import mp3.classes.utils.Log;
import mp3.classes.layer.Popup;
import mp4.datenbank.verbindung.ConnectionHandler;

import mp3.classes.visual.main.*;
import mp4.klassen.objekte.ProductGroupCategory;
import mp4.klassen.objekte.ProductGroupFamily;
import mp4.klassen.objekte.ProductGroupGroup;
import mp4.klassen.objekte.ProductGroupHandler;

/**
 *
 * @author  anti43
 */
public class groupsView extends javax.swing.JFrame implements TreeSelectionListener {

    private ProductGroupHandler p;
    private ArrayList cats,  fams,  grps;
    private DefaultMutableTreeNode root,  child,  subchild,  subsubchild;
    private JTree jTree1;
    private JTree tree;
    private ProductGroupGroup grp;
    private ProductGroupFamily fag;
    private ProductGroupCategory cat;
    private boolean leaf = false;
    private boolean family = false;
    private boolean category = false;
    private mainframe frame;
    private JScrollPane jScrollPane1;

    /** Creates new form groupsView
     * @param frame 
     */
    public groupsView(mainframe frame) {
        initComponents();
        this.frame = frame;
        p = ProductGroupHandler.instanceOf();
        new Position(this);

        root = new DefaultMutableTreeNode("Produkte");
        setTreeData(false);
        tree = this.jTree1;
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);

        this.setVisible(rootPaneCheckingEnabled);
    }

    private groupsView() {
        initComponents();
        p = ProductGroupHandler.instanceOf();
        new Position(this);

        root = new DefaultMutableTreeNode("Produkte");
        setTreeData(false);

        this.setVisible(rootPaneCheckingEnabled);
    }

    /** Required by TreeSelectionListener interface.
     * @param e 
     */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) {
            leaf = false;
            family = false;
            category = false;
            return;
        }

        jTextField4.setText(e.getNewLeadSelectionPath().toString());
        Object nodeInfo = node.getUserObject();

        if (nodeInfo.getClass().isInstance(new ProductGroupGroup(ConnectionHandler.instanceOf()))) {
            grp = (ProductGroupGroup) nodeInfo;
            leaf = true;
            family = false;
            category = false;

        } else if (nodeInfo.getClass().isInstance(new ProductGroupFamily(ConnectionHandler.instanceOf()))) {
            fag = (ProductGroupFamily) nodeInfo;
            leaf = false;
            family = true;
            category = false;

        } else if (nodeInfo.getClass().isInstance(new ProductGroupCategory(ConnectionHandler.instanceOf()))) {
            cat = (ProductGroupCategory) nodeInfo;
            leaf = false;
            family = false;
            category = true;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Warengruppenmanager");

        jLabel1.setText("Neue Kategorie");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Einf�gen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Neue Produktfamilie");

        jButton2.setText("Einf�gen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Neue Produktgruppe");

        jButton3.setText("Einf�gen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("L�schen");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Zu aktuellem Produkt");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Warengruppe (Pfad)");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Warengruppen"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton6.setText("Alle l�schen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Schlie�en");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

        if (leaf) {
//            frame.getProductsView().getProduct().setWarengruppenId(grp.getId());
//            frame.getProductsView().setCurrentProductGroup(grp.getId());
//            frame.getProductsView().getJTextField12().setText(frame.getProductsView().getProduct().getProductgroupPath());
            this.dispose();
        } else {
            Popup.notice("Sie m�ssen eine Produktgruppe ausw�hlen");
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (leaf) {
            grp.destroy();
            setTreeData(true);

        } else if (family) {

            fag.destroy();
            setTreeData(true);
        } else if (category) {

            cat.destroy();
            setTreeData(true);
        } else {

            Log.Debug("Nichts ausgew�hlt.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!jTextField1.getText().equals("")) {
            ProductGroupCategory gr = new ProductGroupCategory(ConnectionHandler.instanceOf());
            gr.setName(jTextField1.getText());
            gr.save();

            ProductGroupFamily fg = new ProductGroupFamily(ConnectionHandler.instanceOf());
            fg.setName("Default");
            fg.setKategorieid(gr.getId());
            fg.save();

            ProductGroupGroup gj = new ProductGroupGroup(ConnectionHandler.instanceOf());
            gj.setName("Default");
            gj.setFamilienid(fg.getId());
            gj.save();

            setTreeData(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (category) {
            if (!jTextField2.getText().equals("")) {
                ProductGroupFamily fg = new ProductGroupFamily(ConnectionHandler.instanceOf());
                fg.setName(jTextField2.getText());
                fg.setKategorieid(cat.getId());
                fg.save();

                ProductGroupGroup gj = new ProductGroupGroup(ConnectionHandler.instanceOf());
                gj.setName("Default");
                gj.setFamilienid(fg.getId());
                gj.save();
                setTreeData(true);
            }
        } else {
            Popup.notice("Sie m�ssen eine Kategorie w�hlen");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (family) {
            if (!jTextField3.getText().equals("")) {
                ProductGroupGroup gj = new ProductGroupGroup(ConnectionHandler.instanceOf());
                gj.setName(jTextField3.getText());
                gj.setFamilienid(fag.getId());
                gj.save();
                setTreeData(true);
            }

        } else {
            Popup.notice("Sie m�ssen eine Produktfamilie w�hlen");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        this.p.deleteAll();
        this.setTreeData(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
}//GEN-LAST:event_jButton5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    public void setTreeData(boolean refresh) {
        this.jTree1 = null;
        jPanel1.removeAll();
        jPanel1.validate();
        jPanel1.updateUI();

        child = null;
        subchild = null;
        subsubchild = null;
        root = new DefaultMutableTreeNode("Produkte");


        cats = p.getCats(refresh);

        for (int i = 0; i < cats.size(); i++) {

            child = new DefaultMutableTreeNode(
                    cats.get(i));

            fams = p.getFams(((ProductGroupCategory) cats.get(i)).getID());
            for (int b = 0; b < fams.size(); b++) {

                subchild = new DefaultMutableTreeNode(
                        fams.get(b));
                grps = p.getGrps(((ProductGroupFamily) fams.get(b)).getID());
                for (int h = 0; h < grps.size(); h++) {

                    subsubchild = new DefaultMutableTreeNode(
                            grps.get(h));
                    subchild.add(subsubchild);
                }
                child.add(subchild);
            }
            root.add(child);
        }

        this.jTree1 = new JTree(root);
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(jTree1);
        jScrollPane1.validate();

        tree = this.jTree1;
        TreeModel model = tree.getModel();
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);
        tree.setExpandsSelectedPaths(true);

        this.jPanel1.add(jScrollPane1, BorderLayout.CENTER);
        this.validate();
    }

    /**
     * Expands a given node in a JTree.
     *
     * @param tree      The JTree to expand.
     * @param model     The TreeModel for tree.     
     * @param node      The node within tree to expand.     
     * @param row       The displayed row in tree that represents
     *                  node.     
     * @param depth     The depth to which the tree should be expanded. 
     *                  Zero will just expand node, a negative
     *                  value will fully expand the tree, and a positive
     *                  value will recursively expand the tree to that
     *                  depth relative to node.
     * @return 
     */
    public int expandJTreeNode(javax.swing.JTree tree,
            javax.swing.tree.TreeModel model,
            Object node, int row, int depth) {
        if (node != null && !model.isLeaf(node)) {
            tree.expandRow(row);
            if (depth != 0) {
                for (int index = 0;
                        row + 1 < tree.getRowCount() &&
                        index < model.getChildCount(node);
                        index++) {
                    row++;
                    Object chil1 = model.getChild(node, index);
                    if (chil1 == null) {
                        break;
                    }
                    javax.swing.tree.TreePath path;
                    while ((path = tree.getPathForRow(row)) != null &&
                            path.getLastPathComponent() != chil1) {
                        row++;
                    }
                    if (path == null) {
                        break;
                    }
                    row = expandJTreeNode(tree, model, chil1, row, depth - 1);
                }
            }
        }
        return row;
    } // expandJTreeNode()

}
