package game.interfaces.gameobjects;

import javax.swing.ImageIcon;

import game.enums.GameObjectType;
import game.objects.Coordinate;

public interface StaticObject {
	 
    ImageIcon getIcon();

    Coordinate getCoordinate();

    GameObjectType getType();        
}
