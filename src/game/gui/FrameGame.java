package game.gui;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import game.enums.ActionResult;
import game.enums.GameObjectType;
import game.enums.MovingDirection;
import game.interfaces.gamemap.DrawableMap;
import game.objects.GoldMan;
import game.objects.listeners.MoveResultListener;
import game.utils.MessageManager;


public class FrameGame extends BaseChildFrame implements ActionListener, KeyListener, MoveResultListener {

    private DrawableMap map; // sutiisim kartes objektu, kas var zimeet

    /**
     * Creates new form FrameGame
     */
    public FrameGame() {
        initComponents();
    }

    public void setMap(DrawableMap gameMap) {
        this.map = gameMap;
        gameMap.drawMap();

        gameMap.getGameMap().getGameCollection().addMoveListener(this);

        jlabelTurnsLeft.setText(String.valueOf(gameMap.getGameMap().getTimeLimit()));
        jPanelMap.removeAll();
        jPanelMap.add(gameMap.getMapComponent());
    }
    
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanelMap = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnLeft = new javax.swing.JButton();
        jbtnUp = new javax.swing.JButton();
        jbtnRight = new javax.swing.JButton();
        jbtnDown = new javax.swing.JButton();
        jlabelScoreText = new javax.swing.JLabel();
        jlabelTurnsLeftText = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jlabelScore = new javax.swing.JLabel();
        jlabelTurnsLeft = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuFile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("FrameGame"); // NOI18N
        addKeyListener(this);

        jPanelMap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMap.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/left.png"))); // NOI18N
        jbtnLeft.setName("jbtnLeft"); // NOI18N
        jbtnLeft.addActionListener(this);

        jbtnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/up.png"))); // NOI18N
        jbtnUp.setName("jbtnUp"); // NOI18N
        jbtnUp.addActionListener(this);

        jbtnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/right.png"))); // NOI18N
        jbtnRight.setName("jbtnRight"); // NOI18N
        jbtnRight.addActionListener(this);

        jbtnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/down.png"))); // NOI18N
        jbtnDown.setName("jbtnDown"); // NOI18N
        jbtnDown.addActionListener(this);

        jlabelScoreText.setText("Points count:");
        jlabelScoreText.setName("jlabelScoreText"); // NOI18N

        jlabelTurnsLeftText.setText("Moves left:");
        jlabelTurnsLeftText.setToolTipText("");
        jlabelTurnsLeftText.setName("jlabelTurnsLeftText"); // NOI18N

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/images/save.png"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnSave.setName("jbtnUp"); // NOI18N
        jbtnSave.addActionListener(this);

        jbtnExit.setIcon(new ImageIcon(getClass().getResource("/game/images/exit.png"))); // NOI18N
        jbtnExit.setText("Exit game");
        jbtnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnExit.setName("jbtnUp"); // NOI18N
        jbtnExit.addActionListener(this);

        jlabelScore.setText("0");
        jlabelScore.setName("jlabelScore"); // NOI18N

        jlabelTurnsLeft.setText("0");
        jlabelTurnsLeft.setToolTipText("");
        jlabelTurnsLeft.setName("jlabelTurnsLeft"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelScoreText)
                    .addComponent(jlabelTurnsLeftText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTurnsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelScoreText)
                    .addComponent(jlabelScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelTurnsLeftText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTurnsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMap, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmenuFile.setText("File");
        jmenuFile.setName("jmenuFile"); // NOI18N

        jMenuItem1.setText("Save game");
        jmenuFile.add(jMenuItem1);

        jMenuItem2.setText("Exit game");
        jMenuItem2.setActionCommand("Exit");
        jmenuFile.add(jMenuItem2);

        jMenuBar1.add(jmenuFile);

        jMenu2.setText("Service");

        jMenuItem3.setText("Statistics");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-534)/2, (screenSize.height-397)/2, 534, 397);
    }

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jbtnLeft) {
            FrameGame.this.jbtnLeftActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnUp) {
            FrameGame.this.jbtnUpActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnRight) {
            FrameGame.this.jbtnRightActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnDown) {
            FrameGame.this.jbtnDownActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnSave) {
            FrameGame.this.jbtnSaveActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnExit) {
            FrameGame.this.jbtnExitActionPerformed(evt);
        }
    }

    public void keyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getSource() == FrameGame.this) {
            FrameGame.this.formKeyPressed(evt);
        }
    }

    public void keyReleased(java.awt.event.KeyEvent evt) {
    }

    public void keyTyped(java.awt.event.KeyEvent evt) {
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpActionPerformed
        moveObject(MovingDirection.UP, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnUpActionPerformed

    private void jbtnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLeftActionPerformed
        moveObject(MovingDirection.LEFT, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnLeftActionPerformed

    private void jbtnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDownActionPerformed
        moveObject(MovingDirection.DOWN, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnDownActionPerformed

    private void jbtnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRightActionPerformed
        moveObject(MovingDirection.RIGHT, GameObjectType.GOLDMAN);
    }//GEN-LAST:event_jbtnRightActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    }//GEN-LAST:event_formKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JButton jbtnDown;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLeft;
    private javax.swing.JButton jbtnRight;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnUp;
    private javax.swing.JLabel jlabelScore;
    private javax.swing.JLabel jlabelScoreText;
    private javax.swing.JLabel jlabelTurnsLeft;
    private javax.swing.JLabel jlabelTurnsLeftText;
    private javax.swing.JMenu jmenuFile;
    // End of variables declaration//GEN-END:variables

    private void moveObject(MovingDirection movingDirection, GameObjectType gameObjectType) {
        map.getGameMap().getGameCollection().moveObject(movingDirection, gameObjectType);
    }

    private void gameFinished(String message) {
        MessageManager.showInformMessage(null, message);
        closeFrame();
    }

    
    private static final String DIE_MESSAGE="You lose!";
    private static final String WIN_MESSAGE="You lose! Points count:";
    
    @Override
    public void notifyActionResult(ActionResult actionResult, GoldMan goldMan) {

        switch (actionResult) {
            case MOVE: {
                jlabelTurnsLeft.setText(String.valueOf(map.getGameMap().getTimeLimit() - goldMan.getTurnsNumber()));

                if (goldMan.getTurnsNumber() >= map.getGameMap().getTimeLimit()) {
                    gameFinished(DIE_MESSAGE);
                }

                break;
            }

            case DIE: {
                gameFinished(DIE_MESSAGE);
                break;
            }
                
            case WIN:{
                gameFinished(WIN_MESSAGE+goldMan.getTotalScore());
            }


            case COLLECT_TREASURE: {
                jlabelScore.setText(String.valueOf(goldMan.getTotalScore()));
                break;
            }
        }

        map.drawMap();

    }
}
