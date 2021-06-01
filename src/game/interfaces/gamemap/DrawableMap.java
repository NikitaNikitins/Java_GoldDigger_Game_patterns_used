package game.interfaces.gamemap;

import java.awt.Component;

import game.abstracts.AbstractGameMap;

public interface DrawableMap {
    
    Component getMapComponent();
    
    AbstractGameMap getGameMap();
    
    boolean drawMap();    
}
