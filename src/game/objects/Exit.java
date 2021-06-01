package game.objects;

import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;

public class Exit extends AbstractGameObject {

    public Exit(Coordinate coordinate) {
        super.setType(GameObjectType.EXIT);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/game/images/exit.gif"));
    }
}
