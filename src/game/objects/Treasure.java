package game.objects;

import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;

public class Treasure extends AbstractGameObject {

    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/game/images/gold.png"));
    }
    
    
    private int score = 5;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

