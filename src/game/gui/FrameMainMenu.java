package game.gui;

import game.enums.LocationType;
import game.interfaces.gamemap.collections.MapCollection;
import game.objects.gui.maps.JTableGameMap;

public class FrameMainMenu extends javax.swing.JFrame {

    private FrameGame frameGame;
    private FrameStat frameStat = new FrameStat();
    private FrameSavedGames frameLoadGame = new FrameSavedGames();
    

    /**
     * Creates new form FrameMainMenu
     */
    public FrameMainMenu() {
        initComponents();
    }

    private void initComponents() {

        jpnlMainMenu = new javax.swing.JPanel();
        jbtnNewGame = new javax.swing.JButton();
        jbtnLoadGame = new javax.swing.JButton();
        jbtnStatistics = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setName("FrameMainMenu"); // NOI18N
        setResizable(false);

        jpnlMainMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbtnNewGame.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/new.png"))); // NOI18N
        jbtnNewGame.setText("New game");
        jbtnNewGame.setToolTipText("Start new game");
        jbtnNewGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnNewGame.setIconTextGap(10);
        jbtnNewGame.addActionListener(formListener);

        jbtnLoadGame.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/load.png"))); // NOI18N
        jbtnLoadGame.setText("Load game");
        jbtnLoadGame.setToolTipText("Load saved game ");
        jbtnLoadGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnLoadGame.setIconTextGap(10);
        jbtnLoadGame.addActionListener(formListener);

        jbtnStatistics.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/stat.png"))); // NOI18N
        jbtnStatistics.setText("Statistics");
        jbtnStatistics.setToolTipText("Show players statistics");
        jbtnStatistics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnStatistics.setIconTextGap(10);
        jbtnStatistics.addActionListener(formListener);

        jbtnExit.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/exit.png"))); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setToolTipText("Exit game");
        jbtnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnExit.setIconTextGap(10);
        jbtnExit.addActionListener(formListener);

        javax.swing.GroupLayout jpnlMainMenuLayout = new javax.swing.GroupLayout(jpnlMainMenu);
        jpnlMainMenu.setLayout(jpnlMainMenuLayout);
        jpnlMainMenuLayout.setHorizontalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnLoadGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlMainMenuLayout.setVerticalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-267)/2, (screenSize.height-310)/2, 267, 310);
    }

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jbtnNewGame) {
                FrameMainMenu.this.jbtnNewGameActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnLoadGame) {
                FrameMainMenu.this.jbtnLoadGameActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnStatistics) {
                FrameMainMenu.this.jbtnStatisticsActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnExit) {
                FrameMainMenu.this.jbtnExitActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewGameActionPerformed
        if (frameGame==null){
            frameGame = new FrameGame();
        }
        frameGame.setMap(new JTableGameMap(LocationType.FS, "game.map", new MapCollection()));
        frameGame.showFrame(this);
    }//GEN-LAST:event_jbtnNewGameActionPerformed

    private void jbtnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStatisticsActionPerformed
        frameStat.showFrame(this);
    }//GEN-LAST:event_jbtnStatisticsActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        quit();
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoadGameActionPerformed
        frameLoadGame.showFrame(this);
    }//GEN-LAST:event_jbtnLoadGameActionPerformed

    //iZIET NO splees
    private void quit() {
        System.exit(0);// Not recommended, cause there can exist other processes

    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMainMenu().setVisible(true);
            }
        });
    }
    
    javax.swing.JButton jbtnExit;
    javax.swing.JButton jbtnLoadGame;
    javax.swing.JButton jbtnNewGame;
    javax.swing.JButton jbtnStatistics;
    javax.swing.JPanel jpnlMainMenu;
}
