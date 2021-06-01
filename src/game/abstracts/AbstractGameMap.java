package game.abstracts;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import game.interfaces.gamemap.GameMap;
import game.interfaces.gamemap.collections.GameCollection;

/**
 * basic karte
 */
public abstract class AbstractGameMap implements GameMap, Serializable { // Serializable ir vajadziigs lai saglabaat kartes objektu, lai buutu iespeejams saglabaat un restore speeli

    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private int timeLimit;
    private String name;
    private boolean exitExist;
    private boolean goldManExist;
    private GameCollection gameCollection;

    public AbstractGameMap() {
    }

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    public boolean isExitExist() {
        return exitExist;
    }

    public void setExitExist(boolean isExitExist) {
        this.exitExist = isExitExist;
    }

    public boolean isGoldManExist() {
        return goldManExist;
    }

    public void setGoldManExist(boolean isGoldManExist) {
        this.goldManExist = isGoldManExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        // objekta prioritaate ir atkariiga no indeksa numura 
        return (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) ? firstObject : secondObject; 
    }

    public boolean isValidMap() {
        return goldManExist && exitExist; // ja ir enter and exit karte ir pareiza
    }

    public GameCollection getGameCollection() {
        if (gameCollection == null) {
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

   
}