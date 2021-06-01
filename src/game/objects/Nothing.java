package game.objects;

import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;

public class Nothing extends AbstractGameObject {

    public Nothing(Coordinate coordinate) {
        super.setType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
        super.setIcon(null);

    }
}
