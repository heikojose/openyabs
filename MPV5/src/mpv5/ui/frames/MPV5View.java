/*
 * MPV5View.java
 */
package mpv5.ui.frames;

import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.QueryHandler;
import mpv5.globals.Messages;
import mpv5.ui.panels.ContactPanel;
import mpv5.ui.panels.DataPanel;
import mpv5.ui.parents.CloseableTabbedPane;
import mpv5.ui.parents.FadeOnChangeLabel;
import mpv5.usermanagement.User;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;

/**
 * The application's main frame.
 */
public class MPV5View extends FrameView {

    public static JFrame identifier;
    public CloseableTabbedPane tabPane;
    public static JLabel messagelabel = new JLabel();

    public static void addMessage(String message) {
        messagelabel.setText(message);
    }

    public static User getUser() {
        return new User();
    }

    public static void setWaiting(boolean tru) {
        if (tru) {
            identifier.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        } else {
            identifier.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public MPV5View(SingleFrameApplication app) {
        super(app);
        initComponents();
        tabPane = new CloseableTabbedPane();
        identifier = this.getFrame();

        messagelabel = statusMessageLabel;
        tabpanePanel.add(tabPane, BorderLayout.CENTER);

        QueryHandler.setWaitCursorFor(identifier);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpanePanel = new javax.swing.JPanel();
        naviPanel = new javax.swing.JPanel();
        jOutlookBar1 = new com.l2fprod.common.swing.JOutlookBar();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new FadeOnChangeLabel();
        progressBar = new javax.swing.JProgressBar();
        mainToolbar = new javax.swing.JToolBar();
        commonActionsToolbar = new javax.swing.JToolBar();
        jButton22 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton21 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton26 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabpanePanel.setBackground(new java.awt.Color(255, 255, 255));
        tabpanePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabpanePanel.setName("tabpanePanel"); // NOI18N
        tabpanePanel.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(tabpanePanel);

        naviPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        naviPanel.setName("naviPanel"); // NOI18N

        jOutlookBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jOutlookBar1.setName("jOutlookBar1"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(110, 400));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/agt_family.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mpv5/resources/languages/Bundle"); // NOI18N
        jButton5.setText(bundle.getString("MPV5View.jButton5.text")); // NOI18N
        jButton5.setToolTipText(bundle.getString("MPV5View.jButton5.toolTipText")); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setName("jButton5"); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/edit_group.png"))); // NOI18N
        jButton1.setText(bundle.getString("MPV5View.jButton1.text")); // NOI18N
        jButton1.setToolTipText(bundle.getString("MPV5View.jButton1.toolTipText")); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/edit_user.png"))); // NOI18N
        jButton2.setText(bundle.getString("MPV5View.jButton2.text")); // NOI18N
        jButton2.setToolTipText(bundle.getString("MPV5View.jButton2.toolTipText")); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/edit_group.png"))); // NOI18N
        jButton18.setText(bundle.getString("MPV5View.jButton18.text")); // NOI18N
        jButton18.setToolTipText(bundle.getString("MPV5View.jButton18.toolTipText")); // NOI18N
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setName("jButton18"); // NOI18N
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/agt_internet.png"))); // NOI18N
        jButton20.setText(bundle.getString("MPV5View.jButton20.text")); // NOI18N
        jButton20.setToolTipText(bundle.getString("MPV5View.jButton20.toolTipText")); // NOI18N
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setName("jButton20"); // NOI18N
        jButton20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton1, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18, 0, 0, Short.MAX_VALUE)
                .addGap(11, 11, 11))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(11, 11, 11))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20)
                .addGap(119, 119, 119))
        );

        jOutlookBar1.addTab(bundle.getString("MPV5View.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 400));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jOutlookBar1.addTab(bundle.getString("MPV5View.jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(110, 400));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jOutlookBar1.addTab(bundle.getString("MPV5View.jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(110, 400));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jOutlookBar1.addTab("Extras", jPanel6);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/lock.png"))); // NOI18N
        jButton19.setText(bundle.getString("MPV5View.jButton19.text")); // NOI18N
        jButton19.setToolTipText(bundle.getString("MPV5View.jButton19.toolTipText")); // NOI18N
        jButton19.setName("jButton19"); // NOI18N

        javax.swing.GroupLayout naviPanelLayout = new javax.swing.GroupLayout(naviPanel);
        naviPanel.setLayout(naviPanelLayout);
        naviPanelLayout.setHorizontalGroup(
            naviPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(naviPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jOutlookBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(naviPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        naviPanelLayout.setVerticalGroup(
            naviPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(naviPanelLayout.createSequentialGroup()
                .addComponent(jOutlookBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton19)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(naviPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(naviPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(bundle.getString("MPV5View.fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setText(bundle.getString("MPV5View.exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText(bundle.getString("MPV5View.jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setText(bundle.getString("MPV5View.jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        statusPanel.setName("statusPanel"); // NOI18N
        statusPanel.setPreferredSize(new java.awt.Dimension(800, 20));

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(statusMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(statusMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE))
            .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        );

        mainToolbar.setFloatable(false);
        mainToolbar.setRollover(true);
        mainToolbar.setName("mainToolbar"); // NOI18N

        commonActionsToolbar.setRollover(true);
        commonActionsToolbar.setName("commonActionsToolbar"); // NOI18N

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/revert.png"))); // NOI18N
        jButton22.setText(bundle.getString("MPV5View.jButton22.text")); // NOI18N
        jButton22.setToolTipText(bundle.getString("MPV5View.jButton22.toolTipText")); // NOI18N
        jButton22.setFocusable(false);
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton22.setName("jButton22"); // NOI18N
        jButton22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton22);

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/3floppy_unmount.png"))); // NOI18N
        jButton25.setText(bundle.getString("MPV5View.jButton25.text")); // NOI18N
        jButton25.setToolTipText(bundle.getString("MPV5View.jButton25.toolTipText")); // NOI18N
        jButton25.setFocusable(false);
        jButton25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton25.setName("jButton25"); // NOI18N
        jButton25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton25);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/filenew.png"))); // NOI18N
        jButton4.setText(bundle.getString("MPV5View.jButton4.text")); // NOI18N
        jButton4.setToolTipText(bundle.getString("MPV5View.jButton4.toolTipText")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton4);

        jSeparator1.setName("jSeparator1"); // NOI18N
        commonActionsToolbar.add(jSeparator1);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/password.png"))); // NOI18N
        jButton21.setText(bundle.getString("MPV5View.jButton21.text")); // NOI18N
        jButton21.setToolTipText(bundle.getString("MPV5View.jButton21.toolTipText")); // NOI18N
        jButton21.setFocusable(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setName("jButton21"); // NOI18N
        jButton21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton21);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/bookmark_add.png"))); // NOI18N
        jButton24.setText(bundle.getString("MPV5View.jButton24.text")); // NOI18N
        jButton24.setToolTipText(bundle.getString("MPV5View.jButton24.toolTipText")); // NOI18N
        jButton24.setFocusable(false);
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setName("jButton24"); // NOI18N
        jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton24);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/filefind.png"))); // NOI18N
        jButton29.setText(bundle.getString("MPV5View.jButton29.text")); // NOI18N
        jButton29.setToolTipText(bundle.getString("MPV5View.jButton29.toolTipText")); // NOI18N
        jButton29.setFocusable(false);
        jButton29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton29.setName("jButton29"); // NOI18N
        jButton29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        commonActionsToolbar.add(jButton29);

        jSeparator2.setName("jSeparator2"); // NOI18N
        commonActionsToolbar.add(jSeparator2);

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/edittrash.png"))); // NOI18N
        jButton26.setText(bundle.getString("MPV5View.jButton26.text")); // NOI18N
        jButton26.setToolTipText(bundle.getString("MPV5View.jButton26.toolTipText")); // NOI18N
        jButton26.setFocusable(false);
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setName("jButton26"); // NOI18N
        jButton26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        commonActionsToolbar.add(jButton26);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mpv5/resources/images/32/printer.png"))); // NOI18N
        jButton23.setText(bundle.getString("MPV5View.jButton23.text")); // NOI18N
        jButton23.setToolTipText(bundle.getString("MPV5View.jButton23.toolTipText")); // NOI18N
        jButton23.setFocusable(false);
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setName("jButton23"); // NOI18N
        jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        commonActionsToolbar.add(jButton23);

        jSeparator3.setName("jSeparator3"); // NOI18N
        commonActionsToolbar.add(jSeparator3);

        mainToolbar.add(commonActionsToolbar);

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
        setToolBar(mainToolbar);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ContactPanel tab = new ContactPanel(Context.getCustomer());
        tab.setType(ContactPanel.CUSTOMER);
        tabPane.addTab(Messages.NEW_CUSTOMER, tab);
        tabPane.setSelectedComponent(tab);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ContactPanel tab = new ContactPanel(Context.getSupplier());
        tab.setType(ContactPanel.SUPPLIER);
        tabPane.addTab(Messages.NEW_SUPPLIER, tab);
        tabPane.setSelectedComponent(tab);
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DatabaseObject dato = ((DataPanel) tabPane.getSelectedComponent()).getDataOwner();

        dato.getPanelData(((DataPanel) tabPane.getSelectedComponent()));
        dato.save();
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButton25ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButton22ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        ContactPanel tab = new ContactPanel(Context.getManufacturer());
        tab.setType(ContactPanel.MANUFACTURER);
        tabPane.addTab(Messages.NEW_MANUFACTURER, tab);
        tabPane.setSelectedComponent(tab);
    }//GEN-LAST:event_jButton18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar commonActionsToolbar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private com.l2fprod.common.swing.JOutlookBar jOutlookBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel naviPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel tabpanePanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the mainPanel
     */
    public javax.swing.JPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * @return the progressBar
     */
    public javax.swing.JProgressBar getProgressBar() {
        return progressBar;
    }

    /**
     * @return the statusMessageLabel
     */
    public javax.swing.JLabel getStatusMessageLabel() {
        return statusMessageLabel;
    }

    /**
     * @return the statusPanel
     */
    public javax.swing.JPanel getStatusPanel() {
        return statusPanel;
    }

    public void tileWin() {
//        JInternalFrame sub[];
//        int n = 0, i = 0;
//        Dimension dSize = new Dimension();
//
//        desk.getSize(dSize);
//        sub = desk.getAllFrames();
//        n = (int) dSize.height / sub.length;
//        for (i = 0; i < sub.length; i++) {
//            sub[i].setSize(dSize.width, n);
//            sub[i].setLocation(0, i * n);
//        }
    }

    public void cascadeWin() {
//        JInternalFrame sub[];
//        int n = 0, i = 0;
//        Dimension dSize = new Dimension();
//
//        desk.getSize(dSize);
//        sub = desk.getAllFrames();
//        n = (int) (dSize.width / 50);
//        for (i = 0; i < sub.length;i++) {
//            sub[i].setLocation(i * n, i * n);
//            try {
//                sub[i].setSelected(true);
//            } catch (java.beans.PropertyVetoException ev) {
//            }
//        }
    }
}
