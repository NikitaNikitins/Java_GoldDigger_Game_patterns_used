package game.objects;

import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;

public class Wall extends AbstractGameObject{

    public Wall(Coordinate coordinate) {
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);
        
        super.setIcon(getImageIcon("/game/images/wall.png"));

    }
}

