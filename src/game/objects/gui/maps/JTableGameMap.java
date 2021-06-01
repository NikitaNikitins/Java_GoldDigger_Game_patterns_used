package game.objects.gui.maps;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import game.abstracts.AbstractGameMap;
import game.abstracts.AbstractGameObject;
import game.enums.ActionResult;
import game.enums.GameObjectType;
import game.enums.LocationType;
import game.interfaces.gamemap.DrawableMap;
import game.interfaces.gamemap.collections.GameCollection;
import game.movestrategies.AgressiveMoving;
import game.objects.Coordinate;
import game.objects.GoldMan;
import game.objects.Nothing;
import game.objects.Wall;
import game.objects.creators.MapCreator;
import game.objects.listeners.MoveResultListener;

public class JTableGameMap implements DrawableMap {

    private JTable jTableMap = new JTable();
    private AbstractGameMap gameMap;
    private String[] columnNames;
    // objekti, kas tiks paraadiiti kartee, tiks saglabaati divdimensiju tipa AbstractGameObject masiivaa
    // katrs masiiva elements tiks apziimeets atbilstosi objekta teksta atteelojumam, kaa aprakstiits GameObjectType
    private AbstractGameObject[][] mapObjects;

    public JTableGameMap(LocationType type, Object source, GameCollection gameCollection) {
        jTableMap.setEnabled(false);
        jTableMap.setSize(new java.awt.Dimension(300, 300));
        jTableMap.setRowHeight(26);
        jTableMap.setRowSelectionAllowed(false);
        jTableMap.setShowHorizontalLines(false);
        jTableMap.setShowVerticalLines(false);
        jTableMap.setTableHeader(null);
        jTableMap.setUpdateSelectionOnSort(false);
        jTableMap.setVerifyInputWhenFocusTarget(false);

        gameMap = MapCreator.getInstance().createMap(type, gameCollection);
        gameMap.loadMap(source);
   
        timeMover = new TimeMover();
    }


    private void fillEmptyMap(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapObjects[y][x] = new Nothing(new Coordinate(x, y));
            }
        }
    }

    private void updateObjectsArray() {

        mapObjects = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];

        fillEmptyMap(gameMap.getWidth(), gameMap.getHeight());
	
        for (AbstractGameObject gameObj : gameMap.getGameCollection().getAllGameObjects()) {
            if (!gameObj.getType().equals(GameObjectType.NOTHING)) {
                int y = gameObj.getCoordinate().getY();
                int x = gameObj.getCoordinate().getX();
                if (!(mapObjects[y][x] instanceof Nothing) &
                        !(mapObjects[y][x] instanceof Wall)) {
                    AbstractGameObject tmpObj = mapObjects[y][x];
                    mapObjects[y][x] = gameMap.getPriorityObject(tmpObj, gameObj);
                } else {
                    mapObjects[y][x] = gameObj;
                }
            }
        }
    }

    @Override
    public boolean drawMap() {

        updateObjectsArray();

        try {
            columnNames = new String[gameMap.getWidth()];

            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }

            jTableMap.setModel(new DefaultTableModel(mapObjects, columnNames));


            // katraa shunaa ir bildiite
            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public Component getMapComponent() {
        return jTableMap;
    }

    @Override
    public AbstractGameMap getGameMap() {
        return gameMap;
    }
 


    private TimeMover timeMover;

    private class TimeMover implements ActionListener, MoveResultListener {

        private Timer timer;
        private final static int MOVING_PAUSE = 500;
        private final static int INIT_PAUSE = 1000;

        private TimeMover() {
            timer = new Timer(MOVING_PAUSE, this);
            timer.setInitialDelay(INIT_PAUSE);
            timer.start();
            gameMap.getGameCollection().addMoveListener(this);
        }

        public void start() {
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gameMap.getGameCollection().moveObject(new AgressiveMoving(), GameObjectType.MONSTER);
        }

        @Override
        public void notifyActionResult(ActionResult actionResult, GoldMan goldMan) {
            switch (actionResult){
                case DIE: case WIN:{
                    timer.stop();
                    break;
                }
            }
        }
    }
 
}
